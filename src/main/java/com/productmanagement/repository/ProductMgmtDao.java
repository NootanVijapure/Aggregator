package com.productmanagement.repository;

import com.productmanagement.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMgmtDao  extends MongoRepository<Product, String> {
    public Product findByName(String name);

    public Product findByUuid(String uuid);

    public List<Product> findByCreateDate(String createDate);

    public List<Product>  findByLastModifiedDate(String lastModifiedDate);


}
