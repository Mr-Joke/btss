package cn.gcu.design.btss.service.impl;

import cn.gcu.design.btss.domain.Module;
import cn.gcu.design.btss.repositories.ModuleRepository;
import cn.gcu.design.btss.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Project: btss
 * @Author: Mrzhou
 * @Date: 2018/1/24 23:13
 */
@Service
public class ModuleServiceImpl implements ModuleService {
    @Autowired
    private ModuleRepository moduleRepository;
    @Override
    public List<Module> findByLevel(String level) {
        return moduleRepository.findByLevel(level);
    }
}
