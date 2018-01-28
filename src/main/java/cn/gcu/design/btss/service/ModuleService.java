package cn.gcu.design.btss.service;

import cn.gcu.design.btss.domain.Module;

import java.util.List;

/**
 * @Project: btss
 * @Author: Mrzhou
 * @Date: 2018/1/24 23:07
 */
public interface ModuleService {
    List<Module> findByLevel(String level);
}
