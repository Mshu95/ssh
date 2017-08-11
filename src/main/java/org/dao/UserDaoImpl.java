package org.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.entity.User;
import org.base.BaseDaoImpl;

@Transactional
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDaoI {

}
