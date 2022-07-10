package site.xuanwo.git.log.analyze.vo;

import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * 按作者统计
 * @author 飞鱼
 */
public class AuthorWorkingYearsStatiscVO {
    private String name;
    private Date beginTime;
    private Date endTime;

    public String toString() {
        return name + "---" + DateUtil.formatDateTime(beginTime) + "---" + DateUtil.formatDateTime(endTime) + "---" + DateUtil.betweenDay(beginTime, endTime, true) + "天";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
