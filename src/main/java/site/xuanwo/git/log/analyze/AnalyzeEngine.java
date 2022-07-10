package site.xuanwo.git.log.analyze;

import site.xuanwo.git.log.analyze.analyze.Analyze;
import site.xuanwo.git.log.analyze.bean.GitLogDO;
import site.xuanwo.git.log.analyze.parse.Parse;
import site.xuanwo.git.log.analyze.read.LogReader;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

/**
 * 分析引擎
 *
 * @author 飞鱼
 */
public class AnalyzeEngine {
    /**
     * 日志加载器
     */
    private LogReader reader;

    /**
     * 日志解析器
     */
    private Parse parse;

    /**
     * 日志分析器
     */
    private LinkedList<Analyze> analyzes = new LinkedList<>();

    /**
     * 设置日志读取器
     */
    public AnalyzeEngine setReader(LogReader reader) {
        this.reader = reader;
        return this;
    }

    /**
     * 设置日志解析器
     */
    public AnalyzeEngine setParse(Parse parse) {
        this.parse = parse;
        return this;
    }

    /**
     * 增加分析器
     */
    public AnalyzeEngine addAnalyzes(Analyze analyze) {
        analyzes.add(analyze);
        return this;
    }

    /**
     * 开始分析
     */
    public AnalyzeEngine analyze() throws ParseException {
        String logString = reader.read();
        List<GitLogDO> logs = parse.parse(logString);
        for (Analyze analyze : analyzes) {
            analyze.analyze(logs);
        }
        return this;
    }
}
