package com.ecommerce.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ecommerce.daoimp.ProductDaoImp;
import com.ecommerce.model.Product;

class ProductDaoTest {

    private ProductDao productDao;

    @BeforeEach
    void setUp() {
        productDao = new ProductDaoImp();
    }

    @Test
    void testViewAvailableProducts() {

        List<Product> products = productDao.viewAvailableProducts();

        assertNotNull(products);
        assertFalse(products.isEmpty());

    }
    
    @Test
    void testDisplayProductDetails() {

        Product product = productDao.displayProductDetails(78);
        assertNotNull(product);
        assertEquals(78, product.getProductId());

    }
    
    @Test
    void testDisplayProductDetails_InvalidId() {

        Product product = productDao.displayProductDetails(9999);

        assertNull(product);

    }
    
    @Test
    void testShowAvailableStock() {

        int stock = productDao.showAvailableStock(78);

        assertTrue(stock >= 0);

    }
    
    @Test
    void testShowAvailableStock_InvalidId() {

        int stock = productDao.showAvailableStock(9999);

        assertEquals(-1, stock);

    }

}