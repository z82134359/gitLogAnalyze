package site.xuanwo.git.log.analyze;

import site.xuanwo.git.log.analyze.analyze.AuthorWorkingTimeAnalyze;
import site.xuanwo.git.log.analyze.parse.LogFileParse;
import site.xuanwo.git.log.analyze.read.LogFileReader;
import site.xuanwo.git.log.analyze.util.Log;

import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 员工在职时长分析demo
 *
 * @author 飞鱼
 */
public class Demo {

    public static void main(String[] args) throws ParseException {
        AnalyzeEngine engine = new AnalyzeEngine();
        // 日志文件由reader加载
        engine.setReader(new LogFileReader("C:\\log.txt", Charset.forName("utf8")))
                // 由parse解析
                .setParse(new LogFileParse(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")))
                // 由Analyze进行分析、输出结果
                .addAnalyzes(new AuthorWorkingTimeAnalyze());
        try {
            engine.analyze(); // 执行分析
        } catch (ParseException e) {
            Log.info("分析异常：" + e.getMessage());
        }


    }
}
