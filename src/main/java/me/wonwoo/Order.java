package me.wonwoo;

import lombok.Data;

/**
 * Created by wonwoo on 2016. 12. 4..
 */
@Data
public class Order {

  private Long id;
  private String name;
  private Address address;

}
