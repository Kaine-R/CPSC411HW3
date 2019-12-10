package com.example.cpsc411hw3redo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cpsc411hw3redo.R;
import com.example.cpsc411hw3redo.model.Student;
import com.example.cpsc411hw3redo.model.StudentDB;

public class SummaryLVAdapter extends BaseAdapter {

    @Override
    public int getCount() {
        return StudentDB.getPersonList().size();
    }
    @Override
    public Object getItem(int position) {
        return StudentDB.getPersonList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        final View row_view;

        if(view == null) {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            row_view = inflater.inflate(R.layout.person_row, viewGroup, false);
        }else row_view = view;

        //
        Student p = StudentDB.getPersonList().get(i);
        //
        ((TextView) row_view.findViewById(R.id.first_name_id)).setText(p.getFirstName());
        ((TextView) row_view.findViewById(R.id.last_name_id)).setText(p.getLastName());
        ((TextView) row_view.findViewById(R.id.CWID)).setText(p.getCWID());

        return row_view;
    }
}
