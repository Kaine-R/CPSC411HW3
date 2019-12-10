package com.example.cpsc411hw3redo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cpsc411hw3redo.adapter.SummaryLVAdapter;
import com.example.cpsc411hw3redo.model.CourseEnrollment;
import com.example.cpsc411hw3redo.model.Student;
import com.example.cpsc411hw3redo.model.StudentDB;
import com.example.cpsc411hw3redo.StudentAddActivity;


import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    protected ListView mSummaryView;
    protected SummaryLVAdapter ad;

    StudentDB sDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sDB = new StudentDB(this);

        setContentView(R.layout.summary_listview);
        mSummaryView = findViewById(R.id.summary_list_view_id);
        ad = new SummaryLVAdapter();
        mSummaryView.setAdapter(ad);
    }

    protected void createStudentDB(){
        ArrayList<Student> studentList = new ArrayList<Student>();

        Student s = new Student("Kaine", "Rubalcava", "889587135");
        ArrayList<CourseEnrollment> courses = new ArrayList<CourseEnrollment>();
        courses.add(new CourseEnrollment("CPSC411", "A"));
        courses.add(new CourseEnrollment("CPSC349", "A"));
        s.setCourses(courses);
        studentList.add(s);

        s = new Student("Joe", "Mamma", "000000001");
        courses = new ArrayList<CourseEnrollment>();
        courses.add(new CourseEnrollment("CPSC411", "B"));
        courses.add(new CourseEnrollment("CPSC349", "B"));
        s.setCourses(courses);
        studentList.add(s);

        sDB.addStudents(studentList);
//        StudentDB.getInstance().setStudents(studentList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.summary_screen_menu, menu);
        menu.findItem(R.id.action_add).setVisible(true);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(this, StudentAddActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ad.notifyDataSetChanged();
    }
}
