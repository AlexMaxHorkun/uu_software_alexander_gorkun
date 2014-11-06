import agorkun.phonelist.Phone;
import agorkun.phonelist.PhoneListWindow;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Phone> phones=new ArrayList<Phone>();
        phones.add(new Phone("Alexander", "Gorkun", "+380987654421"));
        phones.get(0).setId(1);
        PhoneListWindow app=new PhoneListWindow(phones);
        app.start();
    }
}
