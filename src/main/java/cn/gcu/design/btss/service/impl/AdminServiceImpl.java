package cn.gcu.design.btss.service.impl;

import cn.gcu.design.btss.domain.Admin;
import cn.gcu.design.btss.enums.BtssServiceEnum;
import cn.gcu.design.btss.exceptions.AdminServiceException;
import cn.gcu.design.btss.repositories.AdminRepository;
import cn.gcu.design.btss.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Project: btss
 * @Author: Mrzhou
 * @Date: 2018/1/24 23:13
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin loginCheck(String uname, String password, String code, String sessionCode) throws AdminServiceException {
        if (code == null || !code.equalsIgnoreCase(sessionCode)) {
            throw new AdminServiceException(BtssServiceEnum.INCORRECT_VERIVICATION);
        }
        List<Admin> admins = adminRepository.findByUnameAndPassword(uname, password);
        if (admins.size() <= 0) {
            throw new AdminServiceException(BtssServiceEnum.NOT_EXISTS);
        }
        return admins.get(0);
    }
}
