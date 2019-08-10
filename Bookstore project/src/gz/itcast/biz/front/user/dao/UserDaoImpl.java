package gz.itcast.biz.front.user.dao;


import gz.itcast.entity.Users;
import gz.itcast.util.BaseDao;
import gz.itcast.util.JdbcUtil;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class UserDaoImpl extends BaseDao<Users> implements UserDao{
    @Override
    public Users findByName(String name) {
        try {
            QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
            return (Users) qr.query("select * from users where name=?",new BeanHandler(Users.class),new Object[]{name});
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
