package com.example.chat_board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

@SpringBootTest
public class ConnectionTest {

    @Autowired
    DataSource dataSource;

    @Test
    public void test() throws SQLException {
        Connection con = dataSource.getConnection();
        DatabaseMetaData meta = con.getMetaData();
        System.out.println("user name:" + meta.getUserName());
        System.out.println("sql driver:" + meta.getDriverName());
        System.out.println("sql url: " + meta.getURL());
    }


}