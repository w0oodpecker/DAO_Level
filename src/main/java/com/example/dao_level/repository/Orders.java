package com.example.dao_level.repository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Repository
public class Orders {

    private String scriptSubject;
    private final String SCRIPTNAME = "FetchProductNames.sql";
    private NamedParameterJdbcTemplate namedParameterJDBCTemplate;


    Orders(NamedParameterJdbcTemplate namedParameterJDBCTemplate) {
        this.namedParameterJDBCTemplate = namedParameterJDBCTemplate;
        this.scriptSubject = read(SCRIPTNAME);
    }

    private static String read(String scriptFileName){ //Чтение скрипта
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getProductName(String name){ //Извлечение данных из БД
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("name", name);
        return namedParameterJDBCTemplate.queryForList(scriptSubject, paramMap, String.class);
    }

}
