package gz.itcast.biz.front.index.service;

import gz.itcast.entity.Types;

import java.util.List;

/**
 * 主页的Service接口
 */
public interface IndexService {

    public List<Types> queryTypes();
}
