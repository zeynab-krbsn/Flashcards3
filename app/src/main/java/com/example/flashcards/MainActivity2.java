package com.example.flashcards;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity2 extends AppCompatActivity {

    String[] child={"پودمان 1","پودمان 2","پودمان 3","پودمان 4","پودمان 5"};
//    String[] group_info = {"دانش فنی پایه", "نصب و راه اندازی سیستم های رایانه ای"};
    String[] group_info;
    List<String> groupList;
    List<String> childList;
    List<Integer> groupListIcon;
    Map<String, List<String>> collection;
    ExpandableListView expandableListView;
    MyExpandableListAdapter1 expandableListAdapter;
    String field=null, level=null;
    TextView textViewHeaderField,textViewHeaderLevel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textViewHeaderField=findViewById(R.id.textViewHeaderField);
        textViewHeaderLevel=findViewById(R.id.textViewHeaderLevel);
        Bundle bundle=getIntent().getExtras();
        if(bundle != null){
            field=bundle.get("field").toString();
            level=bundle.get("level").toString();
            textViewHeaderField.setText(field);
            textViewHeaderLevel.setText(level);

            if (field.equals("شبکه و نرم افزار") && level.equals("دهم")) {
                group_info = new String[]{"دانش فنی پایه", "نصب و راه اندازی سیستم های رایانه ای", "تولید محتوای الکترونیک و برنامه سازی", "نقشه کشی فنی رایانه ای"};
            } else if (field.equals("شبکه و نرم افزار") && level.equals("یازدهم")) {
                group_info = new String[]{"توسعه برنامه سازی و پایگاه داده", "پیاده سازی سیستم های اطلاعاتی و طراحی وب"};
            } else if (field.equals("شبکه و نرم افزار") && level.equals("دوازدهم")) {
                group_info = new String[]{"دانش فنی تخصصی", "نصب و نگهداری تجهیزات شبکه و سخت افزار", "تجارت الکترونیک و امنیت شبکه"};
            } else if (field.equals("حسابداری") && level.equals("دهم")) {
                group_info = new String[]{"ارتباط موثر", "دانش فنی پایه", "حسابداری وجوه نقد و تحریر دفاتر قانونی", "حسابداری خرید و فروش"};
            } else if (field.equals("حسابداری") && level.equals("یازدهم")) {
                group_info = new String[]{"حسابداری حقوق و دستمزد", "حسابداری اموال و انبار"};
            } else if (field.equals("حسابداری") && level.equals("دوازدهم")) {
                group_info = new String[]{"دانش فنی تخصصی", "حسابداری بهای تمام شده و مالیاتی", "حسابداری تهیه و تنظیم صورت های مالی"};
            } else if (field.equals("پویانمایی") && level.equals("دهم")) {
                group_info = new String[]{"دانش فنی پایه", "طراحی و زبان بصری", "متحرک سازی دوبعدی", "طراحی شخصیت در پویانمایی"};
            } else if (field.equals("پویانمایی") && level.equals("یازدهم")) {
                group_info = new String[]{"طراحی فضا و صحنه در پویانمایی", "تولید پویانمایی سه بعدی صحنه ای"};
            } else if (field.equals("پویانمایی") && level.equals("دوازدهم")) {
                group_info = new String[]{"دانش فنی تخصصی", "متحرک سازی رایانه ای", "ارزیابی تولید در پویا نمایی"};
            } else if (field.equals("فتو گرافیک") && level.equals("دهم")) {
                group_info = new String[]{"دانش فنی پایه", "طراحی و زبان بصری", "عکاسی پرسنلی و ویرایش حروف و تصویر", "تصویرسازی آموزشی و تایپوگرافی"};
            } else if (field.equals("فتو گرافیک") && level.equals("یازدهم")) {
                group_info = new String[]{"عکاسی آتلیه و مراسم", "طراحی نشانه، تصویرگری کتاب کودک و نظارت چاپ"};
            } else if (field.equals("فتو گرافیک") && level.equals("دوازدهم")) {
                group_info = new String[]{"دانش فنی تخصصی", "عکاسی طبیعت، مستند و گزارشی", "گرافیک نشر و مطبوعات"};
            } else if (field.equals("گرافیک") && level.equals("دهم")) {
                group_info = new String[]{"طراحی (1)", "خوشنویسی", "مبانی هنرهای تجسمی", "علم مناظر و مرایا", "عکاسی (1)", "تاریخ هنر ایران"};
            } else if (field.equals("گرافیک") && level.equals("یازدهم")) {
                group_info = new String[]{"عکاسی (2)", "کارگاه چاپ دستی (1)", "تاریخ هنر جهان", "طراحی (2)"};
            } else if (field.equals("گرافیک") && level.equals("دوازدهم")) {
                group_info = new String[]{"مبانی تصویرسازی", "پایه و اصول صفحه آرایی", "خط در گرافیک"};
            } else if (field.equals("نقاشی") && level.equals("دهم")) {
                group_info = new String[]{"طراحی (1)", "مبانی هنرهای تجسمی", "علم مناظر و مرایا", "عکاسی (1)", "تاریخ هنر ایران"};
            }
        }


        createGroupList();
        createCollection();

        expandableListView = findViewById(R.id.expandableListView2);
        expandableListAdapter = new MyExpandableListAdapter1(this, groupList, collection,groupListIcon);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int lastExpandedPosition = -1;

            @Override
            public void onGroupExpand(int i) {
                if (lastExpandedPosition != -1 && i != lastExpandedPosition) {
                    expandableListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = i;
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long id) {
                Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                intent.putExtra("lesson",groupList.get(groupPosition));
                intent.putExtra("podman",childList.get(childPosition));
                view.getContext().startActivity(intent);

                return true;
            }
        });

    }

    private void createCollection() {
//
//        String[] Accounting={"دهم","یازدهم","دوازدهم"};
//        String[] Computer={"پودمان 1","پودمان 2","پودمان 3","پودمان 4","پودمان 5"};
//
//
//        collection=new HashMap<String,List<String>>();
//        for (String group : groupList) {
//            if (group.equals("دانش فنی پایه")){
//                loadChild(Computer);
//            }
//            else if (group.equals("نصب و راه اندازی سیستم های رایانه ای")){
//                loadChild(Computer);
//            }
//            collection.put(group,childList);
//        }

        collection=new HashMap<String,List<String>>();
        loadChild(child);
        for (int i = 0; i< group_info.length ; i++) {
            collection.put(group_info[i],childList);
        }

    }

    private void loadChild(String[] Collection) {
        childList=new ArrayList<>();
        for (String filed: Collection) {
            childList.add(filed);
        }
    }

    private void createGroupList() {
//        groupList = new ArrayList<>();
//
//        groupList.add("دانش فنی پایه");
//        groupList.add("نصب و راه اندازی سیستم های رایانه ای");
////        groupList.add("تولید محتوای الکترونیک و برنامه سازی");
////        groupList.add("نقشه کشی فنی رایانه ای");
//        groupList.add("ارتباط موثر");
//        groupList.add("دانش فنی پایه");

        groupList = new ArrayList<>();
        for (String g: group_info)
            groupList.add(g);



    }
}