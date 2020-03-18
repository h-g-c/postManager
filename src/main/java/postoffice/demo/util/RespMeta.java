package postoffice.demo.util;

public class RespMeta {
    private int code = -1;
    private String errorMsg;

    public int getCode() {
        return code;
    }

    void setCode(int code) {
        this.code = code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
