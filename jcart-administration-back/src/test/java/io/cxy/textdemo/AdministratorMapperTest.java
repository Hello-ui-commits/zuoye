package io.cxy.textdemo;


import io.cxy.jcartadministrationback.dao.AdministratorMapper;
import io.cxy.jcartadministrationback.po.Administrator;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AdministratorMapperTest {
    @Autowired
    private AdministratorMapper administratorMapper;
    @Test
    void selectByUsername() {
        String userName="user";
        Administrator administrator = administratorMapper.selectByUsername(userName);
        assertNull(administrator);
    }

}