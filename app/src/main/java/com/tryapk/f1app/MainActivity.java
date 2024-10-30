package com.tryapk.f1app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CategoryAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private CategoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Category> categories = createCategories();
        adapter = new CategoryAdapter(categories, this);
        recyclerView.setAdapter(adapter);
    }

    private List<Category> createCategories() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Cyber Security", "https://www.cybrary.it/", R.drawable.ic_security));
        categories.add(new Category("Android Development", "https://developer.android.com/courses", R.drawable.ic_android));
        categories.add(new Category("AI and ML", "https://www.coursera.org/learn/machine-learning", R.drawable.ic_ai));
        categories.add(new Category("Web Development", "https://www.freecodecamp.org/", R.drawable.ic_web));
        categories.add(new Category("DevOps", "https://www.edx.org/learn/devops", R.drawable.ic_devops));
        return categories;
    }

    @Override
    public void onItemClick(Category category) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(category.getUrl()));
        startActivity(intent);
    }
}