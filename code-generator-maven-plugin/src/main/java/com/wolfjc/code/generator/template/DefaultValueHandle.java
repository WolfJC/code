package com.wolfjc.code.generator.template;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用来处理默认值
 *
 * @author xdd
 * @date 2018/7/16.
 */
public class DefaultValueHandle {

    /**
     * 若未设置时间则使用当前时间
     *
     * @param dateTime
     * @return
     */
    public static String handleDenfaultDateTime(String dateTime) {
        if (!StringUtils.isEmpty(dateTime)) {
            return dateTime;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(new Date());
    }
}
