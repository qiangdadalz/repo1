package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IProductDao {


    //根据id查询产品
    @Select("select * from product where id=#{id}")
    public Product findById(String id) throws Exception;

    //查询所有的商品信息
    @Select("select * from product")
    public List<Product> findAll() throws Exception;

    //保存商品信息
    @Insert("insert into product (id,productNum,productName,cityName,productPrice,productDesc,productStatus) values(#{id},#{productNum},#{productName},#{cityName},#{productPrice},# {productDesc},#{productStatus})")
    void save(Product product);
}
