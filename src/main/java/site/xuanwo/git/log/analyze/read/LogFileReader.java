package site.xuanwo.git.log.analyze.read;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.nio.charset.Charset;

/**
 * 从文件读取日志
 * 日志来源于git命令：git log --date=format:'%Y-%m-%d %H:%M:%S' >> C:\log.txt
 * 注意文本编码格式
 * @author 飞鱼
 */
public class LogFileReader implements LogReader {
    /**
     * 文件路径
     */
    private String path;
    private Charset charset;

    public LogFileReader(String path, Charset charset) {
        this.path = path;
        this.charset = charset;
    }

    @Override
    public String read() {
        String log = FileUtil.readString(new File(path), charset);
        return log;
    }
}
