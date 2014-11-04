package agorkun.phonelist;

import com.sun.javaws.exceptions.InvalidArgumentException;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.List;
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

    public PhoneListWindow(java.util.List<Phone> phones){
        phoneList=phones;
    }

    public void start(){
        if(!(mainFrame==null)){
            throw new RuntimeException("Already started");
        }
        prepareMainWindow();
        prepareListsLabel();
        prepareBinLabel();
        preparePhoneList();
        mainFrame.setVisible(true);
    }

    /**
     * Fetches main window, sets size, title etc.
     */
    protected void prepareMainWindow(){
        mainFrame=new JFrame("Alexander Gorkun's phone list");
        mainFrame.setSize(640, 240);
        mainFrame.setResizable(false);
        mainFrame.setLayout(new GridLayout(2, 2));
    }

    protected void prepareListsLabel(){
        listsLabel=new JLabel("Phones list");
        mainFrame.add(listsLabel);
    }

    protected void prepareBinLabel(){
        binLabel=new JLabel("Drag n Drop phones to trash can");
        mainFrame.add(binLabel);
    }

    protected void preparePhoneList(){
        TableModel dataModel=new AbstractTableModel() {
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
        };
        phoneListTable=new JTable(dataModel);
        JScrollPane scrollPane=new JScrollPane(phoneListTable);
        mainFrame.add(scrollPane);
    }
}
