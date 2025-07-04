package Helper;

import Helper.DataSeeder.CustomerSeeder;
import Helper.DataSeeder.ProductSeeder;

public class Preparation {
    public static void prepare() {
        CustomerSeeder.seed();
        ProductSeeder.seed();
    }
}
