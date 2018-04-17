package com.example.devanshi.retrofitdemo.model;

import java.util.ArrayList;

/**
 * Created by Devanshi on 08-03-2018.
 */

public class Task
{
    public String task;
    public int id;
   public String task_name;
   public ArrayList<Label> labels;


    public ArrayList<Label> getLabels() {
        return labels;
    }

    public void setLabels(ArrayList<Label> labels) {
        this.labels = labels;
    }


   public int taskLabelid;
  // public String taskLabelName;

//    public String getTaskLabelName() {
//        return taskLabelName;
//    }
//
//    public void setTaskLabelName(String taskLabelName) {
//        this.taskLabelName = taskLabelName;
//    }
//
//    public ArrayList<Label> getTaskLabelName() {
//        return taskLabelName;
//    }
//
//    public void setTaskLabelName(ArrayList<Label> taskLabelName) {
//        this.taskLabelName = taskLabelName;
//    }

    public int getTaskLabelid() {
        return taskLabelid;
    }

    public void setTaskLabelid(int taskLabelid) {
        this.taskLabelid = taskLabelid;
    }

    public boolean isChecked;

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }



    public Task(String task)
    {
        this.task=task;
    }

    public Task() {

    }

    public boolean getChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
