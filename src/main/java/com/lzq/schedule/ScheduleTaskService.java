//package com.lzq.schedule;
//
//import com.lzq.jms.Producer;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//
///**
// * @author lzq
// * @version 1.0
// * @description cron task
// * @since 2017/7/5 15:40
// */
//
//@Service
//public class ScheduleTaskService {
//    Logger log = LoggerFactory.getLogger(ScheduleTaskService.class);
//
//    @Resource
//    private Producer producer;
//
//    @Scheduled(fixedRate = 10 * 1000L)
//    public void push() {
//        producer.sendMessage("test push message");
//        log.trace("task send message");
//    }
//
//
//}
//
//
//
