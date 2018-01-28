package cn.gcu.design.btss.utils;

import cn.gcu.design.btss.dto.ServiceResult;
import cn.gcu.design.btss.enums.BtssServiceEnum;

/**
 * @Project: btss
 * @Author: Mrzhou
 * @Date: 2018/1/27 18:16
 */
public class ResultUtil {

    public static ServiceResult success(String code,String msg,Object obj){
        return new ServiceResult(code ,msg ,obj);
    }

    public static ServiceResult success(BtssServiceEnum btssServiceEnum, Object obj){
        return new ServiceResult(btssServiceEnum.getCode(), btssServiceEnum.getMsg(),obj);
    }
    public static ServiceResult error(String code,String msg){
        return new ServiceResult(code,msg);
    }

    public static ServiceResult error(BtssServiceEnum btssServiceEnum){
        return new ServiceResult(btssServiceEnum.getCode(), btssServiceEnum.getMsg());
    }
}
