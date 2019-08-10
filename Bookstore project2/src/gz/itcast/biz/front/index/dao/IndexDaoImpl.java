package gz.itcast.biz.front.index.dao;

import gz.itcast.entity.Types;
import gz.itcast.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * IndexDao的实现类
 * 不继承BaseDao<T>，因为主页index的dao不只有一个类，使用BaseDao需要明确泛型T
 */

public class IndexDaoImpl implements IndexDao {
    @Override
    public List<Types> queryTypes() {
        try {
            QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
            return (List<Types>)qr.query("select * from types",new BeanListHandler(Types.class));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static void main(String[] args){
        IndexDaoImpl dao = new IndexDaoImpl();
        List<Types> types = dao.queryTypes();
        for (Types type: types) {
            System.out.println(type);
        }
    }
}
