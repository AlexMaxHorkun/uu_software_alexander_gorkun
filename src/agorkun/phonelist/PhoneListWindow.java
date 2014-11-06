package agorkun.phonelist;

import com.sun.javaws.exceptions.InvalidArgumentException;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.*;

/**
 * @author Alexander Gorkun
 */
public class PhoneListWindow {
    private JFrame mainFrame;
    private JLabel listsLabel;
    private JLabel binLabel;
    private JTable phoneListTable;
    private java.util.List<Phone> phoneList;
    private PhoneAddWindow phoneAddModal;

    public PhoneListWindow(java.util.List<Phone> phones){
        phoneList=phones;
        prepareMainWindow();
        prepareListsLabel();
        prepareBinLabel();
        preparePhoneList();
        prepareAddButton();
        preparePhoneAddModal();
    }

    public void start(){
        mainFrame.setVisible(true);
    }

    /**
     * Fetches main window, sets size, title etc.
     */
    protected void prepareMainWindow(){
        mainFrame=new JFrame("Alexander Gorkun's phone list");
        mainFrame.setSize(640, 240);
        mainFrame.setResizable(false);
        GridBagLayout layout=new GridBagLayout();
        mainFrame.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        mainFrame.setLayout(layout);
        mainFrame.setLocationRelativeTo(null);
    }

    protected void prepareListsLabel(){
        listsLabel=new JLabel("Phones list");
        GridBagConstraints c=new GridBagConstraints();
        c.weightx=1;
        c.weighty=0.5;
        c.fill=GridBagConstraints.HORIZONTAL;
        c.gridx=1;
        c.gridy=1;
        mainFrame.add(listsLabel, c);
    }

    protected void prepareBinLabel(){
        binLabel=new JLabel("Drag n Drop phones to trash can");
        GridBagConstraints c=new GridBagConstraints();
        c.weightx=0.5;
        c.weighty=0.5;
        c.fill=GridBagConstraints.HORIZONTAL;
        c.gridx=2;
        c.gridy=1;
        mainFrame.add(binLabel, c);
    }

    protected void preparePhoneList(){
        TableModel dataModel=new DefaultTableModel() {
            @Override
            public int getRowCount() {
                return phoneList.size();
            }

            @Override
            public int getColumnCount() {
                return 3;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Phone phone=phoneList.get(rowIndex);
                if(phone==null){
                    return null;
                }
                switch (columnIndex){
                    case 0:
                        return phone.getName();
                    case 1:
                        return phone.getLastname();
                    case 2:
                        return phone.getPhone();
                    default:
                        throw new RuntimeException("Wrong column index");
                }
            }

            @Override
            public String getColumnName(int ind){
                switch (ind){
                    case 0:
                        return "Name";
                    case 1:
                        return "Last Name";
                    case 2:
                        return "Phone";
                    default:
                        throw new RuntimeException();
                }
            }
        };
        phoneListTable=new JTable(dataModel);
        JScrollPane scrollPane=new JScrollPane(phoneListTable);
        GridBagConstraints c=new GridBagConstraints();
        c.weightx=1;
        c.weighty=1;
        c.fill=GridBagConstraints.BOTH;
        c.gridx=1;
        c.gridy=2;
        mainFrame.add(scrollPane,c);
        scrollPane.setPreferredSize(new Dimension(mainFrame.getWidth() / 4 * 3, mainFrame.getHeight() / 4 * 3));
    }

    protected void prepareAddButton(){
        JButton add=new JButton("Add");
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setEnabled(false);
                phoneAddModal.open();
            }
        });
        GridBagConstraints c=new GridBagConstraints();
        c.gridy=3;
        c.gridx=1;
        mainFrame.add(add, c);
    }

    protected void preparePhoneAddModal(){
        phoneAddModal=new PhoneAddWindow();
    }
}
