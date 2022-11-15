package com.example.demo.repository;

import com.example.demo.model.Menu;

public interface MenuRepo {

    int save(Menu record);

    int update(Menu record);

    //Menu findById(Long id);

    //List<Menu findAll();

    int deleteById(Long id);

    int deleteAll();

}
