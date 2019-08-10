package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IPermissionDao;
import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.service.IPermissionService;
import com.itheima.ssm.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;

    UuidUtils uuidUtils = new UuidUtils();

    @Override
    public List<Permission> findAll() throws Exception {

        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception {

        permission.setId(uuidUtils.makeUuid());

        permissionDao.save(permission);
    }
}
