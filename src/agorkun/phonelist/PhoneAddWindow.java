package agorkun.phonelist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

/**
 * Modal dialog for adding a phone entity.
 *
 * @author Alexander Gorkun.
 */
public class PhoneAddWindow extends JDialog{
    protected PhoneListWindow parent;
    protected JTextField nameField;
    protected JTextField lastnameField;
    protected JTextField phoneField;
    protected JButton addButton;
    private PhoneValidator validator;

    public PhoneAddWindow(PhoneListWindow phoneListWindow, PhoneValidator phoneValidator){
        super(phoneListWindow.getFrame(), "Add a phone entry", ModalityType.APPLICATION_MODAL);
        validator=phoneValidator;
        parent=phoneListWindow;
        prepareUI();
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

    protected void prepareUI(){
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

    public void open(){
        clearForm();
        setVisible(true);
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
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Phone phone=new Phone(nameField.getText(), lastnameField.getText(), phoneField.getText());
                Set<PhoneValidator.Errors> errors=validator.validate(phone);
                if(errors.isEmpty()){
                    parent.addPhone(phone);
                    dispose();
                }
                else{
                    if(errors.contains(PhoneValidator.Errors.NAME_EMPTY)){
                        nameField.setBorder(BorderFactory.createLineBorder(Color.RED, 2, true));
                    }
                    else{
                        nameField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                    }
                    if(errors.contains(PhoneValidator.Errors.LASTNAME_EMPTY)){
                        lastnameField.setBorder(BorderFactory.createLineBorder(Color.RED, 2, true));
                    }
                    else{
                        lastnameField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                    }
                    if(errors.contains(PhoneValidator.Errors.PHONE_EMPTY)){
                        phoneField.setBorder(BorderFactory.createLineBorder(Color.RED, 2, true));
                    }
                    else{
                        phoneField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                    }
                }
            }
        });
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

    public PhoneValidator getValidator() {
        return validator;
    }

    public void setValidator(PhoneValidator validator) {
        this.validator = validator;
    }
}
