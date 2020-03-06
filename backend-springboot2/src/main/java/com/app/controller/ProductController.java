package com.app.controller;

import java.util.*;

import com.app.entities.Product;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.ProductRepository;
import com.app.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long productId)
            throws ResourceNotFoundException {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));
        return ResponseEntity.ok().body(product);
    }

    @PostMapping("/products")
    public Product createProduct(@Valid @RequestBody Product product) {
        return productRepository.save(product);
    }

//    @PostMapping("/products/{id}")
//    public ResponseEntity<Product> ProductToCart(@PathVariable(value = "id") Long productId,
//                                                 @Valid @RequestBody Product productDetails) throws ResourceNotFoundException {
//
//        Product product = productRepository.findById(productId)
//                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));
//
////        product.setName(productDetails.getName());
////        product.setDescription(productDetails.getDescription());
////        product.setPrice(productDetails.getPrice());
////        product.setExpiration(productDetails.getExpiration());
//        final Product ProductInCart = ShoppingCartRepository.save(product);
//        return ResponseEntity.ok(ProductInCart);
//    }

//    @PostMapping("/products/{id}")
//    public ResponseEntity<Product> ProductToCart(@PathVariable(value = "id") Long productId) throws ResourceNotFoundException {
//
//        Product product = productRepository.findById(productId)
//                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));
//
//        ShoppingCartRepository.save(product);
//        product.setName(productDetails.getName());
//        product.setDescription(productDetails.getDescription());
//        product.setPrice(productDetails.getPrice());
//        product.setExpiration(productDetails.getExpiration());
//        final Product ProductInCart = ShoppingCartRepository.save(product);
//        return ResponseEntity.ok().body(ProductInCart);
//    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Long productId,
                                                   @Valid @RequestBody Product productDetails) throws ResourceNotFoundException {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));

        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        product.setExpiration(productDetails.getExpiration());
        final Product updatedProduct = productRepository.save(product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/products/{id}")
    public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long productId)
            throws ResourceNotFoundException {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));

        productRepository.delete(product);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

//
//    @Autowired
//    ProductRepository repository;
//
//    @RequestMapping(value = "/BEaddproduct", method = RequestMethod.POST)
//    public void BEaddproduct(@RequestBody Product product) {
//
//        if(Objects.isNull(product.getId())) {
//            repository.save(new Product(product.getName(), product.getDescription(), product.getPrice(),product.getExpiration()));
//        }{
//            repository.save(new Product(product.getId(), product.getName(), product.getDescription(), product.getPrice(),product.getExpiration()));
//        }
//    }
//
//    @RequestMapping("/findall")
//    public MessageModel findAll() {
//
//        Iterable<Product> products = repository.findAll();
//
//        return new MessageModel("BE_OK", products);
//    }
//
//    @RequestMapping("/product/{id}")
//    public MessageModel findOne(@PathVariable("id") long id) {
//
//        Product product = repository.findOne(id);
//
//        return new MessageModel("BE_OK", product);
//    }
//
//    @RequestMapping("/findbyexpiration")
//    public MessageModel findByExpiration(@RequestParam("expiration") String expiration) throws ParseException {
//
//        System.out.println("BEFORE " + expiration);
//
//        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ROOT);
//        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyy-MM-dd", Locale.ROOT);
//        LocalDate date = LocalDate.parse(expiration, inputFormatter);
//        String formattedDate = outputFormatter.format(date.plusDays(1)); // incorrect date parsing from UI
//        Date expirationtmp=Date.valueOf(formattedDate);
//
//        List<Product> products = repository.findByExpiration(expirationtmp);
//
//        return new MessageModel("BE_OK", products);
//    }
//
//    @RequestMapping("/deleteall")
//    public MessageModel deleteAll() {
//
//        repository.deleteAll();
//        return new MessageModel("BE_OK", null);
//    }
}
