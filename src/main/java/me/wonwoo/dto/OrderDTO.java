package me.wonwoo.dto;

import lombok.ToString;

/**
 * Created by wonwoo on 2016. 12. 4..
 */
//@Data
@ToString
public class OrderDTO {
  private String name;
  private Long id;
  private String addressCity;
  private String addressStreet;

}
