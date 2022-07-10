package site.xuanwo.git.log.analyze.bean;

import java.util.Date;

/**
 * git日志对象
 * @author 飞鱼
 */
public class GitLogDO {
    /**
     * 提交id
     */
    private String commit;

    /**
     * 作者
     */
    private String author;


    /**
     * 提交时间 : Tue Jun 14 10:17:18 2022 +0800
     */
    private Date date;

    /**
     * 提交备注
     */
    private String remark;

    /**
     * 如果是合并操作：合并来源
     */
    private String mergeFrom;

    /**
     * 如果是合并操作：合并方向
     */
    private String mergeTo;

    /**
     * 在remark上追加一行
     */
    public void appendRemark(String remark) {
        if (remark == null || "".equals(remark)) {
            return;
        }
        if (this.remark == null || "".equals(this.remark)) {
            this.remark = remark;
        } else {
            this.remark = "\n" + remark;
        }
    }

    public String getCommit() {
        return commit;
    }

    public void setCommit(String commit) {
        this.commit = commit;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMergeFrom() {
        return mergeFrom;
    }

    public void setMergeFrom(String mergeFrom) {
        this.mergeFrom = mergeFrom;
    }

    public String getMergeTo() {
        return mergeTo;
    }

    public void setMergeTo(String mergeTo) {
        this.mergeTo = mergeTo;
    }

    @Override
    public String toString() {
        return "GitLogDO{" +
                "commit='" + commit + '\'' +
                ", author='" + author + '\'' +
                ", date=" + date +
                ", remark='" + remark + '\'' +
                ", mergeFrom='" + mergeFrom + '\'' +
                ", mergeTo='" + mergeTo + '\'' +
                '}';
    }
}
