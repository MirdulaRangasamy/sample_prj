package com.sample.sample_prj.exception;

public class ProductNotFoundException extends Exception{

	@Override
	public String toString() {
		return "Product Not Found...";
	}
	
}
