package tr.com.mindworks.services;

import tr.com.mindworks.model.TUser;

/**
 * @author mhazer on 26/03/2017.
 */
public interface UserService
{
    TUser findUser(String loginName);
}
