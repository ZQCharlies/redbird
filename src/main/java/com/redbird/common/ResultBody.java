package com.redbird.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * 返回结果实体类
 */
public class ResultBody {
    private boolean flag;//是否成功
    private Integer code;//返回码
    private String message;//返回的信息
    private Object data;//返回的数据

    public ResultBody(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    public ResultBody(boolean flag, Integer code, String message, Object data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    public static Object success(){
        return new ResultBody(true,StateCode.OK,"成功");
    }
    public static Object success(String message){return new ResultBody(true,StateCode.OK,message);}
    public static Object success(Object object){
        return new ResultBody(true,StateCode.OK,"成功",object);
    }
    public static Object success(JSONObject jsonObject){
        return new ResultBody(true,StateCode.OK,"成功",jsonObject);
    }
    public static Object success(int num, List list){
        JSONObject jo = new JSONObject();
        jo.put("num",num);
        jo.put("jsonArray",JSONObject.parseArray(JSON.toJSONString(list)));
        return new ResultBody(true,StateCode.OK,"成功",jo);
    }
    public static Object failure(){
        return new ResultBody(false,StateCode.OK,"失败");
    }
    public static Object failure(JSONObject jsonObject){
        return new ResultBody(false,StateCode.OK,"失败",jsonObject);
    }

    public static  Object failure(int code,String msg){
        return new ResultBody(false,code,msg);
    }
}
