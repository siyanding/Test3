package com.example.test2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bmob.initialize(this, "b2ab2a965d7a4ea905eeba56d4a2fa4d");

//        Person p2 = new Person();
//
//        p2.setName("lucky");
//        p2.setAddress("北京海淀");
//        p2.save(new SaveListener<String>() {
//            @Override
//            public void done(String objectId,BmobException e) {
//                Toast toast = Toast.makeText(getApplicationContext(),"yes",Toast.LENGTH_LONG);
//                Toast toast1 = Toast.makeText(getApplicationContext(),"fuck",Toast.LENGTH_LONG);
//
//                if(e==null){
//
//                    toast.show();
//                }else{
//                    toast1.show();
//                }
//            }
//        });
    }

    public void onClick_Event(View view) {
        final TextView textview = (TextView)findViewById(R.id.textView1);

        EditText editTextUser =(EditText)findViewById(R.id.username_edit);
        final String username = editTextUser.getText().toString();

        EditText editTextPass =(EditText)findViewById(R.id.password_edit);
        final String password = editTextPass.getText().toString();

        BmobQuery<Person> query = new BmobQuery<Person>();

        query.addWhereEqualTo("username", username);
        //返回50条数据，如果不加上这条语句，默认返回10条数据
//        query.setLimit(50);
        //执行查询方法
        query.findObjects(new FindListener<Person>() {
            @Override
            public void done(List<Person> object, BmobException e) {
                if(e==null){
//                    toast("查询成功：共"+object.size()+"条数据。");
                    for (Person person : object) {
                        //获得playerName的信息
                    String userBack = person.getUsername();
                    //获得数据的objectId信息
                    String passBack = person.getPassword();
                    //获得createdAt数据创建时间（注意是：createdAt，不是createAt）
                    if(password.equals(passBack)){
                        Intent intent = new Intent(MainActivity.this, IndexActivity.class);
//                        Intent intent = new Intent();
//                        intent.putExtra("name", name.getText().toString());//添加一些内容，传给Display
//                        intent.setClass(v.getContext(), Display.class);//指明要跳转的Activity类
                        startActivity(intent);
                    }else {
                        textview.setText("Username or password wrong!");
                    }
                    }
                }else{
                    textview.setText("Username or password wrong!");
                    Log.i("bmob","失败："+e.getMessage()+","+e.getErrorCode());
                }
            }
        });

//        query.getObject(username, new QueryListener<Person>() {
//
//            @Override
//            public void done(Person object, BmobException e) {
//                if(e==null){
//                    //获得playerName的信息
//                    String userBack = object.getUsername();
//                    //获得数据的objectId信息
//                    String passBack = object.getPassword();
//                    //获得createdAt数据创建时间（注意是：createdAt，不是createAt）
//                    if(password.equals(passBack)){
//                        Intent intent = new Intent(MainActivity.this, IndexActivity.class);
////                        Intent intent = new Intent();
////                        intent.putExtra("name", name.getText().toString());//添加一些内容，传给Display
////                        intent.setClass(v.getContext(), Display.class);//指明要跳转的Activity类
//                        startActivity(intent);
//                    }else {
//                        textview.setText("Username or password wrong!");
//                    }
//                }else{
//                    textview.setText("Username or password wrong!");
//                    Log.i("bmob","failedLogin："+e.getMessage()+","+e.getErrorCode());
//                }
//            }
//
//        });
    }
}
