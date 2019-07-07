package com.hand.stocksystem.dto;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class JdbcUtil {
    /**数据库连接需要字符串*/
    public static final String username = "root";
    public static final String password = "123456";
    public static final String jdbcUrl = "jdbc:mysql://localhost:3306/stockdata?serverTimezone=GMT";
    public static final String driverName = "com.mysql.cj.jdbc.Driver";
    public static JdbcTemplate jdbcTemplate = getJdbcTemplate();
    /**获取一个JdbcTemplate实例对象*/
    public static JdbcTemplate getJdbcTemplate() {


        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setPassword(password);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setDriverClassName(driverName);
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }
}
