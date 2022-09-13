package com.example.flashcards;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    String[] child={"دهم","یازدهم","دوازدهم"};
    String[] child2={"دهم"};
    String[] group_info = {"شبکه و نرم افزار", "حسابداری","پویانمایی","فتو گرافیک","گرافیک","نقاشی"};
    List<String> groupList;
    List<String> childList;
    Map<String, List<String>> collection;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createGroupList();
        createCollection();

        expandableListView = findViewById(R.id.expandableListView1);
        expandableListAdapter = new MyExpandableListAdapter1(this, groupList, collection);
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

                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                intent.putExtra("field",groupList.get(groupPosition));
                intent.putExtra("level",childList.get(childPosition));
                view.getContext().startActivity(intent);

                return true;
            }
        });
    }

    private void createCollection() {
        collection=new HashMap<String,List<String>>();
        loadChild(child);
        for (int i = 0; i< group_info.length ; i++) {
            collection.put(group_info[i],childList);
        }

//        collection=new HashMap<String,List<String>>();
//        for (String group : groupList) {
//            if (group.equals("نقاشی")){
//                loadChild(child2);
//            }
//            else {
//                loadChild(child);
//            }
//            collection.put(group,childList);
//        }
    }

    private void loadChild(String[] Collection) {
        childList=new ArrayList<>();
        for (String filed: Collection) {
            childList.add(filed);
        }
    }

    private void createGroupList() {
        groupList = new ArrayList<>();
        for (String g: group_info)
            groupList.add(g);
    }
}









