package com.example.recycleview_hv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recycleview_hv.Category.Category;
import com.example.recycleview_hv.Category.CategoryAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
     private RecyclerView rvCategory;
    private CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory= findViewById(R.id.rv_category);
        categoryAdapter =new CategoryAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rvCategory.setLayoutManager(linearLayoutManager);

        categoryAdapter.setData(getListCategory());

        rvCategory.setAdapter(categoryAdapter);
    }

    private List<Category> getListCategory() {
        List<Category> listCategory = new ArrayList<>();

        List<Subject> listSubject = new ArrayList<>();
        listSubject.add(new Subject(R.drawable.html,"Subject 1"));
        listSubject.add(new Subject(R.drawable.jsp,"Subject 2"));
        listSubject.add(new Subject(R.drawable.php,"Subject 3"));
        listSubject.add(new Subject(R.drawable.python,"Subject 4"));
        listSubject.add(new Subject(R.drawable.reactjs_logo,"Subject 5"));
        listSubject.add(new Subject(R.drawable.html,"Subject 1"));
        listSubject.add(new Subject(R.drawable.jsp,"Subject 2"));
        listSubject.add(new Subject(R.drawable.php,"Subject 3"));
        listSubject.add(new Subject(R.drawable.python,"Subject 4"));
        listSubject.add(new Subject(R.drawable.reactjs_logo,"Subject 5"));
        listSubject.add(new Subject(R.drawable.html,"Subject 1"));
        listSubject.add(new Subject(R.drawable.jsp,"Subject 2"));
        listSubject.add(new Subject(R.drawable.php,"Subject 3"));
        listSubject.add(new Subject(R.drawable.python,"Subject 4"));
        listSubject.add(new Subject(R.drawable.reactjs_logo,"Subject 5"));

        listCategory.add(new Category("Category 1",listSubject));
        listCategory.add(new Category("Category 2",listSubject));
        listCategory.add(new Category("Category 3",listSubject));
        listCategory.add(new Category("Category 4",listSubject));

        return listCategory;
    }
 }