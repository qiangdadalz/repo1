package gz.itcast.biz.admin.types.dao;

import gz.itcast.entity.Types;
import gz.itcast.util.BaseDao;
import org.junit.Test;

import java.util.List;

public class TypesDaoImpl extends BaseDao<Types> implements TypesDao {

    /**
     * 测试
     */
    @Test
    public void test(){
        TypesDaoImpl dao = new TypesDaoImpl();
        List<Types> list = dao.findAll();
        for (Types types:list) {
            System.out.println(types);

        }
    }
}
