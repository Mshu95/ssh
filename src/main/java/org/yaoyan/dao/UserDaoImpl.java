package org.yaoyan.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.yaoyan.entity.User;
import org.yaoyan.base.BaseDaoImpl;

@Transactional
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDaoI {

}
