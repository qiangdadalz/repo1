package gz.itcast.biz.front.index.dao;

import gz.itcast.entity.Books;
import gz.itcast.entity.Types;
import gz.itcast.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * IndexDao的实现类
 * 不继承BaseDao<T>，因为主页index的dao不只有一个类，使用BaseDao需要明确泛型T
 */

/**
 * 查询图书的类型
 */
public  class IndexDaoImpl implements IndexDao {
    /**
     * 查询图书的类型
     */
    @Override
    public List<Types> queryTypes() {
        try {
            QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
            return (List<Types>)qr.query("select * from types",new BeanListHandler(Types.class));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据typeid查询图书
     * 显示全部：typeid为空
     * 分类查询：typeid有值
     *
     */
    @Override
    public List<Books> queryBooks(String typeId) {
        try {
            StringBuffer sql = new StringBuffer("select id,name,price,img,round(price*rebate,2) as currentPrice from books ");
            //当有分类的时候执行拼接
            if (typeId!=null && !typeId.equals("")){
                sql.append(" where id in(SELECT bookid FROM booktype WHERE typeid='"+typeId+"')");
            }


            QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
            return (List<Books>)qr.query(sql.toString(),new BeanListHandler(Books.class));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Books queryBook(String id) {
        try {
            QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
            return (Books)qr.query("select id,name,price,rebate,round(price*rebate,2) as currentPrice,auth,img from books where id=?",
                    new BeanHandler(Books.class),new Object[]{id});
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args){
        IndexDaoImpl dao = new IndexDaoImpl();
        Books books = dao.queryBook("B001");
        System.out.println(books);
    }
}
