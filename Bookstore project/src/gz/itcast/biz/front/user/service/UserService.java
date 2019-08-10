package gz.itcast.biz.front.user.service;

import gz.itcast.entity.Users;

import java.util.List;

public interface UserService {

    //根据姓名查询用户
    public Users login(String name);
}
