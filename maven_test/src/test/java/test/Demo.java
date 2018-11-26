package test;

import dao.FindCityDao;
import dao.impl.FindCityDaoImpl;
import domain.City;
import org.junit.Test;

import java.util.List;

public class Demo {
    @Test
    public void test(){
        FindCityDao findCityDao = new FindCityDaoImpl();
        List<City> list = findCityDao.findAll();
        System.out.println(list);

    }

}
