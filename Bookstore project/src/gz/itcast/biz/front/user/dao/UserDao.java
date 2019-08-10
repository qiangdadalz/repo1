package gz.itcast.biz.front.user.dao;

import gz.itcast.entity.Users;

public interface UserDao {
    //根据名称查找用户
    public Users findByName(String name);
    public Users findById(String id);
}
