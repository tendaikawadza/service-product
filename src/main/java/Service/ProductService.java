package Service;


import Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductBasedOnId(Long productId) {
        return productRepository.findById(productId).get();
    }

    public Product updateProduct(Product productObject) {
        return productRepository.save(productObject);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}




