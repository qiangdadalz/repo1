package gz.itcast.biz.front.index.dao;

import gz.itcast.entity.Types;

import java.util.List;

/**
 * 主页的dao
 */
public interface IndexDao {

    //查询图书分类的方法
    public List<Types> queryTypes();
}