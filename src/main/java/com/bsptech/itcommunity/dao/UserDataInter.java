package com.bsptech.itcommunity.dao;

import com.bsptech.itcommunity.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDataInter extends CrudRepository<User, Integer> {
    
}
