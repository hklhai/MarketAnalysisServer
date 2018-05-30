package com.hxqh.ma.service;

import com.hxqh.ma.model.BaiduInfo;
import com.hxqh.ma.model.CrawlerDoubanScore;
import com.hxqh.ma.model.Task;
import com.hxqh.ma.model.User;
import com.hxqh.ma.model.assist.Show;
import com.hxqh.ma.model.assist.TaskDto;
import com.hxqh.ma.repository.BaiduInfoRepository;
import com.hxqh.ma.repository.CrawlerDoubanSocreRepository;
import com.hxqh.ma.repository.TaskRepository;
import com.hxqh.ma.repository.UserRepository;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ocean lin on 2018/4/8.
 *
 * @author Ocean lin
 */
@Service("systemService")
public class SystemServiceImpl implements SystemService {

    @Autowired
    private UserRepository userDao;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private BaiduInfoRepository baiduInfoRepository;
    @Autowired
    private CrawlerDoubanSocreRepository crawlerDoubanSocreRepository;
    @Autowired
    private TransportClient client;

    public User findUserById(String name) {
        return userDao.findUserById(name);
    }

    @Transactional
    public void addTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public TaskDto taskData(Task task, Pageable page) {
        Page<Task> taskList = taskRepository.findAll(page);
        List<Task> users = taskList.getContent();//获取结果集
        Integer totalPages = taskList.getTotalPages();
        TaskDto taskDto = new TaskDto(users, page, totalPages);
        return taskDto;
    }

    @Modifying
    @Transactional
    @Override
    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public Show showData(Long taskid) {
        Task task = taskRepository.findOne(taskid);
        String title = task.getTaskName().split(" ")[0];

        // 查询MySQL 百度数据
        BaiduInfo baiduInfo = null;
        List<BaiduInfo> baiduInfoList = baiduInfoRepository.getByName(title);
        if (baiduInfoList.size() > 0) {
            baiduInfo = baiduInfoList.get(0);
        }

        // 查询MySQL 豆瓣数据
        List<CrawlerDoubanScore> doubanScoreList = crawlerDoubanSocreRepository.getByTitle(title);
        CrawlerDoubanScore doubanScore = null;
        if (doubanScoreList.size() > 0) {
            doubanScore = doubanScoreList.get(0);
        }

        Show show = new Show(title, baiduInfo, doubanScore);
        return show;
    }


}
