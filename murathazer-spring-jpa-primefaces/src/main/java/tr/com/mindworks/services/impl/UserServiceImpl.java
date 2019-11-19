package tr.com.mindworks.services.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.com.mindworks.dao.UserRepository;
import tr.com.mindworks.model.TUser;
import tr.com.mindworks.services.UserService;

/**
 * @author mhazer on 26/03/2017.
 */
@Service("userService")
public class UserServiceImpl implements UserService, Serializable
{
    @Autowired
    private UserRepository userRepository;


    @Override
    public TUser findUser(String loginName)
    {
        return this.userRepository.findByLoginName(loginName);
    }
}
