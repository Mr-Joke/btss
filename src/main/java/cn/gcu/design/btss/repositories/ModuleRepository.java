package cn.gcu.design.btss.repositories;

import cn.gcu.design.btss.domain.Module;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @Project: btss
 * @Author: Mrzhou
 * @Date: 2018/1/24 23:15
 */
public interface ModuleRepository extends PagingAndSortingRepository<Module, String> {

    List<Module> findByLevelAndTopIsNull(String level);

    List<Module> findByLevel(String level);
}
