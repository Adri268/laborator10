import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SwingControlDemo {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public SwingControlDemo(){
        prepareGUI();
    }
    public static void main(String[] args){
        SwingControlDemo swingControlDemo = new SwingControlDemo();
        swingControlDemo.showEventDemo();
    }
    private void prepareGUI(){
        mainFrame = new JFrame("Java SWING Examples");
        mainFrame.setSize(400,400);
        mainFrame.setLayout(new GridLayout(3, 1));

        headerLabel = new JLabel("",JLabel.CENTER );
        statusLabel = new JLabel("",JLabel.CENTER);
        statusLabel.setSize(350,100);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }
    private void showEventDemo(){
        headerLabel.setText("Control in action: Button");

        JButton okButton3 = new JButton("OK");
        JButton submitButton = new JButton("Submit");
        JButton cancelButton3 = new JButton("Cancel");
        JButton chooseButton = new JButton("Choose Background");

        chooseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color backgroundColor = JColorChooser.showDialog(mainFrame,
                        "Choose background color", Color.white);
                if(backgroundColor != null){
                    controlPanel.setBackground(backgroundColor);
                    mainFrame.getContentPane().setBackground(backgroundColor);
                }
            }
        });
        final JCheckBox chkApple = new JCheckBox("Apple");
        final JCheckBox chkMango = new JCheckBox("Mango");
        final JCheckBox chkPeer = new JCheckBox("Peer");

        chkApple.setMnemonic(KeyEvent.VK_C);
        chkMango.setMnemonic(KeyEvent.VK_M);
        chkPeer.setMnemonic(KeyEvent.VK_P);

        chkApple.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                statusLabel.setText("Apple Checkbox: "
                        + (e.getStateChange()==1?"checked":"unchecked"));
            }
        });
        chkMango.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                statusLabel.setText("Mango Checkbox: "
                        + (e.getStateChange()==1?"checked":"unchecked"));
            }
        });
        chkPeer.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                statusLabel.setText("Peer Checkbox: "
                        + (e.getStateChange()==1?"checked":"unchecked"));
            }
        });
        controlPanel.add(chkApple);
        controlPanel.add(chkMango);
        controlPanel.add(chkPeer);

        final JRadioButton radApple = new JRadioButton("Apple", true);
        final JRadioButton radMango = new JRadioButton("Mango");
        final JRadioButton radPeer = new JRadioButton("Peer");

        radApple.setMnemonic(KeyEvent.VK_C);
        radMango.setMnemonic(KeyEvent.VK_M);
        radPeer.setMnemonic(KeyEvent.VK_P);

        radApple.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                statusLabel.setText("Apple RadioButton: "
                        + (e.getStateChange()==1?"checked":"unchecked"));
            }
        });
        radMango.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                statusLabel.setText("Mango RadioButton: "
                        + (e.getStateChange()==1?"checked":"unchecked"));
            }
        });
        radPeer.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                statusLabel.setText("Peer RadioButton: "
                        + (e.getStateChange()==1?"checked":"unchecked"));
            }
        });

        //Group the radio buttons.
        ButtonGroup group = new ButtonGroup();

        group.add(radApple);
        group.add(radMango);
        group.add(radPeer);

        controlPanel.add(radApple);
        controlPanel.add(radMango);
        controlPanel.add(radPeer);

        final DefaultListModel fruitsName1 = new DefaultListModel();

        fruitsName1.addElement("Apple");
        fruitsName1.addElement("Grapes");
        fruitsName1.addElement("Mango");
        fruitsName1.addElement("Peer");

        final JList fruitList = new JList(fruitsName1);
        fruitList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fruitList.setSelectedIndex(0);
        fruitList.setVisibleRowCount(3);

        JScrollPane fruitListScrollPane1 = new JScrollPane(fruitList);
        final DefaultListModel vegName = new DefaultListModel();

        vegName.addElement("Lady Finger");
        vegName.addElement("Onion");
        vegName.addElement("Potato");
        vegName.addElement("Tomato");

        final JList vegList = new JList(vegName);
        vegList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        vegList.setSelectedIndex(0);
        vegList.setVisibleRowCount(3);

        JScrollPane vegListScrollPane = new JScrollPane(vegList);
        JButton showButton1 = new JButton("Show");

        showButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "";
                if (fruitList.getSelectedIndex() != -1) {
                    data = "Fruits Selected: " + fruitList.getSelectedValue();
                    statusLabel.setText(data);
                }
                if(vegList.getSelectedIndex() != -1){
                    data += " Vegetables selected: ";
                    for(Object vegetable:vegList.getSelectedValues()){
                        data += vegetable + " ";
                    }
                }
                statusLabel.setText(data);
            }
        });
        controlPanel.add(fruitListScrollPane1);
        controlPanel.add(vegListScrollPane);
        controlPanel.add(showButton1);

        final DefaultComboBoxModel fruitsName = new DefaultComboBoxModel();

        fruitsName.addElement("Apple");
        fruitsName.addElement("Grapes");
        fruitsName.addElement("Mango");
        fruitsName.addElement("Peer");

        final JComboBox fruitCombo = new JComboBox(fruitsName);
        fruitCombo.setSelectedIndex(0);

        JScrollPane fruitListScrollPane = new JScrollPane(fruitCombo);
        JButton showButton2 = new JButton("Show");

        showButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "";
                if (fruitCombo.getSelectedIndex() != -1) {
                    data = "Fruits Selected: "
                            + fruitCombo.getItemAt
                            (fruitCombo.getSelectedIndex());
                }
                statusLabel.setText(data);
            }
        });
        controlPanel.add(fruitListScrollPane);
        controlPanel.add(showButton2);

        JLabel  namelabel1= new JLabel("User ID: ", JLabel.RIGHT);
        JLabel  passwordLabel1 = new JLabel("Password: ", JLabel.CENTER);
        final JTextField userText1 = new JTextField(6);
        final JPasswordField passwordText1 = new JPasswordField(6);

        JButton loginButton1 = new JButton("Login");
        loginButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "Username " + userText1.getText();
                data += ", Password: " + new String(passwordText1.getPassword());
                statusLabel.setText(data);
            }
        });
        controlPanel.add(namelabel1);
        controlPanel.add(userText1);
        controlPanel.add(passwordLabel1);
        controlPanel.add(passwordText1);
        controlPanel.add(loginButton1);

        JLabel namelabel= new JLabel("User ID: ", JLabel.RIGHT);
        JLabel passwordLabel = new JLabel("Password: ", JLabel.CENTER);
        final JTextField userText = new JTextField(6);
        final JPasswordField passwordText = new JPasswordField(6);
        passwordText.setEchoChar('~');

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "Username " + userText.getText();
                data += ", Password: " + new String(passwordText.getPassword());
                statusLabel.setText(data);
            }
        });
        controlPanel.add(namelabel);
        controlPanel.add(userText);
        controlPanel.add(passwordLabel);
        controlPanel.add(passwordText);
        controlPanel.add(loginButton);

        JLabel  commentlabel= new JLabel("Comments: ", JLabel.RIGHT);

        final JTextArea commentTextArea =
                new JTextArea("This is a Swing tutorial "
                        +"to make GUI application in Java.",5,20);

        JScrollPane scrollPane = new JScrollPane(commentTextArea);
        JButton showButton = new JButton("Show");

        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText( commentTextArea.getText());
            }
        });
        controlPanel.add(commentlabel);
        controlPanel.add(scrollPane);
        controlPanel.add(showButton);

        final JScrollBar horizontalScroller = new JScrollBar(JScrollBar.HORIZONTAL);
        final JScrollBar verticalScroller = new JScrollBar();
        verticalScroller.setOrientation(JScrollBar.VERTICAL);
        horizontalScroller.setMaximum (100);
        horizontalScroller.setMinimum (1);
        verticalScroller.setMaximum (100);
        verticalScroller.setMinimum (1);

        horizontalScroller.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                statusLabel.setText("Horozontal: "
                        +horizontalScroller.getValue()
                        +" ,Vertical: "
                        + verticalScroller.getValue());
            }
        });
        verticalScroller.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                statusLabel.setText("Horozontal: "
                        +horizontalScroller.getValue()
                        +" ,Vertical: "+ verticalScroller.getValue());
            }
        });
        controlPanel.add(horizontalScroller);
        controlPanel.add(verticalScroller);

        JButton okButton = new JButton("OK");
        JButton javaButton = new JButton("Yes/No");
        JButton cancelButton = new JButton("Yes/No/Cancel");

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(mainFrame, "Welcome to TutorialsPoint.com");
            }
        });
        javaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int output = JOptionPane.showConfirmDialog(mainFrame
                        , "Click any button"
                        ,"TutorialsPoint.com"
                        ,JOptionPane.YES_NO_OPTION);

                if(output == JOptionPane.YES_OPTION){
                    statusLabel.setText("Yes selected.");
                } else if(output == JOptionPane.NO_OPTION){
                    statusLabel.setText("No selected.");
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int output = JOptionPane.showConfirmDialog(mainFrame
                        , "Click any button"
                        ,"TutorialsPoint.com"
                        ,JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.INFORMATION_MESSAGE);

                if(output == JOptionPane.YES_OPTION){
                    statusLabel.setText("Yes selected.");
                } else if(output == JOptionPane.NO_OPTION){
                    statusLabel.setText("No selected.");
                } else if(output == JOptionPane.CANCEL_OPTION){
                    statusLabel.setText("Cancel selected.");
                }
            }
        });
        controlPanel.add(okButton);
        controlPanel.add(javaButton);
        controlPanel.add(cancelButton);

        final JFileChooser  fileDialog = new JFileChooser();
        JButton showFileDialogButton = new JButton("Open File");

        showFileDialogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnVal = fileDialog.showOpenDialog(mainFrame);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    java.io.File file = fileDialog.getSelectedFile();
                    statusLabel.setText("File Selected :" + file.getName());
                } else {
                    statusLabel.setText("Open command cancelled by user." );
                }
            }
        });
        controlPanel.add(showFileDialogButton);

        JSlider slider = new JSlider(JSlider.HORIZONTAL,0,100,10);

        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                statusLabel.setText("Value : " + ((JSlider)e.getSource()).getValue());
            }
        });
        controlPanel.add(slider);

        SpinnerModel spinnerModel = new SpinnerNumberModel(10, //initial value
                0, //min
                100, //max
                1);//step
        JSpinner spinner = new JSpinner(spinnerModel);
        spinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                statusLabel.setText("Value : " + ((JSpinner)e.getSource()).getValue());
            }
        });
        controlPanel.add(spinner);

        okButton.setActionCommand("OK");
        submitButton.setActionCommand("Submit");
        cancelButton.setActionCommand("Cancel");

        okButton.addActionListener(new ButtonClickListener());
        submitButton.addActionListener(new ButtonClickListener());
        cancelButton.addActionListener(new ButtonClickListener());

        controlPanel.add(okButton);
        controlPanel.add(submitButton);
        controlPanel.add(cancelButton);
        controlPanel.add(chooseButton);

        mainFrame.setVisible(true);
    }
    private class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if( command.equals( "OK" ))  {
                statusLabel.setText("Ok Button clicked.");
            } else if( command.equals( "Submit" ) )  {
                statusLabel.setText("Submit Button clicked.");
            } else {
                statusLabel.setText("Cancel Button clicked.");
            }
        }
    }
}