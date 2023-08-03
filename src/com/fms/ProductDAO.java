package com.fms;

import java.util.List;

public interface ProductDAO {
    List<Product> getAllProducts();
    Product getProductById(int productId);
    List<Product> getProductsByUserId(int userId); 
}