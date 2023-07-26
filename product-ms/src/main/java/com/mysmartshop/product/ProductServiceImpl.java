package com.mysmartshop.product;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 



 
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepo;

 
    @Override
    public List<Product> getAvailableProducts() {
        return productRepo.findAll();
    }

 
    @Override
    public Product getProductDetails(String productId) {
        return productRepo.findById(productId).get();
    }

 
    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

 
    @Override
    public void removeProduct(String productId) {
        productRepo.deleteById(productId);

    }

}