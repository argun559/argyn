package utils;

import model.VehicleBase;

import java.util.ArrayList;
import java.util.List;

public class SortingUtils {

    public static void sortByRentalPriceForDays(List<? extends VehicleBase> list, int days) {
        list.sort((a, b) -> Double.compare(a.calculateRentalPrice(days), b.calculateRentalPrice(days)));
    }

    public static List<VehicleBase> filterAvailable(List<VehicleBase> list) {
        List<VehicleBase> res = new ArrayList<>();
        for (VehicleBase v : list) {
            if (v.isAvailable()) {
                res.add(v);
            }
        }
        return res;
    }
}
