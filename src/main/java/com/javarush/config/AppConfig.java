package com.javarush.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.lang.reflect.InvocationTargetException;
import java.sql.Driver;

@Configuration
@ComponentScan(basePackages = "com.javarush")
@PropertySource(value = "classpath:application.properties")
public class AppConfig {

    @Bean
    Driver driver(@Value(value = "${spring.datasource.driver-class-name}") String driverClassName) {
        try {
            return (Driver) Class.forName(driverClassName)
                    .getConstructor()
                    .newInstance();
        } catch (InstantiationException
                 | ClassNotFoundException
                 | NoSuchMethodException
                 | InvocationTargetException
                 | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    DataSource dataSource(
            @Value(value = "${spring.datasource.url}") String url,
            @Value(value = "${spring.datasource.username}") String username,
            @Value(value = "${spring.datasource.password}") String password
    ) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        config.setPoolName("myPool");
        return new HikariDataSource(config);
    }


}
