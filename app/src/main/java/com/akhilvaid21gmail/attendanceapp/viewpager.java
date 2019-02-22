package com.akhilvaid21gmail.attendanceapp;
//viewpager
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Akhil on 27-Jun-18.
 */

public class viewpager extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpa);
        ViewPager vp = findViewById(R.id.viewPager);
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {


            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public Fragment getItem(int position) {

                switch (position) {
                    case '0':
                        return (new page1());

                    case '1':
                        return (new page2());

                    default:
                        return (new page1());

                }
            }
        });

    }

    public static class page1 extends Fragment {

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.activity_display, container, false);

        }
    }

    public static class page2 extends Fragment {

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.activity_main, container, false);


        }

    }
}