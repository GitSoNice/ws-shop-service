package com.ws.shop.utils;


import com.alibaba.fastjson.JSON;
import com.ws.shop.bean.StatusEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者: LQH
 * 日期: 2018年3月26日 22:42:11
 * 说明: 结果返回类
 */
public class ActionResult {

    private              String              messages         ;
    private              int                 code             = 200;
    private              int                 total            = 1;
    private              Object              result           = "";
    private				 int                 totalPages       = 1;

    public static final ActionResult SUCCESS          = ActionResult.data(true);

    public static ActionResult data(Object o) {
        return ActionResult.dataWithMsg(o, "");
    }

    public static ActionResult dataAndTotal(Object o,int total){
        ActionResult ret = ActionResult.dataWithMsg(o, "");
        ret.setTotal(total);
        return ret;
    }
    public static ActionResult dataWithMsg(Object o, String msg) {
        ActionResult ret = new ActionResult();
        ret.code = 200;
        ret.result = o;
        if(o instanceof List) {
            ret.total = ((List<?>) o).size();
        }
        ret.messages = msg;
        return ret;
    }

    public static ActionResult dataWithTotalPages(Object o, int totalPages) {
        ActionResult ret = new ActionResult();
        ret.code = 200;
        ret.result = o;
        if(o instanceof List) {
            ret.total = ((List<?>) o).size();
        }
        ret.totalPages = totalPages;
        return ret;
    }

    public static ActionResult error(String msg) {
        ActionResult ret = new ActionResult();
        ret.code = -1;
        ret.messages = msg;
        return ret;
    }

    public boolean retTrue() {
        if (success()) {
            if (result != null && result.equals(true)) {
                return true;
            }
        }
        return false;
    }

    public boolean success() {
        return code == 200;
    }

    public ActionResult() {
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getTotal() {
        if(result instanceof List){
            List<?> reList = (List<?>) result;
            return reList.size();
        }
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Map<String,Object> toMap(){
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("code", this.code);
        model.put("messages", this.messages);
        model.put("result", JSON.toJSONString(result));
        model.put("total",this.getTotal());
        return model;
    }

    public int getTotalPages() {
        return totalPages;
    }
    public static ActionResult failure(String msg){
        ActionResult result = new ActionResult();
        result.setCode(StatusEnum.codeStatus.ERROR.getCode());
        result.setMessages(msg);
        return result;
    }

    public void failureMsg(String msg){
        this.setCode(StatusEnum.codeStatus.ERROR.getCode());
        this.setMessages(msg);
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    @Override
    public String toString() {
        return "ActionResult{" +
                "messages='" + messages + '\'' +
                ", code=" + code +
                ", total=" + total +
                ", result=" + result +
                '}';
    }
}