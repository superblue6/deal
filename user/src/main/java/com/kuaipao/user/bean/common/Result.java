package com.kuaipao.user.bean.common;



import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

import java.util.*;

public class Result<T> {

    private Collection<T> beans;

    private Object bean;

    private Object object;

    private String returnMessage;

    private String returnCode;

    public Result() {

        this((Collection) null);
    }
    public Result(String returnValue) {
        this.returnCode = "0";
        this.returnMessage = "";
        this.bean = returnValue;
    }

    public Result(String returnCode, String returnMessage) {
        this((Collection) null);
        this.returnCode = returnCode;
        this.returnMessage = returnMessage;
    }

    public Result(Map map) {
        this.returnCode = "0";
        this.returnMessage = "";
        this.bean = map;
    }

    public Result(Object obj) {

        this.returnCode = "0";
        this.returnMessage = "";
        this.bean = obj;
    }

    public Result(PageInfo<T> pageInfo) {

        this((Collection) pageInfo.getList());
        Map<String, Object> map = new HashMap<>();
        map.put("total", Long.valueOf(pageInfo.getTotal()));
        map.put("pageNum", Integer.valueOf(pageInfo.getPageNum()));
        map.put("pageSize", Integer.valueOf(pageInfo.getPageSize()));
        map.put("pageCount", Integer.valueOf(pageInfo.getPages()));
        this.bean = map;
        this.beans = (Collection) pageInfo.getList();
    }

    public Result(Collection<T> dataList) {

        this.object = new HashMap();
        this.returnMessage = "";
        this.returnCode = "0";
        this.beans = dataList;
        Map<String, Object> map = new HashMap<>();
        if (dataList != null) {
            map.put("total", Integer.valueOf(dataList.size()));
        } else {
            map.put("total", 0);
        }
        this.bean = map;
    }


    public static Result<?> of(Collection<?> data) {

        return new Result(data);
    }


    public Collection<T> getBeans() {

        if (this.beans == null) {
            this.beans = new ArrayList(0);
        }
        return this.beans;
    }


    public void setBeans(Collection<T> beans) {

        this.beans = beans;
    }


    public Object getBean() {

        return this.bean;
    }


    public void setBean(Object bean) {

        this.bean = bean;
    }


    public String getReturnMessage() {

        return this.returnMessage;
    }


    public void setReturnMessage(String returnMessage) {

        this.returnMessage = returnMessage;
    }


    public String getReturnCode() {

        return this.returnCode;
    }


    public void setReturnCode(String returnCode) {

        this.returnCode = returnCode;
    }


    public Object getObject() {

        return this.object;
    }


    public void setObject(Object object) {

        this.object = object;
    }


    @Override
    public String toString() {

        return JSON.toJSONString(this);
    }

}

