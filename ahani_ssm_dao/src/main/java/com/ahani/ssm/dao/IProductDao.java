package com.ahani.ssm.dao;

import com.ahani.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


import java.util.List;

public interface IProductDao {

    //根据id查询查询产品
    @Select("select * from product where id=#{id}")
    Product findById(Integer id) throws Exception;

    //查询所有的产品信息
    @Select("select * from product")
    List<Product> findAll() throws Exception;

    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);
}
