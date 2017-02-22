/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robvangastel.kwetter.dao.facade;

import com.robvangastel.kwetter.dao.IUserDao;
import com.robvangastel.kwetter.domain.User;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

/**
 *
 * @author Rob
 */

@Stateless @Default
public class UserDaoColImpl implements IUserDao {

    private final List<User> users;
    private static int INCREMENT = 0;
    
    public UserDaoColImpl() {
        users = new ArrayList<>();
    }
    
    private long getIncrement() {
        INCREMENT++;
        return (long) INCREMENT;
    }
        
    @Override
    public User findById(long id) {
        for(User user : users) {
            if(user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }
    
    @Override
    public User findByUsername(String username) {
        for(User user : users) {
            if(user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
    
    @Override
    public User findByEmail(String email) {
        for(User user : users) {
            if(user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User create(User entity) {
        entity.setId(getIncrement());
        users.add(entity);
        return entity;
    }

    @Override
    public User update(User entity) {
       for(User user : users) {
            if(user.getId().equals(entity.getId())) {
                user = entity;
            }
        }
        return null;
    }

    @Override
    public void delete(User entity) {
        users.remove(entity);
    }

    @Override
    public void deleteById(long id) {
        for(User user : users) {
            if(user.getId().equals(id)) {
                users.remove(user);
            }
        }
    }
}
