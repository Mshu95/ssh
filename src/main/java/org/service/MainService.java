package org.service;

import org.dao.UserDaoI;
import org.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
