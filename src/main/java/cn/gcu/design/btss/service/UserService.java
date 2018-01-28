package cn.gcu.design.btss.service;


import cn.gcu.design.btss.domain.User;
import cn.gcu.design.btss.dto.ServiceResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Project: btss
 * @Author: Mrzhou
 * @Date: 2018/1/21 13:48
 */
public interface UserService {

    User save (User user);

    User findOne(String id);

    Page<User> findAll(int pageNum,int pageSize);

    void deleteById(String id);
}
