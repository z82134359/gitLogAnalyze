package site.xuanwo.git.log.analyze.analyze;

import site.xuanwo.git.log.analyze.bean.GitLogDO;

import java.util.List;

/**
 * 对最终获得的log列表进行分析，如果有需要对结果进行输出也在这个接口的实现里操作
 * @author 飞鱼
 */
public interface Analyze {

    /**
     * 分析日志，分析结果也在此接口自行输出
     * @param logs 分析器采集到的log列表
     */
    public void analyze(List<GitLogDO> logs);

}
