package com.ws.shop.bean;


/**
 * 作者: LQH
 * 日期: 2018年3月26日 22:41:44
 * 说明:
 */
public final class StatusEnum {

    /**
     * 返回状态码
     */
    public enum codeStatus{
        ERROR("服务器内部错误",500),
        MISS("找不页面",404),
        SUCCESS("成功",200),
        EXPIRE("token过期",600);

        codeStatus( String msg,int code) {
            this.code = code;
            this.msg = msg;
        }

        private int code;
        private String msg;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}
