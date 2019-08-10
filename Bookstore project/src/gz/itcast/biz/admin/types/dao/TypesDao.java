package gz.itcast.biz.admin.types.dao;

import gz.itcast.entity.Types;

import java.util.List;

public interface TypesDao {
    public List<Types> findAll();
    //添加分类
    public void saveTypes(Types type);

}
