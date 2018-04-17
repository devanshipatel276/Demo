package com.example.devanshi.retrofitdemo.model;

/**
 * Created by Devanshi on 22-03-2018.
 */

public class TaskLabelId
{

    public int taskid;
    public int labelid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String id;

    public int getTaskid() {
        return taskid;
    }

    public void setTaskid(int taskid) {
        this.taskid = taskid;
    }

    public int getLabelid() {
        return labelid;
    }

    public void setLabelid(int labelid) {
        this.labelid = labelid;
    }
}
