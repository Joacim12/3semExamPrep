package model;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.Random;

/**
 *
 * @author joacim
 */
public class DataGenerator {

    private final Random random;
    private final String[] fname, lname, street, city;

    public DataGenerator() {
        this.fname = new String[]{"Lars", "Thomas", "Jens", "Joacim"};
        this.lname = new String[]{"Madsen", "Andersen", "Egebjerg", "Vetterlain"};
        this.street = new String[]{"Borups Allé", "Skt. Kjeldsgade", "Ribesvej", "Rørsangervej"};
        this.city = new String[]{"København", "København Ø", "Købehavn N", "København NV"};
        random = new Random();
    }

    public JsonArray getData(int amount, String data) {
        JsonArray names = new JsonArray();
        for (int i = 0; i < amount; i++) {
        JsonObject person = new JsonObject();
            if (data.contains("fname")) {
                person.addProperty("fName", fname[random.nextInt(fname.length)]);
            }
            if (data.contains("lname")) {
                person.addProperty("lName", lname[random.nextInt(lname.length)]);
            }
            if (data.contains("street")) {
                person.addProperty("street", street[random.nextInt(street.length)]);
            }
            if (data.contains("city")) {
                person.addProperty("city", city[random.nextInt(city.length)]);
            }
            names.add(person);
        }
        return names;

    }

}
