package agorkun.phonelist;

import javax.swing.*;
import java.awt.*;

public class PhoneAddWindow extends JDialog{
    protected PhoneListWindow parent;
    protected JTextField nameField;
    protected JTextField lastnameField;
    protected JTextField phoneField;
    protected JButton addButton;

    public PhoneAddWindow(PhoneListWindow phoneListWindow){
        super(phoneListWindow.getFrame(), "Add a phone entry", ModalityType.APPLICATION_MODAL);
        parent=phoneListWindow;
        GridBagLayout layout=new GridBagLayout();
        setLayout(layout);
        setLocationRelativeTo(null);
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        setSize(480, 320);
        setResizable(false);
        prepareHeaderLabel();
        prepareForm();
        prepareAddButton();
    }

    protected void prepareHeaderLabel(){
        JLabel headerLabel=new JLabel("Fill the form below to add a phone entry");
        GridBagConstraints c=new GridBagConstraints();
        c.gridx=1;
        c.gridy=1;
        c.gridwidth=2;
        c.ipadx=5;
        add(headerLabel, c);
    }

    public void open(){
        if(!isVisible()){
            clearForm();
            setVisible(true);
        }
    }

    private void prepareForm(){
        JLabel nameLabel=new JLabel("Enter name:");
        GridBagConstraints c=new GridBagConstraints();
        c.gridy=2;
        c.gridx=1;
        add(nameLabel, c);
        nameField=new JTextField(15);
        c=(GridBagConstraints)c.clone();
        c.gridx=2;
        c.gridy=2;
        c.gridwidth=1;
        c.gridheight=1;
        add(nameField, c);
        lastnameField=new JTextField(15);
        c=(GridBagConstraints)c.clone();
        c.gridx=2;
        c.gridy=3;
        c.gridwidth=1;
        c.gridheight=1;
        add(lastnameField, c);
        phoneField=new JTextField(15);
        c=(GridBagConstraints)c.clone();
        c.gridx=2;
        c.gridy=4;
        c.gridwidth=1;
        c.gridheight=1;
        add(phoneField, c);
        JLabel lastnameLabel=new JLabel("Enter last name: ");
        c=(GridBagConstraints)c.clone();
        c.gridx=1;
        c.gridy=3;
        c.gridwidth=1;
        c.gridheight=1;
        add(lastnameLabel, c);
        JLabel phoneLabel=new JLabel("Enter phone: ");
        c=(GridBagConstraints)c.clone();
        c.gridx=1;
        c.gridy=4;
        c.gridwidth=1;
        c.gridheight=1;
        add(phoneLabel, c);
    }

    private void prepareAddButton(){
        addButton=new JButton("Add");
        GridBagConstraints c=new GridBagConstraints();
        c.gridx=1;
        c.gridwidth=2;
        c.gridy=5;
        add(addButton, c);
    }

    public void clearForm(){
        nameField.setText("");
        lastnameField.setText("");
        phoneField.setText("");
    }
}
