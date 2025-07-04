package Helper.DataSeeder;

import Entities.Product;
import Helper.InMemoryDatabase;
import Helper.TableName;

import java.util.*;

public class ProductSeeder {

    public static void seed() {
        List<Product> products = InMemoryDatabase.getInstance().getTable(TableName.PRODUCTS);
        if (!products.isEmpty()) return;

        for (int i = 1; i <= 20; i++) {
            String baseName = "Product " + i;
            String name = baseName;
            String description = "Description for " + baseName;
            double price = getRandomDouble(100.0, 1000.0);
            int stockQuantity = getRandomInt(10, 100);
            double discount = getRandomDouble(0.0, 0.3);
            double weight = getRandomDouble(0.5, 5.0);

            Date expiredAt;
            boolean canBeShipped = true;

            if (i % 5 == 0) {
                expiredAt = getPastDate(getRandomInt(3, 10));
                name += " - Expired";
            } else {
                expiredAt = getFutureDate(getRandomInt(10, 30));
            }

            if (i % 4 == 0) {
                canBeShipped = false;
                name += " - Not Shippable";
            }

            Product product = new Product(
                    name,
                    description,
                    price,
                    stockQuantity,
                    expiredAt,
                    discount,
                    weight
            );

            product.setCanBeShipped(canBeShipped);

            products.add(product);
        }
    }

    private static double getRandomDouble(double min, double max) {
        return Math.round((Math.random() * (max - min) + min) * 100.0) / 100.0;
    }

    private static int getRandomInt(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }

    private static Date getFutureDate(int daysAhead) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, daysAhead);
        return calendar.getTime();
    }

    private static Date getPastDate(int daysAgo) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -daysAgo);
        return calendar.getTime();
    }
}
