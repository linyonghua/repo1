package cn.itcast.controller;



import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义类型转换类
 */
public class StringToDataConverter implements Converter<String, Date> {
    /**
     * 用于把 String 类型转成日期类型
     */
    @Override
    public Date convert(String data) {
        DateFormat format = null;
        //在这里将类型转换
        format = new SimpleDateFormat();
        try {
            Date parse = format.parse(data);
            return parse;
        } catch (ParseException e) {
            throw new RuntimeException("输入日期有误");
        }


    }

}

