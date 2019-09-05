package com.productmanagement.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.data.annotation.*;

import org.springframework.data.mongodb.core.mapping.Document;



import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Product.class)
@Document
public class Product implements Serializable {
    @Id
    private static final long serialVersionUID = 1L;
    private String uuid;
    private String name;
    private String descriptor;
    private String provider;
    private String available;
    private String measurementUnits;

    private String createDate;

    private String lastModifiedDate;
  /*  @CreatedBy
    private String createdBy;
    @LastModifiedBy
    private String modifiedBy;*/

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        this.createDate = dateFormat.format(date);
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        this.lastModifiedDate = dateFormat.format(lastModifiedDate);
    }



    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getMeasurementUnits() {
        return measurementUnits;
    }

    public void setMeasurementUnits(String measurementUnits) {
        this.measurementUnits = measurementUnits;
    }



    @Override
    public String toString()
    {
        return "Product [uuid=" + uuid + ", name=" + name + ", descriptor=" + descriptor + ", provider=" + provider + ", available="+available+  ", measurementUnits="+measurementUnits+",createDate="+createDate+ ",lastModifiedDate="+lastModifiedDate+"]";


    }




}
