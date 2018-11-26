package dao;

import domain.City;

import java.util.List;

public interface FindCityDao {

    List<City> findAll();

    City findOne(int id);

    void testGit();
}
