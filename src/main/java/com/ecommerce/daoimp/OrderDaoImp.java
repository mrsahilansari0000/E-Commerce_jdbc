package com.ecommerce.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.config.DBconfig;
import com.ecommerce.constants.OrderQueries;
import com.ecommerce.dao.OrderDao;
import com.ecommerce.model.Order;
import com.ecommerce.model.OrderItem;

public class OrderDaoImp implements OrderDao
{
	@Override
	public long createOrder(Order order) {

		try {

			Connection connection = DBconfig.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(OrderQueries.INSERT_ORDER,
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setLong(1, order.getUserId());
			preparedStatement.setDouble(2, order.getTotalAmount());

			int rowsAffected = preparedStatement.executeUpdate();

			if (rowsAffected > 0) {

				ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

				if (generatedKeys.next()) {

					return generatedKeys.getLong(1);

				}

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return -1;
	}
	
	@Override
	public boolean createOrderItem(OrderItem orderItem) {

	    try {

	        Connection connection = DBconfig.getConnection();

	        PreparedStatement preparedStatement = connection.prepareStatement(OrderQueries.INSERT_ORDER_ITEM);

	        preparedStatement.setLong(1, orderItem.getOrderId());
	        preparedStatement.setLong(2, orderItem.getProductId());
	        preparedStatement.setInt(3, orderItem.getQuantity());
	        preparedStatement.setDouble(4, orderItem.getPrice());
	        preparedStatement.setDouble(5, orderItem.getSubtotal());

	        int rowsAffected = preparedStatement.executeUpdate();

	        preparedStatement.close();

	        return rowsAffected > 0;

	    } catch (SQLException e) {

	        e.printStackTrace();
	    }

	    return false;
	}
	
	@Override
	public Order getOrderById(long orderId) {

	    Order order = null;

	    try {

	        Connection connection = DBconfig.getConnection();

	        PreparedStatement preparedStatement =
	                connection.prepareStatement(OrderQueries.GET_ORDER_BY_ID);

	        preparedStatement.setLong(1, orderId);

	        ResultSet resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) {

	            order = new Order();

	            order.setOrderId(resultSet.getLong("order_id"));
	            order.setUserId(resultSet.getLong("user_id"));
	            order.setOrderDate(resultSet.getTimestamp("order_date").toLocalDateTime());
	            order.setTotalAmount(resultSet.getDouble("total_amount"));
	            order.setStatus(resultSet.getString("status"));
	            order.setPaymentStatus(resultSet.getString("payment_status"));
	            order.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
	            order.setUpdatedAt(resultSet.getTimestamp("updated_at").toLocalDateTime());

	        }

	        resultSet.close();
	        preparedStatement.close();

	    } catch (SQLException e) {

	        e.printStackTrace();

	    }

	    return order;
	}
	
	@Override
	public List<Order> getOrdersByUserId(long userId) {

	    List<Order> orderList = new ArrayList<>();

	    try {

	        Connection connection = DBconfig.getConnection();

	        PreparedStatement preparedStatement =
	                connection.prepareStatement(OrderQueries.GET_ORDER_BY_USER_ID);

	        preparedStatement.setLong(1, userId);

	        ResultSet resultSet = preparedStatement.executeQuery();

	        while (resultSet.next()) {

	            Order order = new Order();

	            order.setOrderId(resultSet.getLong("order_id"));
	            order.setUserId(resultSet.getLong("user_id"));
	            order.setOrderDate(resultSet.getTimestamp("order_date").toLocalDateTime());
	            order.setTotalAmount(resultSet.getDouble("total_amount"));
	            order.setStatus(resultSet.getString("status"));
	            order.setPaymentStatus(resultSet.getString("payment_status"));
	            order.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
	            order.setUpdatedAt(resultSet.getTimestamp("updated_at").toLocalDateTime());

	            orderList.add(order);

	        }

	        resultSet.close();
	        preparedStatement.close();

	    } catch (SQLException e) {

	        e.printStackTrace();

	    }

	    return orderList;
	}
	
	@Override
	public List<OrderItem> getOrderItems(long orderId) {

	    List<OrderItem> orderItemList = new ArrayList<>();

	    try {

	        Connection connection = DBconfig.getConnection();

	        PreparedStatement preparedStatement =
	                connection.prepareStatement(OrderQueries.GET_ORDER_ITEMS);

	        preparedStatement.setLong(1, orderId);

	        ResultSet resultSet = preparedStatement.executeQuery();

	        while (resultSet.next()) {

	            OrderItem orderItem = new OrderItem();

	            orderItem.setOrderItemId(resultSet.getLong("order_item_id"));
	            orderItem.setOrderId(resultSet.getLong("order_id"));
	            orderItem.setProductId(resultSet.getLong("product_id"));
	            orderItem.setQuantity(resultSet.getInt("quantity"));
	            orderItem.setPrice(resultSet.getDouble("price"));
	            orderItem.setSubtotal(resultSet.getDouble("subtotal"));
	            orderItem.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());

	            orderItemList.add(orderItem);

	        }

	        resultSet.close();
	        preparedStatement.close();

	    } catch (SQLException e) {

	        e.printStackTrace();

	    }

	    return orderItemList;
	}
	
	@Override
	public boolean updateOrderStatus(long orderId, String status) {

	    try {

	        Connection connection = DBconfig.getConnection();

	        PreparedStatement preparedStatement =
	                connection.prepareStatement(OrderQueries.UPDATE_ORDER_STATUS);

	        preparedStatement.setString(1, status);
	        preparedStatement.setLong(2, orderId);

	        int rowsAffected = preparedStatement.executeUpdate();

	        preparedStatement.close();

	        return rowsAffected > 0;

	    } catch (SQLException e) {

	        e.printStackTrace();

	    }

	    return false;
	}
	
	@Override
	public boolean cancelOrder(long orderId, long userId) {

	    try {

	        Connection connection = DBconfig.getConnection();

	        PreparedStatement preparedStatement =
	                connection.prepareStatement(OrderQueries.CANCEL_ORDER);

	        preparedStatement.setLong(1, orderId);
	        preparedStatement.setLong(2, userId);

	        int rowsAffected = preparedStatement.executeUpdate();

	        preparedStatement.close();

	        return rowsAffected > 0;

	    } catch (SQLException e) {

	        e.printStackTrace();

	    }

	    return false;
	}
	
	
}