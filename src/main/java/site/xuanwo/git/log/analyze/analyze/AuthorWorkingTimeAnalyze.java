package site.xuanwo.git.log.analyze.analyze;

import cn.hutool.core.collection.CollUtil;
import site.xuanwo.git.log.analyze.bean.GitLogDO;
import site.xuanwo.git.log.analyze.util.Log;
import site.xuanwo.git.log.analyze.vo.AuthorWorkingYearsStatiscVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分析提交者在职时长
 *
 * @author 飞鱼
 */
public class AuthorWorkingTimeAnalyze implements Analyze {

    @Override
    public void analyze(List<GitLogDO> logs) {

        Map<String, AuthorWorkingYearsStatiscVO> map = new HashMap<>(logs.size());

        AuthorWorkingYearsStatiscVO author = null;
        // 分析每一条日志，得出每个提交者的在职时长
        for (GitLogDO logDO : logs) {

            if (map.containsKey(logDO.getAuthor())) {
                author = map.get(logDO.getAuthor());

                if (author.getBeginTime().after(logDO.getDate())) {
                    author.setBeginTime(logDO.getDate());
                }
                if (author.getEndTime().before(logDO.getDate())) {
                    author.setEndTime(logDO.getDate());
                }

            } else {
                author = new AuthorWorkingYearsStatiscVO();
                author.setName(logDO.getAuthor());
                author.setBeginTime(logDO.getDate());
                author.setEndTime(logDO.getDate());
                map.put(logDO.getAuthor(), author);
            }

        }

        if (map.size() > 0) {
            Log.info("在职时间统计：");
        }
        for (AuthorWorkingYearsStatiscVO authorT : map.values()) {
            Log.info(authorT.toString());
        }
    }
}
