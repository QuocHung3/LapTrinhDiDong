    package com.example.ltdd_gk;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class ListFragment extends Fragment {
    private ListView subject_lv;
    private ArrayList<Subject> arrSubject;
    private SubjectAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_list, container, false);

        subject_lv  = (ListView) v.findViewById(R.id.subject_lv);

        arrSubject =new ArrayList<>();

        arrSubject.add(new Subject(
                "Java",
                "Java là một ngôn ngữ lập trình hướng đối tượng, dựa trên lớp được thiết kế để có càng ít phụ thuộc thực thi càng tốt.",
                R.drawable.java_jsp));
        arrSubject.add(new Subject(
                "Python",
                "Python là một ngôn ngữ lập trình bậc cao cho các mục đích lập trình đa năng, do Guido van Rossum tạo ra và lần đầu ra mắt vào năm 1991. Python được thiết kế với ưu điểm mạnh là dễ đọc, dễ học và dễ nhớ.",
                R.drawable.python));
        arrSubject.add(new Subject(
                "PHP",
                "PHP: Hypertext Preprocessor, thường được viết tắt thành PHP là một ngôn ngữ lập trình kịch bản hay một loại mã lệnh chủ yếu được dùng để phát triển các ứng dụng viết cho máy chủ, mã nguồn mở, dùng cho mục đích tổng quát. Nó rất thích hợp với web và có thể dễ dàng nhúng vào trang HTML.",
                R.drawable.php));
        arrSubject.add(new Subject(
                "ReactJS",
                "React là một thư viện JavaScript front-end mã nguồn mở miễn phí để xây dựng giao diện người dùng dựa trên các thành phần UI. Nó được duy trì bởi Meta và một cộng đồng các nhà phát triển và công ty cá nhân.",
                R.drawable.reactjs_logo));
        arrSubject.add(new Subject(
                "HTML",
                "HTML là một ngôn ngữ đánh dấu được thiết kế ra để tạo nên các trang web trên World Wide Web. Nó có thể được trợ giúp bởi các công nghệ như CSS và các ngôn ngữ kịch bản giống như JavaScript.",
                R.drawable.html_5));

        adapter = new SubjectAdapter(getActivity(),R.layout.lv_item,arrSubject);
        subject_lv.setAdapter(adapter);

        subject_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(),DetailSubjectActivity.class);
                Bundle bundle = new  Bundle();
                bundle.putString("name",arrSubject.get(i).getName());
                bundle.putString("desc",arrSubject.get(i).getDesc());
                bundle.putInt("img",arrSubject.get(i).getImg());

                intent.putExtras(bundle);

                startActivity(intent);
            }
        });

        return v;
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//
//        arrSubject =new ArrayList<>();
//
//        arrSubject.add(new Subject(
//                "Java",
//                "Java là một ngôn ngữ lập trình hướng đối tượng, dựa trên lớp được thiết kế để có càng ít phụ thuộc thực thi càng tốt.",
//                R.drawable.java_jsp));
//        arrSubject.add(new Subject(
//                "Python",
//                "Python là một ngôn ngữ lập trình bậc cao cho các mục đích lập trình đa năng, do Guido van Rossum tạo ra và lần đầu ra mắt vào năm 1991. Python được thiết kế với ưu điểm mạnh là dễ đọc, dễ học và dễ nhớ.",
//                R.drawable.python));
//        arrSubject.add(new Subject(
//                "PHP",
//                "PHP: Hypertext Preprocessor, thường được viết tắt thành PHP là một ngôn ngữ lập trình kịch bản hay một loại mã lệnh chủ yếu được dùng để phát triển các ứng dụng viết cho máy chủ, mã nguồn mở, dùng cho mục đích tổng quát. Nó rất thích hợp với web và có thể dễ dàng nhúng vào trang HTML.",
//                R.drawable.php));
//        arrSubject.add(new Subject(
//                "ReactJS",
//                "React là một thư viện JavaScript front-end mã nguồn mở miễn phí để xây dựng giao diện người dùng dựa trên các thành phần UI. Nó được duy trì bởi Meta và một cộng đồng các nhà phát triển và công ty cá nhân.",
//                R.drawable.reactjs_logo));
//        arrSubject.add(new Subject(
//                "HTML",
//                "HTML là một ngôn ngữ đánh dấu được thiết kế ra để tạo nên các trang web trên World Wide Web. Nó có thể được trợ giúp bởi các công nghệ như CSS và các ngôn ngữ kịch bản giống như JavaScript.",
//                R.drawable.html_5));
//
//        adapter = new SubjectAdapter(getActivity(),R.layout.lv_item,arrSubject);
//        subject_lv.setAdapter(adapter);
//
//
//    }
//
}