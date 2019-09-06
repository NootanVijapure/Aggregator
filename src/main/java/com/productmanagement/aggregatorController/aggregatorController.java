package com.productmanagement.aggregatorController;

import com.productmanagement.model.Product;
import com.productmanagement.service.ProductMgmtImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class aggregatorController {

    @Autowired
    ProductMgmtImpl productMgmtImpl;

    //@RequestMapping("/get")
    @RequestMapping(value = "/getProduct/{name}", method = RequestMethod.GET)
    public ResponseEntity<?> getProduct(@PathVariable("name") String name) {
        Product product=productMgmtImpl.getByName(name);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @RequestMapping( "/item" )
    public String getItem() {
        return "It's working...!";
    }

    @RequestMapping("/getAll")
    public List<Product> getAll(){
        return productMgmtImpl.getAll();
    }

    @RequestMapping(value ="/products/{uuid}",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> updateProduct(@RequestBody Product newProduct, @PathVariable String uuid) {

      Product updatedProduct=  productMgmtImpl.updateProduct(newProduct, uuid);
        return ResponseEntity.ok(updatedProduct);
    }

    @RequestMapping("/productsCreatedOn")
    public int getCreatedProducts(@RequestParam String createdDate){
        return productMgmtImpl.getProductsCreatedOn(createdDate);
    }

    @RequestMapping("/productsUpdatedOn")
    public int getUpdatedProducts(@RequestParam String updatedDate){
        return productMgmtImpl.getProductsUpdatedOn(updatedDate);
    }

    @RequestMapping("/productsCreated")
    public int getNumberOfCreatedProducts(){
        return productMgmtImpl.getNumberOfCreatedProducts();
    }

    @RequestMapping("/productsUpdated")
    public int getNumberOfUpdatedProducts(){
        return productMgmtImpl.getNumberOfUpdatedProducts();
    }
}
