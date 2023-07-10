package com.example.clusterdatawarehouse.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.util.Date;
@Data
public abstract class DbEntity {
    @Id
    private String id;
    @CreatedDate
    private Date createdDate;

    public void setCreatedDate() {
        this.createdDate = new Date();
    }
}
