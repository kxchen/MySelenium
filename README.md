

> 公司使用java版selenuim做webui自动化，在使用过程中发现有许多的操作非常繁琐，所以利用下班休息时间根据自己的想法简单的进行了一次二次封装。我也是初出茅庐，可能有些地方写的不是很合理，在以后的工作中会不断地对其进行完善。

<!-- more -->
## Myselenium概述


#### 依赖
封装主要是依赖selenium，testng和log4j，项目使用maven构建。相关依赖已经打到发布jar包中，可直接导入使用。
* selenium-java 3.4.0
* log4j 1.2.17
* testng 1.2.17

#### 配置 
* browser.properties  浏览器相关配置文件

```
#根据自己文件实际存放路径填写配置文件
firefox.driver.path=F:\\Develop\\Drivers\\geckodriver-v0.16.1\\geckodriver.exe
firefox.app.path=D:\\software\\Mozilla Firefox\\firefox.exe
chrome.driver.path=F:\\Develop\\Drivers\\chromedriver\\chromedriver.exe
chrome.app.path=C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe
ie.driver.path="" 
ie.app.path=""
```

* database.properties 数据库配置文件

```
#根据自己的实际配置填写配置文件

```

* log4j.properties   log4j配置文件

```
#根据自己的需求填写配置文件
log4j.rootLogger = info,stdout,D,E


log4j.appender.stdout = org.apache.log4j.ConsoleAppender
log4j.appender.stdout.Target = System.out
log4j.appender.stdout.layout = org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern = [%-5p] %d{yyyy-MM-dd HH:mm:ss,SSS} method:%l%n%m%n


log4j.appender.D = org.apache.log4j.DailyRollingFileAppender
log4j.appender.D.File = logs/debug.log
log4j.appender.D.Append = true
log4j.appender.D.Threshold = DEBUG 
log4j.appender.D.layout = org.apache.log4j.PatternLayout
log4j.appender.D.layout.ConversionPattern = %-d{yyyy-MM-dd HH:mm:ss}  [ %t:%r ] - [ %p ]  %m%n


log4j.appender.E = org.apache.log4j.DailyRollingFileAppender
log4j.appender.E.File = logs/error.log 
log4j.appender.E.Append = true
log4j.appender.E.Threshold = ERROR 
log4j.appender.E.layout = org.apache.log4j.PatternLayout
log4j.appender.E.layout.ConversionPattern = %-d{yyyy-MM-dd HH:mm:ss}  [ %t:%r ] - [ %p ]  %m%n 
```
#### 启动

1. 直接使用`BrowserHelper.start("chrome");`启动浏览器，该方法会读取配置文件中的浏览器地址和浏览器驱动地址。该方法只能启动“谷歌”，“火狐”，“ie”三款常用浏览器。
2. 启动自定义浏览器

```
//设置浏览器驱动地址
System.setProperty("webdriver.gecko.driver", ReadProperties.getFIREFOX_DRIVER_PATH());
//设置浏览器地址
System.setProperty("webdriver.firefox.bin", ReadProperties.getFIREROX_APP_PATH());
//得到相应浏览器的实例（启动浏览器）
WebDriver driverInst = new FirefoxDriver();
//把得到的实例传给WebDriverFactory
WebDriverFactory.setDriverInst(driverInst);
//WebDriverFactory.setDriverInst(new FirefoxDriver());
```
## 方法详解

#### [AssertHelper 断言帮助类](#)

#### [BrowserHelper 浏览器的操作帮助类 ](#)

#### [FrameHelper Frame元素的帮助类 ](#)

#### [InputHelper Input的类型的操作公共类。](#) 

#### [KeyBoardHelper 键盘输入操作帮助类 ](#)

#### [MouseHelper 鼠标操作帮助类 ](#)

#### [PopUpHelper 提示，警告，输入的弹出对话框操作帮助类 ](#)

#### [SelectHelper Select类型操作帮助类 ](#)

#### [SleepHelper 时间等待帮助类 ](#)

#### [UploadFileHelper 上传文件帮助类 ](#)
