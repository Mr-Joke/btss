package cn.gcu.design.btss.dto;

/**
 * @Project: btss
 * @Author: Mrzhou
 * @Date: 2018/1/25 0:07
 */
public class ServiceResult<T> {
    private String code;
    private String msg;
    private T data;

    public ServiceResult(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ServiceResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
