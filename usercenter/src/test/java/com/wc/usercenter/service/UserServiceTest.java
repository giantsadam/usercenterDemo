package com.wc.usercenter.service;
import java.util.Date;

import com.wc.usercenter.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * 用户服务测试
 *
 * @author chen
 */
@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void testAddUser(){
        User user = new User();
        user.setUsername("testChen");
        user.setUserAccount("123");
        user.setAvatarUrl("https://pic.rmb.bdstatic.com/bjh/faa1661e54ab1bf491bf630fe16f277b.gif");
        user.setGender(0);
        user.setUserPassword("xxx");
        user.setPhone("123");
        user.setEmail("456");
        boolean result = userService.save(user);
        System.out.println(user.getId());
        Assertions.assertTrue(result);
    }

    @Test
    void userRegister() {
        String userAccount = "giantsadam";
        String userPassword = "";
        String checkPassword = "123456";
        long result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1,result);
        userAccount = "wc";
        result =  userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1,result);
        userAccount = "giantsadam";
        userPassword = "123456";
        result =  userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1,result);
        userAccount = "w c";
        userPassword = "12345678";
        result =  userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1,result);
        checkPassword = "123456789";
        result =  userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1,result);
        userAccount = "testChen";
        checkPassword = "12345678";
        result =  userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1,result);
        userAccount = "giantsadam";
        result =  userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1,result);
    }
}