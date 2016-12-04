package me.wonwoo;

import me.wonwoo.dto.AccountDTO;
import me.wonwoo.dto.OrderDTO;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.*;
import org.modelmapper.config.Configuration;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wonwoo on 2016. 12. 4..
 */
public class OrderTest {
  private ModelMapper modelMapper;
  private Order order;

  @Before
  public void setup() {
    modelMapper = new ModelMapper();
    modelMapper.getConfiguration()
      .setFieldMatchingEnabled(true)
      .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
//    PropertyMap<Order, OrderDTO> orderMap = new PropertyMap<Order, OrderDTO>() {
//      protected void configure() {
//        map().setStreet(source.getAddress().getStreet());
//        map(source.getAddress().getCity(), destination.getCity());
//      }
//    };
//    modelMapper.addMappings(orderMap);
    Converter<String, String> toUppercase = new AbstractConverter<String, String>() {
      protected String convert(String source) {
        return source == null ? null : source.toUpperCase();
      }
    };
    modelMapper.addConverter(toUppercase);
    order = order();
  }

  public Order order() {
    Order order = new Order();
    order.setId(1L);
    order.setName("wonwoo");
    Address address = new Address();
    address.setCity("seoul");
    address.setStreet("Dobong-gu");
    order.setAddress(address);
    return order;
  }

  @Test
  public void modelMapperTest() {
    final OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);
    System.out.println(orderDTO);

//    final TypeMap<Order, OrderDTO> typeMap = modelMapper.createTypeMap(Order.class, OrderDTO.class);
//    System.out.println(typeMap);
    modelMapper.validate();

  }

  @Test
  public void typeToken() {

    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
//    List<String> characters = new ArrayList<String>();

//    modelMapper.map(numbers, characters);
//    System.out.println(characters);
//
    Type listType = new TypeToken<List<String>>() {}.getType();

    List<String> characters = modelMapper.map(numbers, listType);
    System.out.println(characters);
  }
}
