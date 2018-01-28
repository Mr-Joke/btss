package cn.gcu.design.btss.handlers;

import cn.gcu.design.btss.dto.ServiceResult;
import cn.gcu.design.btss.enums.BtssServiceEnum;
import cn.gcu.design.btss.exceptions.AdminServiceException;
import cn.gcu.design.btss.exceptions.BtssException;
import cn.gcu.design.btss.utils.ResultUtil;

/**
 * @Project: btss
 * @Author: Mrzhou
 * @Date: 2018/1/27 12:14
 */
//@ControllerAdvice
public class BtssExceptionHandler {
//    @ExceptionHandler(BtssException.class)
//    @ResponseBody
    public ServiceResult handle(BtssException e){
        if (e instanceof AdminServiceException){
            return ResultUtil.error(e.getCode(),e.getMessage());
        }else{
            return ResultUtil.error(BtssServiceEnum.UNKNOW_ERROR);
        }
    }
}
