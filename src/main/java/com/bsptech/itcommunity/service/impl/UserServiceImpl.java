package com.bsptech.itcommunity.service.impl;

import com.bsptech.itcommunity.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsptech.itcommunity.dao.UserDataInter;
import com.bsptech.itcommunity.entity.User;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServiceInter {

    @Autowired
    UserDataInter userDao;

  public User findById(int id) {
        Optional<User> it=userDao.findById(id);
        return it.get();
  }
}
