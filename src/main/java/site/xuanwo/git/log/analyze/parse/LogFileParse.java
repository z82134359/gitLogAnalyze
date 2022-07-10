package site.xuanwo.git.log.analyze.parse;

import cn.hutool.core.util.StrUtil;
import site.xuanwo.git.log.analyze.bean.GitLogDO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 解析来自日志文件
 * @author 飞鱼
 */
public class LogFileParse implements Parse {

    private final SimpleDateFormat dateFormat;

    public LogFileParse(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public List<GitLogDO> parse(String log) throws ParseException {
        log = log.replace(String.valueOf(Character.MIN_VALUE), "");
        String[] logs = log.split("\r\n");

        List<GitLogDO> list = new ArrayList<>();

        GitLogDO t = new GitLogDO();

        for (String line : logs) {

            if (line.startsWith("commit")) {
                t = new GitLogDO();
                list.add(t);
                t.setCommit(line.substring(7));
            } else if (line.startsWith("Author")) {
                String author = line.substring(8);
                t.setAuthor(author);
            } else if (line.startsWith("Date")) {
                String date = line.substring(8);
                t.setDate(dateFormat.parse(date));
            } else if (line.startsWith("Merge")) {
                String merge = line.substring(7);
                String[] merges = merge.split(" ");
                t.setMergeFrom(merges[0]);
                t.setMergeTo(merges[1]);
            } else {
                t.appendRemark(StrUtil.trimToNull(line));
            }
        }

        return list;
    }
}
