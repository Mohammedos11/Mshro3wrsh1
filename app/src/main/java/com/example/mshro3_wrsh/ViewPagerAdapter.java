package com.example.mshro3_wrsh;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<parrt_item> itemList;

    public ViewPagerAdapter(Context context, ArrayList<parrt_item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view = LayoutInflater.from(context).inflate(R.layout.parrt_item, container, false);

        ImageView imageView = view.findViewById(R.id.image_item);
        TextView textView = view.findViewById(R.id.textt);


        parrt_item item = itemList.get(position);
        imageView.setImageDrawable(item.getImage());
        textView.setText(item.getText());

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return "Tab " + (position + 1);
    }
}