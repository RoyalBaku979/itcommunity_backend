package com.bsptech.itcommunity.dao;

import com.bsptech.itcommunity.entity.DeveloperProfile;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;


@Transactional
public interface DeveloperDataInter extends CrudRepository<DeveloperProfile, Integer> {

}
