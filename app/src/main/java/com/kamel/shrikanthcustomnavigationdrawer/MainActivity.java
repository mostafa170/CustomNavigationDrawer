package com.kamel.shrikanthcustomnavigationdrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.shrikanthravi.customnavigationdrawer2.data.MenuItem;
import com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SNavigationDrawer sNavigationDrawer;
    public static Fragment fragment;
    Class fragmentClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sNavigationDrawer=findViewById(R.id.navigationDrawer);

        List<MenuItem> menuItems=new ArrayList<>();

        menuItems.add(new MenuItem("News",R.drawable.ic_baseline_filter_none_24));
        menuItems.add(new MenuItem("Feed",R.drawable.ic_baseline_feedback_24));
        menuItems.add(new MenuItem("Messages",R.drawable.ic_baseline_message_24));
        menuItems.add(new MenuItem("Music",R.drawable.ic_baseline_library_music_24));

        sNavigationDrawer.setMenuItemList(menuItems);

        fragmentClass=Newsfragment.class;

        try {
            fragment=(Fragment)fragmentClass.newInstance();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }catch (InstantiationException e){
            e.printStackTrace();
        }

        if (fragment!=null){
            FragmentManager fragmentManager=getSupportFragmentManager();
            fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in,
                    android.R.animator.fade_out).replace(R.id.frameLayout,fragment).commit();
        }






        sNavigationDrawer.setDrawerListener(new SNavigationDrawer.DrawerListener() {
            @Override
            public void onDrawerOpening() {

            }

            @Override
            public void onDrawerClosing() {
                try {
                    fragment=(Fragment)fragmentClass.newInstance();
                }catch (IllegalAccessException e){
                    e.printStackTrace();
                }catch (InstantiationException e){
                    e.printStackTrace();
                }
                if (fragment!=null){
                    FragmentManager fragmentManager=getSupportFragmentManager();
                    fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in,
                            android.R.animator.fade_out).replace(R.id.frameLayout,fragment).commit();
                }
            }

            @Override
            public void onDrawerOpened() {

            }

            @Override
            public void onDrawerClosed() {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }
}