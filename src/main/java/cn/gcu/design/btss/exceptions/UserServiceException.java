package cn.gcu.design.btss.exceptions;

import cn.gcu.design.btss.enums.BtssServiceEnum;

/**
 * @Project: btss
 * @Author: Mrzhou
 * @Date: 2018/1/28 13:18
 */
public class UserServiceException extends BtssException {
    public UserServiceException(String code, String message) {
        super(code, message);
    }

    public UserServiceException(BtssServiceEnum btssServiceEnum) {
        super(btssServiceEnum.getCode(),btssServiceEnum.getMsg());
    }
}
