package com.example.recycleview_hv.Category;

import com.example.recycleview_hv.Subject;

import java.util.List;

public class Category {
    private String nameCategory;
    private List<Subject> subjects;

    public Category(String nameCategory, List<Subject> subjects) {
        this.nameCategory = nameCategory;
        this.subjects = subjects;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
