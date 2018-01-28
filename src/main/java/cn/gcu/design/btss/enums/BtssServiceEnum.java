package cn.gcu.design.btss.enums;

/**
 * @Project: btss
 * @Author: Mrzhou
 * @Date: 2018/1/27 17:58
 */
public enum BtssServiceEnum {
    UNKNOW_ERROR("-1","系统错误"),
    SECCESS("0","成功"),
    INCORRECT_VERIVICATION("1","验证码不正确"),
    NOT_EXISTS("2","用户不存在"),
    ILLEGAL_VARIABLE("3","非法参数")
    ;
    private String code;
    private String msg;
    BtssServiceEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
