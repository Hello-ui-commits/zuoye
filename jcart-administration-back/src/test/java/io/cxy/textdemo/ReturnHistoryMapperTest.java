package io.cxy.textdemo;

import io.cxy.jcartadministrationback.dao.ReturnHistoryMapper;
import io.cxy.jcartadministrationback.po.ReturnHistory;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ReturnHistoryMapperTest {
    @Autowired
    private ReturnHistoryMapper returnHistoryMapper;

    @Test
    void selectListByReturnId(){
        Integer returnId=1;
        List<ReturnHistory> returnHistories = returnHistoryMapper.selectListByReturnId(returnId);
        assertNull(returnHistories);
    }

}
