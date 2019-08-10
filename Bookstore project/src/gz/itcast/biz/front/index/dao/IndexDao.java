package gz.itcast.biz.front.index.dao;

import gz.itcast.entity.Books;
import gz.itcast.entity.Types;

import java.util.List;

/**
 * 主页的dao
 */
public interface IndexDao {

    //查询图书分类的方法
    public List<Types> queryTypes();

    //根据分类id查询对应的图书
    public List<Books> queryBooks(String typeId);

    //根据id查询对应的图书
    public Books queryBook(String id);


}
