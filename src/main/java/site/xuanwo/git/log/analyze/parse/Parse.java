package site.xuanwo.git.log.analyze.parse;

import site.xuanwo.git.log.analyze.bean.GitLogDO;

import java.text.ParseException;
import java.util.List;

/**
 * 解析器，负责将文本类型的日志解析为对应规则的JavaBean
 * @author 飞鱼
 */
public interface Parse {

    /**
     * 解析日志文件为通用log对象
     * @param log reader读取到的日志文件
     * @return 解析后的日志对象列表
     * @throws ParseException 解析异常时抛出
     */
    public List<GitLogDO> parse(String log) throws ParseException;
}
