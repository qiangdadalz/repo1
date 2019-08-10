package gz.itcast.biz.admin.types.dao;

import gz.itcast.entity.Types;
import gz.itcast.util.BaseDao;
import gz.itcast.util.JdbcUtil;
import gz.itcast.util.WebUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class TypesDaoImpl extends BaseDao<Types> implements TypesDao {

    //findAll()在BaseDao类中
    /**
     * 测试
     */
    /*@Test
    public void test(){
        TypesDaoImpl dao = new TypesDaoImpl();
        List<Types> list = dao.findAll();
        for (Types types:list) {
            System.out.println(types);

        }
    }*/

    @Override
    public void saveTypes(Types type) {
        try {
            QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
            qr.update("insert into types(id,name,descr) values(?,?,?)",
                    new Object[]{
                            WebUtil.uuid(),
                            type.getName(),
                            type.getDescr()
                    });
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
