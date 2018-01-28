package cn.gcu.design.btss.service;

import cn.gcu.design.btss.domain.Admin;
import cn.gcu.design.btss.dto.ServiceResult;

/**
 * @Project: btss
 * @Author: Mrzhou
 * @Date: 2018/1/24 22:46
 */
public interface AdminService {

    Admin loginCheck(String uname, String password, String code, String sessionCode);
}
