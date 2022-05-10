package com.example.team1_project2;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DaysAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<DayItem> dayItems;
    private int mDaySelected;

    public DaysAdapter(Context context, ArrayList<DayItem> dayItems) {
        mContext = context;
        this.dayItems = dayItems;
    }

    @Override
    public int getCount() {
        return dayItems.size();
    }

    @Override
    public Object getItem(int position) {
        return dayItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // 항목 뷰를 정의한 xml 리소스(여기서는 mResource 값)으로부터 항목 뷰 객체를 메모리로 로드
            convertView = inflater.inflate(R.layout.day_item, parent, false);
        }
        convertView.setBackgroundColor(Color.WHITE);

        TextView dayText = convertView.findViewById(R.id.day);
        int day = dayItems.get(position).getDay();
        if (day !=0) {
            dayText.setText(day + "");
            if (day == mDaySelected) {
                convertView.setBackgroundColor(Color.CYAN);
            } else {
                convertView.setBackgroundColor(Color.WHITE);
            }
        } else {
            dayText.setText("");
            convertView.setEnabled(false);
        }

        convertView.setLayoutParams(new ViewGroup.LayoutParams(parent.getWidth()/7-1, parent.getHeight()/6-1));

        return convertView;
    }

    public void setDaySelected(int day) {
        mDaySelected = day;
    }
}
