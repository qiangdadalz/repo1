package gz.itcast.biz.front.address.service;

import gz.itcast.biz.front.address.dao.AddressDao;
import gz.itcast.biz.front.address.dao.AddressDaoImpl;
import gz.itcast.entity.Address;

import java.util.List;

public class AddressServiceImpl implements AddressService{
    AddressDao dao = new AddressDaoImpl();
    @Override
    public void save(Address address) {
        dao.save(address);
    }

    @Override
    public List<Address> queryAddress(String userId) {
        return dao.queryAddress(userId);
    }
}
