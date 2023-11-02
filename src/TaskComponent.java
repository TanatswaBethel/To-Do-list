import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import static java.awt.Font.createFont;

public class TaskComponent extends JPanel implements ActionListener {
    private JCheckBox checkBox;
    private JTextPane taskField;
    private JButton deleteButton;

    public JTextPane getTaskField() {
        return taskField;
    }

    //this panel is used so that we can have updates to the task component panel when deleting tasks
    private JPanel parentPanel;

    public TaskComponent(JPanel parentPanel){
        this.parentPanel = parentPanel;

        //task field
        taskField = new JTextPane();
        taskField.setPreferredSize(CommonConstants.TASKFIELD_SIZE);
        taskField.setBorder(BorderFactory.createLineBorder(CommonConstants.BACKGROUND_COLOR));
        taskField.setContentType("text/html");
        taskField.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        taskField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                //indicates the task fieldwhich is currently being edited.
                taskField.setBackground(Color.WHITE);
            }

            @Override
            public void focusLost(FocusEvent e) {
                taskField.setBackground(null);

            }
        });

        //checkbox
        checkBox = new JCheckBox();
        checkBox.setBorder(BorderFactory.createLineBorder(CommonConstants.BACKGROUND_COLOR));
        checkBox.setPreferredSize(CommonConstants.CHECKBOX_SIZE);
        checkBox.setForeground(Color.WHITE);
        checkBox.addActionListener(this);
        checkBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        //delete button
        deleteButton = new JButton("x");
        deleteButton.setBackground(CommonConstants.SECONDARY_COLOR);
        deleteButton.setForeground(CommonConstants.BACKGROUND_COLOR);
        deleteButton.setBorder(BorderFactory.createLineBorder(CommonConstants.BACKGROUND_COLOR));
        setBorder(BorderFactory.createLineBorder(CommonConstants.BACKGROUND_COLOR));
        deleteButton.setPreferredSize(CommonConstants.DELETE_BUTTON_SIZE);
        deleteButton.addActionListener(this);
        deleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));




        //add to this taskcomponents
        add(checkBox);
        add(taskField);
        add(deleteButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (checkBox.isSelected()) {
            //replace all html tags with empty string to get the main text.
            String taskText = taskField.getText().replaceAll("<[^>]*>", "");

            // add strikethrough text
            taskField.setText("<html><s>"+ taskText + "</s></html>");
        }else if(!checkBox.isSelected()){
            String taskText = taskField.getText().replaceAll("<[^>]*>", "");

            taskField.setText(taskText);
        }
        if(e.getActionCommand().equalsIgnoreCase("X")){
            // delete this component from the parent panel
           //
            parentPanel.remove(this);
            parentPanel.repaint();
            parentPanel.revalidate();
        }

    }
}
