package gz.itcast.biz.front.index.service;

import gz.itcast.biz.front.index.dao.IndexDao;
import gz.itcast.biz.front.index.dao.IndexDaoImpl;
import gz.itcast.entity.Types;

import java.util.List;

/**
 * 主页的Service的实现
 */
public class IndexServiceImpl implements IndexService{
    IndexDao dao = new IndexDaoImpl();
    @Override
    public List<Types> queryTypes() {
        List<Types> types = dao.queryTypes();
        return types;
    }
}
