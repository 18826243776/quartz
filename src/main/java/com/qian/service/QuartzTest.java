package com.qian.service;

import com.qian.entity.Test1;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class QuartzTest {

    public static void main(String[] args) {
        try {
            // Grab the Scheduler instance from the Factory
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            // and start it off
            scheduler.start();

            // Trigger the job to run now, and then repeat every 40 seconds
            Trigger trigger = newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInSeconds(10)
                            .repeatForever())
                    .build();

            List<String> list=new ArrayList<>(16);
            list.add("雅士了你");
            JobDataMap map = new JobDataMap();
            map.put("list",list);
            Test1 test1 = new Test1();
            test1.setId("uuid");
            map.put("test1",test1);
            map.put("id","0000000001");
            // define the job and tie it to our HelloJob class
            JobDetail job = newJob(HelloJob.class)
                    .withIdentity("job1", "group1")
                    .usingJobData(map)
                    .build();
            JobDetail job1 = newJob(HelloJob.class)
                    .withIdentity("job2", "group2")
                    .usingJobData(map)
                    .build();
            // Tell quartz to schedule the job using our trigger
            scheduler.scheduleJob(job, trigger);
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        scheduler.scheduleJob(job1, trigger);
//                    } catch (SchedulerException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();
            scheduler.scheduleJob(job1, trigger);


//            scheduler.shutdown(true);

        } catch (SchedulerException se) {
            se.printStackTrace();
        }
    }


}