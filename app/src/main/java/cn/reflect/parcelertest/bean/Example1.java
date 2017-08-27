package cn.reflect.parcelertest.bean;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

/**
 * Created by BG241996 on 2017/8/27.
 */
@Parcel
public class Example1 {
    public Item item;

    @ParcelConstructor
    public Example1(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Example1{" +
                "item=" + item +
                '}';
    }
}
