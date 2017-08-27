package cn.reflect.parcelertest.bean;

import org.parceler.Parcel;
import org.parceler.ParcelPropertyConverter;
import org.parceler.Parcels;
import org.parceler.converter.ArrayListParcelConverter;

import java.util.List;

/**
 * Created by BG241996 on 2017/8/27.
 */
@Parcel
public class Example2 {
    @ParcelPropertyConverter(ItemListParcelConverter.class)
    public List<Item> itemList;

    @Override
    public String toString() {
        return "Example2{" +
                "itemList=" + itemList +
                '}';
    }

    public static class ItemListParcelConverter extends ArrayListParcelConverter<Item> {
        @Override
        public void itemToParcel(Item input, android.os.Parcel parcel) {
            parcel.writeParcelable(Parcels.wrap(input), 0);
        }

        @Override
        public Item itemFromParcel(android.os.Parcel parcel) {
            return Parcels.unwrap(parcel.readParcelable(Item.class.getClassLoader()));
        }
    }
}
