package agorkun.phonelist;

import javax.swing.*;
import java.awt.*;

public class PhoneAddWindow extends JFrame{
    private JLabel headerLabel;

    public PhoneAddWindow(){
        super();
        GridBagLayout layout=new GridBagLayout();
        setLayout(layout);
        setLocationRelativeTo(null);
        setSize(480, 320);
        setResizable(false);
        prepareHedaerLabel();
    }

    protected void prepareHedaerLabel(){
        headerLabel=new JLabel("Fill the form below to add a phone entry");
        GridBagConstraints c=new GridBagConstraints();
        c.gridx=1;
        c.gridy=1;
        add(headerLabel, c);
    }

    public void open(){
        if(!isVisible()){
            setVisible(true);
        }
    }
}
