package com.ksa.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Demo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long seq;
    private String user;
};
