package com.example.devanshi.retrofitdemo.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.devanshi.retrofitdemo.R;
import com.example.devanshi.retrofitdemo.db_handler.DataBaseHandler;
import com.example.devanshi.retrofitdemo.model.Label;
import com.example.devanshi.retrofitdemo.model.Task;
import com.example.devanshi.retrofitdemo.model.TaskLabelId;
import com.example.devanshi.retrofitdemo.util.CustomItemClickListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Devanshi on 08-03-2018.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyHolder> {

    private static final String TAG = "TaskAdapter";

    private ArrayList<Task> list;
    private ArrayList<Label> labelList = new ArrayList<>();
    private ArrayList<Label> labelselected;
    private List<TaskLabelId> tasklabelidlist = new ArrayList<>();
    private List<Integer> value = new ArrayList<>();

    private Context context;
    private String item;
    private int flag = 0;
    private CustomItemClickListener listener;
    private MyListener mylistener;

    public TaskAdapter(Context context, ArrayList<Task> list) {
        this.context = context;
        this.list = list;
    }

    public void setCustomObjectListener(MyListener myListener) {
        this.mylistener = myListener;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.task_row, parent, false);
        final TaskAdapter.MyHolder viewHolder = new TaskAdapter.MyHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, viewHolder.getPosition());
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {

        final Task task = list.get(position);
        final DataBaseHandler db = new DataBaseHandler(context);
        final Task newtask = new Task();
        Label label = new Label();
        final TaskLabelId taskLabelId = new TaskLabelId();


        //  Log.d(TAG, "onBindViewHolder: item: " + position);

        holder.taskName.setText(task.getTask());
        holder.deleteImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                deleteData(task);
                getAllData();
            }
        });

        getAllLabel();
        taskLabelId.labelid = task.getId();
        getAllTaskLabelID(taskLabelId.labelid);


        holder.labelsImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {


                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Choose an labels");
                labelList = db.getAllLabelitem();
//                getAllLabel();

                final List<String> label_liststring = new ArrayList<>();
                for (int i = 0; i < labelList.size(); i++) {
                    item = (labelList.get(i).getLabelname());
                    label_liststring.add(item);

                }

                final boolean[] checkstatus = new boolean[label_liststring.size()];
                ArrayList<TaskLabelId> selectedTaskIdsLabelIds = db.getAllTaskLabelId(task.id);

                ArrayList<Integer> selectedLabelIds = new ArrayList<>();
                for (int i = 0; i < selectedTaskIdsLabelIds.size(); i++) {
                    selectedLabelIds.add(selectedTaskIdsLabelIds.get(i).getLabelid());
                }

                ArrayList<Integer> alllabelslist = db.getAllLabelID();

                for (int i = 0; i < alllabelslist.size(); i++) {
                    int val = alllabelslist.get(i);

                    if (selectedLabelIds.contains(val)) {
                        checkstatus[i] = true;

//                        Label l = new Label();
//                        l.setLabelId(val);
                        value.add(val);
                    } else
                        {checkstatus[i] = false;}


                }

                builder.setMultiChoiceItems(label_liststring.toArray(new String[label_liststring.size()]), checkstatus, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        Label l = new Label();

                        if (isChecked) {

                            l.labelId = labelList.get(which).getLabelId();
                            Log.d(TAG, "onClick: true");

                            value.add(l.labelId);

                        } //else if (!value.contains(l.labelId))
                        else if(!isChecked)
                        {
                            l.labelId = labelList.get(which).getLabelId();
                           if( value.contains(l.labelId))
                           {
                               for (int i = 0; i <value.size() ; i++)
                               {
                                   if(l.labelId==value.get(i))
                                   {
                                       value.remove(i);
                                   }

                               }

                           }

                        }
                    }

                });


//                builder.setItems(label_liststring.toArray(new String[label_liststring.size()]), new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which)
//                    {
//                        newtask.id = list.get(position).getId();
//                        newtask.taskLabelid = labelList.get(which).getLabelId();
//                       // newtask.taskLabelName=labelList.get(which).getLabelname();
//                        holder.labelName.setText(labelList.get(which).getLabelname());
//                        updateLabel(newtask);
//                    }
//                });

                builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        View v = View.inflate(context, R.layout.custom, null);
                        final EditText label = v.findViewById(R.id.et_custom);
                        final Label labels = new Label();

                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(v);
                        builder.setTitle("Add Label");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                String edittext = label.getText().toString().trim();
                                labels.labelname = edittext;
                                addLabel(labels);
                            }
                        });
                        builder.setNegativeButton("cancel", null);
                        builder.show();

                    }
                }).setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        final DataBaseHandler db = new DataBaseHandler(context);
                        db.deleteTaskLabelid(task.getId());
//                        for (Integer l : value) {
//                            taskLabelId.taskid = task.getId();
//                            taskLabelId.labelid = l.getLabelId();
//                            addTaskLabelid(taskLabelId);
//
//                        }

                        for (int i = 0; i <value.size() ; i++)
                        {
                            taskLabelId.taskid=task.getId();
                            taskLabelId.labelid=value.get(i);
                            addTaskLabelid(taskLabelId);
                        }


                        getAllTaskLabelID(taskLabelId.taskid);
                        joinTaskLabelid(taskLabelId.getTaskid());
                        list = db.getAllTodo();
                        notifyDataSetChanged();
                        Log.d(TAG, "onClick: "+value);
                        value.clear();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        ArrayList<Label> arrayoflabelname = task.getLabels();
        String labelname = "";

        StringBuilder sb = new StringBuilder();

        for (Label l : arrayoflabelname) {
            sb.append(labelname).append(l.getLabelname());
            labelname = ",";

        }
        holder.labelName.setText(sb);
        holder.checkBox.setOnCheckedChangeListener(null);
        holder.bind(position);
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                if (list.get(position).getChecked()) {

                    newtask.isChecked = false;
                    newtask.task = list.get(position).getTask();
                    newtask.id = list.get(position).getId();
                    updateAllData(newtask);
                    list.get(position).setChecked(false);

                } else {


                    newtask.isChecked = true;
                    newtask.task = list.get(position).getTask();
                    newtask.id = list.get(position).getId();

                    updateAllData(newtask);
                    list.get(position).setChecked(true);

                }

                update();
            }
        });
//        animate(holder);

        //Log.d(TAG, "onBindViewHolder: Item name"+task.getTask()+" Item id"+task.getId()+"Item State"+task.getChecked()+"Item LabelName"+task.getTaskLabelName()+"Item labelId"+task.getTaskLabelid());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public TaskAdapter(Context mContext, ArrayList<Task> data, CustomItemClickListener listener) {
        this.list = data;
        this.context = mContext;
        this.listener = listener;
    }

    public void animate(RecyclerView.ViewHolder viewHolder) {
        final Animation animAnticipateOvershoot = AnimationUtils.loadAnimation(context, R.anim.anticipate_overshoot_interpolator);
        viewHolder.itemView.setAnimation(animAnticipateOvershoot);
    }


    public class MyHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        TextView taskName, labelName;
        ImageView deleteImageView, labelsImage;

        public MyHolder(View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.checkbox_todo);
            taskName = itemView.findViewById(R.id.tvTask_todo);
            deleteImageView = itemView.findViewById(R.id.im_todo);
            labelsImage = itemView.findViewById(R.id.label_todo);
            labelName = itemView.findViewById(R.id.tvLabel);
        }

        public void bind(int position) {
            if (list.get(position).getChecked()) {
                checkBox.setChecked(true);
                taskName.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            } else {
                checkBox.setChecked(false);
                taskName.setPaintFlags(Paint.LINEAR_TEXT_FLAG);
            }
        }
    }

    void update() {
        Collections.sort(list, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {

                return Boolean.compare(o1.getChecked(), o2.getChecked());

            }
        });
        notifyDataSetChanged();

        //  Log.d(TAG, "update: ------------------------------------");
        for (Task listItem : list) {
            //Log.d(TAG, "update: " + listItem.getChecked() + " : " + listItem.getTask());
        }
    }

    void getAllData() {
        DataBaseHandler db = new DataBaseHandler(context);
        list = db.getAllTodo();
    }

    void deleteData(Task task) {
        DataBaseHandler db = new DataBaseHandler(context);
        db.delete(task);
        notifyDataSetChanged();
    }

    void updateLabel(Task task) {
        DataBaseHandler db = new DataBaseHandler(context);
        db.updateLable(task);

    }

    void addLabel(Label labels) {
        DataBaseHandler db = new DataBaseHandler(context);
        db.addLabelitem(labels);
    }

    void updateAllData(Task task) {
        DataBaseHandler db = new DataBaseHandler(context);
        db.updateTODO(task);
    }

    void getAllLabel() {
        DataBaseHandler db = new DataBaseHandler(context);
        labelList = db.getAllLabelitem();
    }

    void addTaskLabelid(TaskLabelId taskLabelId) {
        DataBaseHandler db = new DataBaseHandler(context);
        db.addTaskLabelid(taskLabelId);

    }

    void updateTaskLabelid(TaskLabelId taskLabelId) {
        DataBaseHandler db = new DataBaseHandler(context);
        db.updateTaskLabel(taskLabelId);

    }

    void joinTaskLabelid(int taskid) {
        DataBaseHandler db = new DataBaseHandler(context);
        db.joinTaskLabel(taskid);
    }

    void getAllTaskLabelID(int id) {
        DataBaseHandler db = new DataBaseHandler(context);
        tasklabelidlist = db.getAllTaskLabelId(id);
        Log.d(TAG, "getAllTaskLabelID: " + tasklabelidlist);
    }
//    void getAllLabelId()
//    {
//        DataBaseHandler db=new DataBaseHandler(context);
//        ArrayList<Label> labelArrayList=new ArrayList<>();
//        labelArrayList=db.getAllLabelID();
//        value.add(labelArrayList);
//        Log.d(TAG, "getAllLabelId:... "+value);
//    }

    public interface MyListener {
        void refresh(ArrayList<Task> arrayList);
    }
}


