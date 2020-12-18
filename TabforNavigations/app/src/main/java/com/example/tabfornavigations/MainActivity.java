package com.example.tabfornavigations;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
  private ViewPager vp;
  private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp =findViewById(R.id.viewpager);
        tabLayout=findViewById(R.id.tabLayout);
        ViewPagerAdapter vpa=new ViewPagerAdapter(getSupportFragmentManager());
        tabLayout.setupWithViewPager(vp);
        vp.setAdapter(vpa);
    }
    class ViewPagerAdapter extends FragmentStatePagerAdapter {
        public ViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {//based on the position we will get the fragment.
            switch (position){j j
                case 0:return  new RedFragment();
                case 1:return new BlueFragment();
                case 2:return new GreenFragment();
            }

            return null;
        }

        @Override
        public int getCount() {//display total number of fragments on the viewpager
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:return "RED";
                case 1:return "blue";
                case 2:return "green";

            }
            return super.getPageTitle(position);
        }
    }
}