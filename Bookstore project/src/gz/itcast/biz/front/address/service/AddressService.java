package gz.itcast.biz.front.address.service;

import gz.itcast.entity.Address;

import java.util.List;

public interface AddressService {
    public void save(Address address);
    public List<Address> queryAddress(String userId);
}
