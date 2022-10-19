package com.example.flashcards;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class MyExpandableListAdapter1 extends BaseExpandableListAdapter {

    private Context context;
    private Map<String, List<String>> collection;
    private List<String> groupList;

    public MyExpandableListAdapter1(Context context, List<String> groupList, Map<String, List<String>> collection) {
        this.context=context;
        this.collection=collection;
        this.groupList=groupList;
    }

    @Override
    public int getGroupCount() {
        return collection.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return collection.get(groupList.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return groupList.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return collection.get(groupList.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String name=getGroup(i).toString();
        if (view==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.group_item1, null);

        }
        TextView item = view.findViewById(R.id.textViewField);
        item.setTypeface(null, Typeface.BOLD);
        item.setText(name);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
//        String field=collection.get(groupList.get(i)).get(i1);
        String field=getChild(i,i1).toString();
        if (view==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.child_item1, null);
        }
        TextView textViewLevel=view.findViewById(R.id.textViewLevel);
        textViewLevel.setText(field);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
