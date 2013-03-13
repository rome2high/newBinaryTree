import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class LayoutPanel extends JPanel {

 /**
  * 
  */
 private static final long serialVersionUID = 1L;
 private JTextField inputField = new JTextField(10);
 private JButton clearButton = new JButton("clear");
 private JButton addButton = new JButton("addNode");
 private JLabel outputLabel = new JLabel("Message output will be displayed here");
 public TreePanel treePanel;

 public LayoutPanel(){
  setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
  JPanel upPanel = new JPanel();
  upPanel.setLayout(new BoxLayout(upPanel, BoxLayout.Y_AXIS));
  JLabel inputLabel = new JLabel("Input: ");
  JPanel inputPanel = new JPanel();
  inputPanel.add(inputLabel);
  inputPanel.add(inputField); 
  upPanel.add(inputPanel);
  JPanel buttonPanel = new JPanel();
  buttonPanel.add(clearButton);
  buttonPanel.add(addButton);
  upPanel.add(buttonPanel);
  JPanel outputPanel = new JPanel();
  outputPanel.add(outputLabel);
  upPanel.add(outputPanel);
  add(upPanel);
  treePanel = new TreePanel();
  add(treePanel);
  addButton.addActionListener(new AddBtnListener());
  addButton.setMnemonic(KeyEvent.VK_ENTER);
  clearButton.addActionListener(new ClearBtnListener());
 }
 
 private class AddBtnListener implements ActionListener{
  public void actionPerformed(ActionEvent e){
   String st = inputField.getText().trim();
   if(st.length() < 1){
    outputLabel.setText("The input is empty, please re-enter an integer.");
    inputField.requestFocus();
   }
   else{
    try{
     int value = Integer.parseInt(st);
     treePanel.insertNode(value);
     treePanel.repaint();
    }
    catch(NumberFormatException ex){
     outputLabel.setText("The input is not an integer, please re-enter an integer.");
    }
   }
   inputField.setText("");
   inputField.requestFocus();
  }
 }
 
 private class ClearBtnListener implements ActionListener{
  public void actionPerformed(ActionEvent e){
   inputField.setText("");
   outputLabel.setText("Cleared");
   treePanel.clear();
   treePanel.repaint();
   inputField.requestFocus();
  }
 }

}
