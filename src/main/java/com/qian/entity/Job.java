package com.qian.entity;

/**
 * Created by Andy on 2018/1/20.
 */
//表明这是个需要生成数据表的类
//@Entity
public class Job {
//    定义主键id
//    @Id
//    声明一个策略通用生成器，name为”system-uuid”,策略strategy为”uuid”。
//    @GenericGenerator(name = "system-uuid", strategy ="uuid")
//    用generator属性指定要使用的策略生成器。
//    @GeneratedValue(generator = "system-uuid")
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
