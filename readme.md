# **git日志分析器**
<br>
入职时可通过分析git日志获得一些公司加班、人员在职时长等情况的估计，帮助大家及时避坑

项目主要有三个接口：<br>
>LogReader：实现该接口获取日志文件<br>
>Parse：解析LogReader获取到的日志为javaBean对象（GitLogDO）<br>
>Analyze：分析日志，按用户需要进行自定义分析<br>

详情可参考Demo文件