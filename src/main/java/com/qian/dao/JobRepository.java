package com.qian.dao;

import com.qian.entity.Job;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Andy on 2018/1/26.
 */
public interface JobRepository extends CrudRepository<Job,String> {

}
