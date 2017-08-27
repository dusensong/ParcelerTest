package cn.reflect.parcelertest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import cn.reflect.parcelertest.bean.Example1;
import cn.reflect.parcelertest.bean.Example2;
import cn.reflect.parcelertest.bean.Item;
import cn.reflect.parcelertest.bean.SubItem1;
import cn.reflect.parcelertest.bean.SubItem2;
import timber.log.Timber;

public class FirstActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Timber.plant(new Timber.DebugTree());

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        testPolymorphism();
//        testCustomSerialization();
            }
        });


    }

    /**
     * 测试Parceler多态处理机制
     */
    private void testPolymorphism() {
        Intent intent = new Intent(FirstActivity.this, SecondActivity.class);

        Example1 example1 = new Example1(new SubItem1());
        Timber.e("before wrap %s", example1.toString());
        intent.putExtra("example", Parcels.wrap(example1));

        startActivity(intent);
    }

    /**
     * 通过Custom serialization处理多态问题
     */
    private void testCustomSerialization() {
        Intent intent = new Intent(FirstActivity.this, SecondActivity.class);

        Example2 example2 = new Example2();
        List<Item> items = new ArrayList<>();
        items.add(new SubItem1());
        items.add(new SubItem2());
        example2.itemList = items;
        Timber.e("before wrap %s", example2);
        intent.putExtra("example", Parcels.wrap(example2));

        startActivity(intent);
    }
}
