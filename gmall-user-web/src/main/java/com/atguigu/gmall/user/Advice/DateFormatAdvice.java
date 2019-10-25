package com.atguigu.gmall.user.Advice;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;

/**
 * 日期格式转换，将前端传递过来的String类型的时间转换为Date类型
 */
@ControllerAdvice
public class DateFormatAdvice {
    @InitBinder
    public void initBinderDateType(WebDataBinder binder){
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd");
        //CustomDateEditor参数
        //第一个参数是格式，第二个参数是指定数据是否可以为空
        binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(sdf, true));
    }
}
