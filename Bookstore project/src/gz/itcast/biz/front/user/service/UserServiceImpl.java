package gz.itcast.biz.front.user.service;

import gz.itcast.biz.front.user.dao.UserDao;
import gz.itcast.biz.front.user.dao.UserDaoImpl;
import gz.itcast.entity.Users;



public class UserServiceImpl implements UserService {
    //创建UserDao对象
    UserDao dao = new UserDaoImpl();
    @Override
    public Users login(String name) {
        return dao.findByName(name);
    }
}
