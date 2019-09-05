package com.productmanagement.service;

import com.productmanagement.model.Product;
import com.productmanagement.repository.ProductMgmtDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductMgmtImpl {

    @Autowired
    ProductMgmtDao productMgmtDao;

    public void saveProducts( List<Product> products){
        productMgmtDao.save(products);
    }

    public Product getByName(String name){
      return  productMgmtDao.findByName(name);

    }
    public List<Product> getAll(){
        return productMgmtDao.findAll();
    }
    public Product updateProduct(Product newProduct, String uuid) {
        Product product =
                productMgmtDao
                        .findByUuid(uuid);

        product.setDescriptor(newProduct.getDescriptor());
        product.setAvailable(newProduct.getAvailable());
        product.setMeasurementUnits(newProduct.getMeasurementUnits());
        product.setName(newProduct.getName());
        product.setLastModifiedDate(new Date());

        final Product updatedProduct = productMgmtDao.save(product);
      //  return ResponseEntity.ok(updatedUser);
       return updatedProduct;


    }

    public int getProductsCreatedOn(String createdDate){
       List<Product> products=  productMgmtDao.findByCreateDate(createdDate);
       int numOfProducts=products.size();
       System.out.println("================"+numOfProducts);
       return numOfProducts;
    }

    public int getProductsUpdatedOn(String updatedDate){
        List<Product> products=  productMgmtDao.findByLastModifiedDate(updatedDate);
        int numOfProducts=products.size();
        System.out.println("================updated"+numOfProducts);
        return numOfProducts;
    }

    public int getNumberOfCreatedProducts(){
        List<Product> products=  productMgmtDao.findAll();
        int NumberOfProducts=0;
        for(Product prod:products){
            if(prod.getCreateDate()!=null){
                NumberOfProducts++;
            }
        }
        return NumberOfProducts;
    }

    public int getNumberOfUpdatedProducts(){
        List<Product> products=  productMgmtDao.findAll();
        int NumberOfUpdatedProducts=0;
        for(Product prod:products){
            if(prod.getLastModifiedDate()!=null){
                NumberOfUpdatedProducts++;
            }
        }
        return NumberOfUpdatedProducts;
    }
}




