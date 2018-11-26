package dao.impl;

import dao.FindCityDao;
import domain.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FindCityDaoImpl implements FindCityDao {
    @Override
    public List<City> findAll() {
        List<City> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet resultSet = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //获取Connection对象
            connection = DriverManager.getConnection("jdbc:mysql:///day23","root","root");
            //获取操作数据的对象
            pst = connection.prepareCall("select * FROM  city");
            //执行sql语句
            resultSet = pst.executeQuery();
            //将数据存入List中
            while (resultSet.next()) {
                City city = new City();
                city.setId(resultSet.getInt("id"));
                city.setCity(resultSet.getString("city"));
                list.add(city);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭资源
                resultSet.close();
                pst.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    @Override
    public City findOne(int id) {
        return null;
    }
}
