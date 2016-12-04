package me.wonwoo;

import me.wonwoo.dto.AccountDTO;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

/**
 * Created by wonwoo on 2016. 12. 4..
 */
public class AccountTest {

  private ModelMapper modelMapper;
  private Account account;

  @Before
  public void setup() {
    modelMapper = new ModelMapper();
    account = account();
  }

  public Account account() {
    Account account = new Account();
    account.setId(1L);
    account.setFirstName("wonwoo");
    account.setLastName("lee");
    account.setEmail("test@email.com");
    return account;
  }

  @Test
  public void modelMapperTest() {

    final AccountDTO accountDTO = modelMapper.map(account, AccountDTO.class);
    System.out.println(accountDTO);

  }
}

