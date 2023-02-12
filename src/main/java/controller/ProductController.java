package controller;

import Entity.Product;
import Service.ProductService;
import configuration.ProductDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductService productService;


    @PostMapping("/add")
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto){

        Product product= modelMapper.map(productDto,Product.class);
        Product insertedProduct =  productService.createProduct(product);
        return new ResponseEntity<>(insertedProduct, HttpStatus.OK);

    }

    @GetMapping("/get/{productId}")
    public ResponseEntity<Product>  getProductBasedOnId(@PathVariable Long productId){
        Product productObject =productService.getProductBasedOnId(productId);
        return new ResponseEntity<>(productObject, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Product>>  getAllProducts(){
        List<Product> listOfProducts=productService.getAllProducts();
        return new ResponseEntity<>(listOfProducts, HttpStatus.OK);
    }



    @PutMapping("/update/{productId}")
    public ResponseEntity<Product>  updateProduct(@PathVariable Long productId, @RequestBody ProductDto productDto) {

        Product productObject =productService.getProductBasedOnId(productId);
        productObject.setProductName(productDto.getProductName());
        // productObject.getProductCategory(productDto.se)
        productObject.setProductDescription(productDto.getProductDescription());
        productObject.setQuantity(productDto.getQuantity());

        Product updatedProduct=productService.updateProduct(productObject);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);


    }




    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<String>  deleteProductBasedOnId(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);

    }




}
