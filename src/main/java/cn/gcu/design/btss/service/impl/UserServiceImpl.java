package cn.gcu.design.btss.service.impl;

import cn.gcu.design.btss.domain.User;
import cn.gcu.design.btss.dto.ServiceResult;
import cn.gcu.design.btss.repositories.UserRepository;
import cn.gcu.design.btss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @Project: btss
 * @Author: Mrzhou
 * @Date: 2018/1/21 15:56
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findOne(String id) {
        return userRepository.findOne(id);
    }

    @Override
    public Page<User> findAll(int pageNum,int pageSize) {
        if (pageNum < 1) {
            pageNum = 1;
        }
        return userRepository.findAll(new PageRequest(pageNum,pageSize));
    }

    @Override
    public void deleteById(String id) {
        userRepository.delete(id);
    }
}
