####项目介绍
    pmp（project manager platform）项目管理平台的后端项目启动，监控系统
   
####项目构成
    1: 程序分发模块(pmp-backend-distribution-project)
        1.1 资源下载
        1.2 资源校验
        1.3 资源上传到指定的服务器上
        1.4 所需要的参数
               	"params":{
               				"项目名":"",
               				"发布目标服务器地址":"",
               				"日志路径":"",
               				"jvm参数":"",
               				"python参数":"",
               				"spark参数":"",
               				"yarn参数":"",
               			},
               
               	"dowland":{
               
               		"文件系统类型":""，
               		"下载地址":""
               	}
               

                
    2: 程序启动模块
    3: 项目监控模块



#####待解决问题
    1: 单例模式详细思考
    2: hadoop 客户端加载内部源码解析