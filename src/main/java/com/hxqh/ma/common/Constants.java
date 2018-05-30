package com.hxqh.ma.common;

/**
 * Created by Ocean lin on 2018/1/16.
 *
 * @author Lin
 */
public interface Constants {

    String os = System.getProperty("os.name");

    String CHROMEDRIVER = os.toLowerCase().startsWith("win") == true ? "E:\\Program\\chromedriver.exe" : "/usr/bin/chromedriver";
    String SAVE_PATH = os.toLowerCase().startsWith("win") == true ? "E:\\crawler" : "/home/hadoop/crawler";
    String FILE_SPLIT = os.toLowerCase().startsWith("win") == true ? "\\" : "/";
    String FILE_LOC = os.toLowerCase().startsWith("win") == true ? "\\videos" : "/videos";
    String BOOK_JD_FILE_LOC = os.toLowerCase().startsWith("win") == true ? "\\book" : "/book";
    String HOST_SPARK1 = "spark1";
    String HOST_SPARK2 = "spark2";
    String HOST_SPARK3 = "spark3";
    String HOST_SPARK4 = "spark4";
    String MAOYAN_PATH = os.toLowerCase().startsWith("win") == true ? "E:\\crawler\\maoyan" : "/home/hadoop/crawler/maoyan";
    String MAOYAN_THREE_SECOND_PATH = os.toLowerCase().startsWith("win") == true ? "E:\\crawler\\maoyan_three" : "/home/hadoop/crawler/maoyan_three";
    String PHANTOMJS_PATH = os.toLowerCase().startsWith("win") == true ?
            "E:\\Program\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe" : "/usr/bin/phantomjs";


    /**
     * ElasticSearch 6.x config
     */
    Integer ES_PORT = 9300;


    Integer SUCCESS = 1;
    Integer FAIL = 0;

    String ADDSUCCESS = "Add Success!";
    String ADDFAIL = "Add Fail!";


    /**
     * Task Status
     */
    String UNSUBMIT = "unsubmit";  // 未提交
    String UNDO = "undo";          // 未执行
    String RUNNING = "running";    // 运行中
    String FINISH = "finish";      // 已完成
    String TASKFAIL = "taskfail";  // 任务失败
    String NODATA = "nodata";      // 无数据

    /**
     * 任务相关的常量
     */
    String PARAM_START_DATE = "startTime";
    String PARAM_END_DATE = "endTime";
    String PARAM_CATEGORY = "category";
    String PARAM_TITLE = "title";
}
