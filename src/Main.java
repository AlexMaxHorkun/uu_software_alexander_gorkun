import agorkun.phonelist.Phone;
import agorkun.phonelist.PhoneListWindow;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Phone> phones=new ArrayList<Phone>();
        phones.add(new Phone(1, "Alexander", "Gorkun", "+380987654421"));
        PhoneListWindow app=new PhoneListWindow(phones);
        app.start();
    }
}
