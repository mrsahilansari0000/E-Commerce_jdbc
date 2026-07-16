package com.ecommerce.exceptions;

public class EmptyCartException extends RuntimeException
{

	public EmptyCartException(String string) {
		super(string);
	}

}
