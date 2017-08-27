package cn.reflect.parcelertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.parceler.Parcels;

import cn.reflect.parcelertest.bean.Example1;
import timber.log.Timber;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // testPolymorphism
        Example1 example1 = Parcels.unwrap(getIntent().getParcelableExtra("example"));
        Timber.e("after unwrap %s", example1.toString());

        // testCustomSerialization
//        Example2 example2 = Parcels.unwrap(getIntent().getParcelableExtra("example"));
//        Timber.e("after unwrap %s", example2.toString());
    }
}
