package com.productmanagement.consumer;

import com.productmanagement.model.Product;
import com.productmanagement.service.ProductMgmtImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Consumer {

    @Autowired
    ProductMgmtImpl productMgmtImpl;

    @Autowired
    Environment environment;


    @RabbitListener(queues="${jsa.rabbitmq.queue}")
    public void recievedProduct(List<Product> products){
        saveProducts(products);
        System.out.println("Received product: " + products);

        System.out.println("port num"+(environment.getProperty("server.port"))) ;

    }

    public void saveProducts(List<Product> products){
        productMgmtImpl.saveProducts(products);
    }
}
