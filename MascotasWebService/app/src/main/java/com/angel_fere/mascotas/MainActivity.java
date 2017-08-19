package com.angel_fere.mascotas;


import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tab;
    private ViewPager pager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tab = (TabLayout) findViewById(R.id.tab);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        pager = (ViewPager) findViewById(R.id.pager);

        setUpViewpager();



       }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;

        switch (item.getItemId()){
            case R.id.estrella:
                intent = new Intent(this, Mascotas_favoritas.class);
                startActivity(intent);
                break;
            case R.id.mAbout:
                intent = new Intent(this,acerca.class);
                startActivity(intent);
                break;
            case R.id.mContacto:
                intent = new Intent(this,contacto.class);
                startActivity(intent);
                break;
            case R.id.mConfigurar_cuenta:
                intent = new Intent(this,configurar_cuenta.class);
                startActivity(intent);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> fragmentos(){
        ArrayList<Fragment> f = new ArrayList<>();

        f.add(new RecyclerViewFragment());
        f.add(new Fragmento());
        return  f;

    }

    private void setUpViewpager(){
        pager.setAdapter(new PageAdapter(getSupportFragmentManager(),fragmentos()));
        tab.setupWithViewPager(pager);
        tab.getTabAt(0).setIcon(R.drawable.icons8_home_50);
        tab.getTabAt(1).setIcon(R.drawable.icons8_dog_50);
    }


}
