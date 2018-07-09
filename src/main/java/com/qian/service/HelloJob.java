package com.qian.service;

import com.qian.entity.Test1;
import org.quartz.*;

import java.util.List;
//tells Quartz to update the stored copy of the JobDetail’s JobDataMap
// the execute() method completes successfully (without throwing an exception),
// such that the next execution of the same job (JobDetail) receives the updated values
// rather than the originally stored values
//@PersistJobDataAfterExecution
//tells Quartz not to execute multiple instances of a given job definition
// (that refers to the given job class) concurrently.
//@DisallowConcurrentExecution
public class HelloJob implements Job {

    private String id;
    private List<String> list;
    private Test1 test1;

    public void setId(String id) {
        this.id = id;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setTest1(Test1 test1) {
        this.test1 = test1;
    }

    public HelloJob() {
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
//        JobDetail detail = context.getJobDetail();
//        JobKey key = detail.getKey();
//        JobDataMap map = detail.getJobDataMap();
//        List list = (ArrayList) map.get("list");
//        System.out.println(list.get(0));
//        Test1 test1 = (Test1) map.get("test1");
//        String id = test1.getId();
//        System.out.println(id);
        System.out.println(id);
        System.out.println(list.get(0));
        System.out.println(test1.getId());
    }
}