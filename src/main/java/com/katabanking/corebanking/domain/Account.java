package com.katabanking.corebanking.domain;

import lombok.Data;

@Data
public class Account {

     int balance=0;


     public void deposit(String value){
                  this.deposit(Integer.valueOf(value));
     }
     public void deposit(int value){
          balance+=value;
     }
}
