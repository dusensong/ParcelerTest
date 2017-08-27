package cn.reflect.parcelertest.bean;

import org.parceler.Parcel;

/**
 * Created by BG241996 on 2017/8/27.
 */
@Parcel
public class SubItem1 extends Item {
    @Override
    public String toString() {
        return "SubItem1{}";
    }
}
