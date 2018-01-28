package cn.gcu.design.btss.repositories;

import cn.gcu.design.btss.domain.Admin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @Project: btss
 * @Author: Mrzhou
 * @Date: 2018/1/24 23:16
 */
public interface AdminRepository extends PagingAndSortingRepository<Admin,Integer>{
    List<Admin> findByUnameAndPassword(String uname, String password);
}
