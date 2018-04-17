package com.example.devanshi.retrofitdemo.db_handler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.devanshi.retrofitdemo.model.Label;
import com.example.devanshi.retrofitdemo.model.Task;
import com.example.devanshi.retrofitdemo.model.TaskLabelId;
import com.example.devanshi.retrofitdemo.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Devanshi on 06-03-2018.
 */

public class DataBaseHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "UserDatabase";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_USER = "user";
    private static final String TABLE_TODO = "todo";
    private static final String TABLE_LABEL = "labelitem";
    private static final String TABLE_TASKLABEL = "tasklabelid";
    private static final String KEY_TASK = "task";
    private static final String KEY_TASKNAME = "taskname";
    private static final String KEY_LABELNAME = "labelname";
    private static final String KEY_LABELID = "labelid";
    private static final String KEY_TASKID = "taskid";
    private static final String KEY_STATE = "state";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_GENDER = "gender";
    private static final String KEY_PHOTO = "photo";
    private static final String TAG = "DataBaseHandler";
    private SQLiteDatabase db;

    public DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = " CREATE TABLE " + TABLE_USER + " ( " + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_NAME + " TEXT, " + KEY_EMAIL + " TEXT," + KEY_PASSWORD + " TEXT, " + KEY_PHONE + " TEXT," + KEY_GENDER + " TEXT, " + KEY_PHOTO + " TEXT " + ")";
        Log.d(TAG, "hi my name is" + CREATE_USER_TABLE);
        db.execSQL(CREATE_USER_TABLE);

        String CREATE_TODO_TABLE = " CREATE TABLE " + TABLE_TODO + " ( " + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TASK + " TEXT, " + KEY_STATE + " TEXT, " + KEY_TASKNAME + " TEXT, " + KEY_LABELID + " TEXT," + KEY_LABELNAME + " TEXT " + " )";
        db.execSQL(CREATE_TODO_TABLE);

        String CREATE_Label_TABLE = " CREATE TABLE " + TABLE_LABEL + " ( " + KEY_LABELID + " INTEGER PRIMARY KEY," + KEY_LABELNAME + " TEXT " + " )";
        db.execSQL(CREATE_Label_TABLE);

        String CREATE_TASKLABEL_TABLE = " CREATE TABLE " + TABLE_TASKLABEL + " ( " + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TASKID + " TEXT, " + KEY_LABELID + " TEXT " + " )";
        db.execSQL(CREATE_TASKLABEL_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }

    public void addUser(User user) {
        db = this.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(KEY_NAME, user.getName());
            values.put(KEY_EMAIL, user.getEmail());
            values.put(KEY_PASSWORD, user.getPassword());
            values.put(KEY_PHONE, user.getPhone());
            values.put(KEY_GENDER, user.getGender());
            values.put(KEY_PHOTO, user.get_img());
            db.insertOrThrow(TABLE_USER, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d("Exception", "" + e);

        } finally {
            db.endTransaction();
        }

    }

    public List<User> getAllUser() {
        List<User> users = new ArrayList<User>();
        String USER_SELECTED_QUERY = " SELECT * FROM " + TABLE_USER;
        db = getReadableDatabase();
        Cursor cursor = db.rawQuery(USER_SELECTED_QUERY, null);
        try {
//            if (cursor.moveToFirst()) {
//                do {
            while (cursor.moveToNext()) {
                User newUser = new User();
                newUser.id = cursor.getString(cursor.getColumnIndex(KEY_ID));
                newUser.email = cursor.getString(cursor.getColumnIndex(KEY_EMAIL));
                newUser.password = cursor.getString(cursor.getColumnIndex(KEY_PASSWORD));
                newUser.name = cursor.getString(cursor.getColumnIndex(KEY_NAME));
                newUser.phone = cursor.getString(cursor.getColumnIndex(KEY_PHONE));
                newUser._img = cursor.getString(cursor.getColumnIndex(KEY_PHOTO));
                users.add(newUser);

            } //while (cursor.moveToNext());
            //}
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get posts from database");
        }


        return users;
    }

    public int updateUser(User user) {
        db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME, user.getName());
        contentValues.put(KEY_PHONE, user.getPhone());
        contentValues.put(KEY_PHOTO, user.get_img());
        contentValues.put(KEY_PASSWORD, user.getPassword());
        contentValues.put(KEY_EMAIL, user.getEmail());

        int value = db.update(TABLE_USER, contentValues, KEY_ID + " = ?", new String[]{String.valueOf(user.id)});
        Log.d("HEY", "HERE" + user.id);
        Log.d("name", "values=" + value);
        return value;
    }


//------------------------------------------------------------------------------------------------------------------------------------

    public void addTODO(Task task) {
        db = this.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(KEY_TASK, task.getTask());
            values.put(KEY_STATE, task.getChecked());
            values.put(KEY_TASKNAME, task.getTask_name());


            db.insertOrThrow(TABLE_TODO, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d("Exception", "" + e);

        } finally {
            db.endTransaction();
        }

    }


    public ArrayList<Task> getAllTodo() {
        ArrayList<Label> labellist = getAllLabelitem();
        ArrayList<TaskLabelId> taskLabelIds = getAllTaskLabelId();
//        HashMap<Integer, Label> hashMap = new HashMap<>();
//        for (Label obj : labellist) {
//            hashMap.put(obj.getLabelId(), obj);
//        }
        Map<Integer, String> hashMap1 = new HashMap<>();

        ArrayList<Task> task = new ArrayList<Task>();
        ArrayList<TaskLabelId> list = new ArrayList<>();
        ArrayList<String> labels = new ArrayList<>();
        String TODO_SELECTED_QUERY = " SELECT * FROM " + TABLE_TODO;
        db = getReadableDatabase();
        Cursor cursor = db.rawQuery(TODO_SELECTED_QUERY, null);
        try {
            while (cursor.moveToNext()) {
                Task newTask = new Task();
                newTask.id = cursor.getInt(cursor.getColumnIndex(KEY_ID));
                newTask.isChecked = Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(KEY_STATE)));
                newTask.task = cursor.getString(cursor.getColumnIndex(KEY_TASK));
                int item = cursor.getInt(cursor.getColumnIndex(KEY_LABELID));
                newTask.setLabels(joinTaskLabel(newTask.id));
//                       newTask.taskLabelName = hashMap.get(item).getLabelname();
//                      newTask.taskLabelName = labelJoin(item);
//                        newTask.taskLabelName=joinTaskLabel(newTask.id,item);
//
//                    if (hashMap1.containsKey(item)) {
//
//                        newTask.taskLabelName = hashMap1.get(item);
//                    } else {
//                        hashMap1.put(item, labelJoin(item));
//                        newTask.taskLabelName = hashMap1.get(item);
//
//                    }
                task.add(newTask);
                Log.d(TAG, "getAllTodo:....new label" + newTask.getLabels());

            }

        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get posts from database");
        } finally {
            cursor.close();
        }

        return task;
    }

    public void updateTODO(Task user) {
        db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_STATE, user.getChecked());
        contentValues.put(KEY_TASK, user.getTask());

        db.execSQL("update " + TABLE_TODO + " set " + KEY_STATE + "='" + user.getChecked() + "' where " + KEY_ID + "=" + user.getId() + " AND " + KEY_TASK + "='" + user.getTask() + "'");
        db.close();
    }

    public int updateLable(Task task) {
        db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_ID, task.getId());
        int value = db.update(TABLE_TODO, contentValues, KEY_ID + " = ?", new String[]{String.valueOf(task.id)});
        Log.d("HEY", "HERE" + task.id);

        return value;

    }

    public void delete(Task user) {
        db = getWritableDatabase();
        db.delete(TABLE_TODO, KEY_ID + " = ?", new String[]{String.valueOf(user.id)});
        db.close();
    }

    public ArrayList<Task> Taskjoin(String name) {
        db = getReadableDatabase();
        ArrayList<Task> task = new ArrayList<Task>();
        String TODO_SELECTED_QUERY = "SELECT " + " * " + " FROM " + TABLE_TODO + " where " + KEY_TASKNAME + "='" + name + "'";

        Cursor cursor = db.rawQuery(TODO_SELECTED_QUERY, null);
        try {

            while (cursor.moveToNext()) {
                Task newtask = new Task();

                newtask.id = cursor.getInt(cursor.getColumnIndex(KEY_ID));
                newtask.isChecked = Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(KEY_STATE)));
                newtask.task = cursor.getString(cursor.getColumnIndex(KEY_TASK));
                task.add(newtask);

            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get posts from database");
        }
        return task;
    }

    //---------------------------------------------------------------------------------------------------------------------------------------
    public void addLabelitem(Label label) {
        db = this.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(KEY_LABELNAME, label.getLabelname());
            db.insertOrThrow(TABLE_LABEL, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d("Exception", "" + e);

        } finally {
            db.endTransaction();
        }

    }

    public ArrayList<Label> getAllLabelitem() {
        ArrayList<Label> labels = new ArrayList<Label>();
        String TODO_SELECTED_QUERY = " SELECT * FROM " + TABLE_LABEL;
        db = getReadableDatabase();
        Cursor cursor = db.rawQuery(TODO_SELECTED_QUERY, null);
        try {
            while (cursor.moveToNext()) {
                Label newTask = new Label();

                newTask.labelId = cursor.getInt(cursor.getColumnIndex(KEY_LABELID));
                newTask.labelname = cursor.getString(cursor.getColumnIndex(KEY_LABELNAME));

                labels.add(newTask);

            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get posts from database");
        }
        Log.d(TAG, "getAllLabelitem: " + labels);
        return labels;
    }

    public void deleteLabelitem(Label label) {
        db = getWritableDatabase();
        db.delete(TABLE_LABEL, KEY_LABELNAME + " = ?", new String[]{String.valueOf(label.labelname)});
        db.close();
    }

    public String labelJoin(int id) {
        db = getReadableDatabase();
        String labels = null;
        String TODO_SELECTED_QUERY = "SELECT " + " * " + " FROM " + TABLE_LABEL + " where " + KEY_LABELID + "='" + id + "'";

        Cursor cursor = db.rawQuery(TODO_SELECTED_QUERY, null);
        try {
            while (cursor.moveToNext()) {
                Label newtask = new Label();

                newtask.labelname = cursor.getString(cursor.getColumnIndex(KEY_LABELNAME));
                labels = newtask.getLabelname();

            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get posts from database");
        }

        return labels;
    }


//    public ArrayList<Label> getAllLabelID() {
//        ArrayList<Label> labels = new ArrayList<Label>();
//        String TODO_SELECTED_QUERY = " SELECT " + KEY_LABELID + " FROM " + TABLE_LABEL;
//        db = getReadableDatabase();
//        Cursor cursor = db.rawQuery(TODO_SELECTED_QUERY, null);
//        try {
//            if (cursor.moveToFirst()) {
//                do {
//                    Label newTask = new Label();
//
//                    newTask.labelId = cursor.getInt(cursor.getColumnIndex(KEY_LABELID));
//                    //newTask.labelname = cursor.getString(cursor.getColumnIndex(KEY_LABELNAME));
//
//                    labels.add(newTask);
//
//                } while (cursor.moveToNext());
//            }
//        } catch (Exception e) {
//            Log.d(TAG, "Error while trying to get posts from database");
//        }
//        Log.d(TAG, "getAllLabelitem: "+labels);
//        return labels;
//    }

    public ArrayList<TaskLabelId> getAllTaskLabelId(int id) {
        ArrayList<TaskLabelId> taskLabelIdList = new ArrayList<TaskLabelId>();
        String TASKLABEL_SELECTED_QUERY = " SELECT * FROM " + TABLE_TASKLABEL + " WHERE " + KEY_TASKID + " = '" + id + "' ";
        Log.d(TAG, "getAllTaskLabelId:... "+TASKLABEL_SELECTED_QUERY);
        db = getReadableDatabase();
        Cursor cursor = db.rawQuery(TASKLABEL_SELECTED_QUERY, null);
        try {
            while (cursor.moveToNext()) {
                TaskLabelId taskLabelId = new TaskLabelId();
                taskLabelId.taskid = cursor.getInt(cursor.getColumnIndex(KEY_TASKID));
                taskLabelId.labelid = cursor.getInt(cursor.getColumnIndex(KEY_LABELID));

                taskLabelIdList.add(taskLabelId);

            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get posts from database");
        }
        Log.d(TAG, "getAllTaskLabelId: "+taskLabelIdList);
        return taskLabelIdList;
    }

//---------------------------------------------------------------------------------------------------------------------------------------

    public void addTaskLabelid(TaskLabelId taskLabelId) {
        db = this.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(KEY_LABELID, taskLabelId.getLabelid());
            values.put(KEY_TASKID, taskLabelId.getTaskid());
            db.insertOrThrow(TABLE_TASKLABEL, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d("Exception", "" + e);

        } finally {
            db.endTransaction();
        }

    }

    public int updateTaskLabel(TaskLabelId taskLabelId) {
        db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_TASKID, taskLabelId.getTaskid());
        contentValues.put(KEY_LABELID, taskLabelId.getLabelid());

        int value = db.update(TABLE_TASKLABEL, contentValues, KEY_ID + " = ?", new String[]{String.valueOf(taskLabelId.id)});
        return value;

    }

    public ArrayList<Label> joinTaskLabel(int taskid) {
        db = getReadableDatabase();
        ArrayList<TaskLabelId> labels = new ArrayList<TaskLabelId>();
        ArrayList<Label> name = new ArrayList<>();
        String TODO_SELECTED_QUERY = " SELECT * FROM " + TABLE_TASKLABEL + " WHERE " + KEY_TASKID + "='" + taskid + "'";
        Log.d(TAG, " " + TODO_SELECTED_QUERY);
        db = getReadableDatabase();
        Cursor cursor = db.rawQuery(TODO_SELECTED_QUERY, null);
        try {
            Log.d(TAG, "joinTaskLabel: ........" + cursor.getCount());
            while (cursor.moveToNext()) {
                Label l = new Label();
                TaskLabelId taskLabelId = new TaskLabelId();
                taskLabelId.labelid = cursor.getInt(cursor.getColumnIndex(KEY_LABELID));

                l.labelname = labelJoin(taskLabelId.labelid);
                name.add(l);
                labels.add(taskLabelId);

            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get posts from database");
        } finally {
            cursor.close();
        }
        Log.d(TAG, "joinTaskLabel: Name Update" + name);

        return name;
    }

    public void deleteTaskLabelid(int Id) {
        db = getWritableDatabase();
        db.delete(TABLE_TASKLABEL, KEY_TASKID + " = ?", new String[]{String.valueOf((Id))});
        db.close();
    }



    public ArrayList<TaskLabelId> getAllTaskLabelId() {
        ArrayList<TaskLabelId> labels = new ArrayList<TaskLabelId>();
        String TODO_SELECTED_QUERY = " SELECT * FROM " + TABLE_TASKLABEL;
        db = getReadableDatabase();
        Cursor cursor = db.rawQuery(TODO_SELECTED_QUERY, null);
        try {
            while (cursor.moveToNext()) {
                TaskLabelId newTask = new TaskLabelId();

                newTask.labelid = cursor.getInt(cursor.getColumnIndex(KEY_LABELID));
                newTask.taskid = cursor.getInt(cursor.getColumnIndex(KEY_TASKID));
                labels.add(newTask);

            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get posts from database");
        }
        return labels;
    }

    public ArrayList<Integer> getAllTaskLabelLabelId()
    {
        ArrayList<Integer> labels = new ArrayList<Integer>();
        String TODO_SELECTED_QUERY = " SELECT * FROM " + TABLE_TASKLABEL;
        db = getReadableDatabase();
        Cursor cursor = db.rawQuery(TODO_SELECTED_QUERY, null);
        try {
            while (cursor.moveToNext()) {
                TaskLabelId newTask = new TaskLabelId();

                newTask.labelid = cursor.getInt(cursor.getColumnIndex(KEY_LABELID));
                labels.add(newTask.labelid);

            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get posts from database");
        }
        return labels;

    }
    public ArrayList<Integer> getAllLabelID()
    {
        ArrayList<Integer> labels = new ArrayList<Integer>();
        String TODO_SELECTED_QUERY = " SELECT * FROM " + TABLE_LABEL;
        db = getReadableDatabase();
        Cursor cursor = db.rawQuery(TODO_SELECTED_QUERY, null);
        try {
            while (cursor.moveToNext()) {
                Label newTask = new Label();

                newTask.labelId = cursor.getInt(cursor.getColumnIndex(KEY_LABELID));
                labels.add(newTask.labelId);
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get posts from database");
        }
        Log.d(TAG, "getAllLabelitem: " + labels);
        return labels;
    }
}

