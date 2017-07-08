# **一**
本项目采用 SpringBoot + ssm + MySql(连接池采用C3P0),暂时的框架只有这些,因为对Springboot不太了解,目录结构先这样写,有谁明白可以改一下 111111222


# **二**
### 2.1 ###
本项目完全采用驼峰命名,英文命名,禁止拼音,不会请自行有道,或者百度或者....

### 2.2 ###
本项目Service层接口命名规范为
例:  IStudentService (接口为I开头[字母:i],Service结尾)
	 实现类为StudentService(去掉I即可)

本项目Dao层接口命名规范为
例:  IStudentDao (接口为I开头[字母:i],Dao结尾)
     注:因为采用代理的方式直接注入即可

本项目Controller层命名规范为
例:  StudentController
### 2.3 ###
本项目注入采用
@Resource	注解

例如
public class StudentController {
    
	#####注入在这里######
    @Resource
    private IStudentDao studentService;

  	@RequestMapping("/getStudentInfo")
    @ResponseBody
    public Student getUserInfo() {
        Student stu = studentService.findStudenInfo();
        return stu;
    }
}

### 2.4 ###
本项目目录分层为

![](http://i.imgur.com/u3cyNE7.png)

# 三 #

### 关于XML以及其他配置文件 ###

resource 目录结构

![](http://i.imgur.com/hhEKiTR.png)


大致结构如图


![](http://i.imgur.com/vNqrFcY.png)