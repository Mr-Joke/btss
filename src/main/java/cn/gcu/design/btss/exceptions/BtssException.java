package cn.gcu.design.btss.exceptions;

/**
 * @Project: btss
 * @Author: Mrzhou
 * @Date: 2018/1/27 12:08
 */
public class BtssException extends RuntimeException {
    private String code;

    public BtssException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
