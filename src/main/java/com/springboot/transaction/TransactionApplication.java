package com.springboot.transaction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class TransactionApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(TransactionApplication.class, args);
    }
}
