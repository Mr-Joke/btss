package cn.gcu.design.btss.repositories;

import cn.gcu.design.btss.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 * @Project: btss
 * @Author: Mrzhou
 * @Date: 2018/1/21 13:46
 */
public interface UserRepository extends PagingAndSortingRepository<User, String> {

}
