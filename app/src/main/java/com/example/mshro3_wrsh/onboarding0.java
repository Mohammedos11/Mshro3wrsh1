package com.example.mshro3_wrsh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class onboarding0 extends AppCompatActivity {

    ViewPager viewPager ;
    ArrayList<parrt_item> itemList;
    ViewPagerAdapter viewPagerAdapter;
    TextView textView ;
    Button button_next ;
     TabLayout tabLayout ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_onboarding0);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        itemList = new ArrayList<>();
        itemList.add(new parrt_item( ContextCompat.getDrawable(this, R.drawable.student),"we provide the best learning courses great mentors"));
        itemList.add(new parrt_item(ContextCompat.getDrawable(this, R.drawable.grad)," Learn anytime andanyweare easily and convenietly  "));
        itemList.add(new parrt_item(ContextCompat.getDrawable(this, R.drawable.graduate),"Let's improve your skills togather with Elera right now"));


        tabLayout=findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addTab(tabLayout.newTab().setText(""));
        tabLayout.addTab(tabLayout.newTab().setText(""));
        tabLayout.addTab(tabLayout.newTab().setText(""));
        viewPagerAdapter = new ViewPagerAdapter(this,itemList);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(viewPagerAdapter);
        button_next = findViewById(R.id.Next);
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // التنقل إلى العنصر التالي في ViewPager
                int currentItem = viewPager.getCurrentItem(); // الحصول على العنصر الحالي
                int nextItem = currentItem + 1; // العنصر التالي

                // إذا كان العنصر التالي أكبر من حجم القائمة، ارجع إلى أول عنصر
                if (nextItem >= itemList.size()) {
                    Intent intent = new Intent(onboarding0.this,first_screen.class);
                    startActivity(intent);
                }

                // الانتقال إلى العنصر التالي
                viewPager.setCurrentItem(nextItem, true);

                // تغيير لون النقطة النشطة في الـ TabLayout
                TabLayout.Tab tab = tabLayout.getTabAt(nextItem);
                if (tab != null) {
                    tab.select();
                }



            }
        });


        tabLayout.setTabMode(TabLayout.MODE_FIXED);


    }
}