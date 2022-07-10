package site.xuanwo.git.log.analyze.read;

/**
 * 负责获取日志
 * @author 飞鱼
 */
public interface LogReader {

    /**
     * 读取日志
     * @return 读取到的日志文件
     */
    public String read();
}
