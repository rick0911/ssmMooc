package com.mage.serviceImpl;

import com.mage.domain.UserInfo;
import com.mage.mapper.OperationDao;
import com.mage.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationServiceImpl implements OperationService {


    @Autowired
    private OperationDao operationDao;


    @Override
    public UserInfo getUserInfoByUsername(String username) throws Exception{
        return operationDao.selectOperationsByUsername(username);
    }
}
