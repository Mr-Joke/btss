package cn.gcu.design.btss.exceptions;

import cn.gcu.design.btss.enums.BtssServiceEnum;

/**
 * @Project: btss
 * @Author: Mrzhou
 * @Date: 2018/1/27 11:58
 */
public class AdminServiceException extends BtssException {
    public AdminServiceException(String code, String message) {
        super(code, message);
    }

    public AdminServiceException(BtssServiceEnum adminEnum) {
        super(adminEnum.getCode(), adminEnum.getMsg());
    }
}
