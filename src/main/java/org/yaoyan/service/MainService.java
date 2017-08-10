package org.yaoyan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaoyan.dao.UserDaoI;
import org.yaoyan.entity.User;

@Service
public class MainService implements MainServiceImpl{

    @Autowired
    UserDaoI userDaoI;

    public void save() {
        User user = new User();
        user.setNamel("Mshu");
        userDaoI.save(user);
    }
}
