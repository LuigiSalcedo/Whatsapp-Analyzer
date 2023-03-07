package app.windows;

import app.control.ChatData;
import app.elements.ChatDay;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Luigi Salcedo
 */
public class MainWindow extends javax.swing.JFrame 
{    
    public MainWindow() 
    {
        initComponents();
        loadComboBoxElements();
        loadSettings();
    }
    
    private void loadComboBoxElements()
    {   
        for(ChatDay day : ChatData.chatDays)
        {
            daySelectionerBox.addItem(day.toString());
        }
    }
    
    private void loadSettings()
    {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        addWindowListener(new WindowAdapter()
                {
                    @Override
                    public void windowClosing(WindowEvent e)
                    {
                        FileSelection.fs.setVisible(true);
                    }
                });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        daySelectionerBox = new javax.swing.JComboBox<>();
        scrollTextArea = new javax.swing.JScrollPane();
        chatTextArea = new javax.swing.JTextArea();
        showMessagesButton = new javax.swing.JButton();
        scrollSearchDayTextArea = new javax.swing.JScrollPane();
        searchDayTextArea = new javax.swing.JTextPane();
        showChatStatsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chat");
        setBackground(new java.awt.Color(231, 255, 229));

        daySelectionerBox.setBackground(new java.awt.Color(231, 255, 229));
        daySelectionerBox.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        daySelectionerBox.setMaximumRowCount(20);
        daySelectionerBox.setToolTipText("");
        daySelectionerBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        daySelectionerBox.setFocusable(false);
        daySelectionerBox.setLightWeightPopupEnabled(false);
        daySelectionerBox.setRequestFocusEnabled(false);
        daySelectionerBox.setVerifyInputWhenFocusTarget(false);
        daySelectionerBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daySelectionerBoxActionPerformed(evt);
            }
        });

        scrollTextArea.setBackground(new java.awt.Color(0, 0, 0));
        scrollTextArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollTextArea.setFocusable(false);

        chatTextArea.setColumns(20);
        chatTextArea.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        chatTextArea.setRows(5);
        chatTextArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        chatTextArea.setFocusable(false);
        scrollTextArea.setViewportView(chatTextArea);

        showMessagesButton.setBackground(new java.awt.Color(231, 255, 229));
        showMessagesButton.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        showMessagesButton.setText("Select day");
        showMessagesButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        showMessagesButton.setFocusable(false);
        showMessagesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showMessagesButtonActionPerformed(evt);
            }
        });

        searchDayTextArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        searchDayTextArea.setFont(new java.awt.Font("Segoe UI Light", 0, 17)); // NOI18N
        scrollSearchDayTextArea.setViewportView(searchDayTextArea);

        showChatStatsButton.setBackground(new java.awt.Color(231, 255, 229));
        showChatStatsButton.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        showChatStatsButton.setText("Show chat stats");
        showChatStatsButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        showChatStatsButton.setFocusable(false);
        showChatStatsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showChatStatsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollTextArea)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(daySelectionerBox, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollSearchDayTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(showMessagesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 237, Short.MAX_VALUE)
                        .addComponent(showChatStatsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollSearchDayTextArea, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(daySelectionerBox)
                    .addComponent(showChatStatsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(showMessagesButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void daySelectionerBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daySelectionerBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_daySelectionerBoxActionPerformed

    private void showMessagesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showMessagesButtonActionPerformed
        String daySelectedDate;
        
        daySelectedDate = (String)daySelectionerBox.getSelectedItem();
        
        // Seleccionar el día escrito y convertirlo.
        if(!(searchDayTextArea.getText()).isEmpty())
        {
            daySelectedDate = searchDayTextArea.getText().trim();
            daySelectedDate = ChatDay.convertStringToDate(daySelectedDate);
        }
        
        // Si se escribió algo que no es un día
        if(daySelectedDate == null)
        {
            JOptionPane.showMessageDialog(null, "Please, enter the date in format dd/mm/yyyy.", "Date format error", JOptionPane.ERROR_MESSAGE);
            chatTextArea.setText("");
            return;
        }
        
        // Si no existe el día escrito
        if(!ChatData.chatDaysHash.containsKey(daySelectedDate))
        {
            JOptionPane.showMessageDialog(null, "There is not message on this day.", "Chat day not found", JOptionPane.INFORMATION_MESSAGE);
            chatTextArea.setText("");
            return;            
        }
        
        ChatDay daySelected = ChatData.chatDaysHash.get(daySelectedDate);
        
        // Borrar el día escrito
        searchDayTextArea.setText("");
        
        StringBuilder sb = new StringBuilder();
        
        for(String message : daySelected.getMessages())
        {
            sb.append(message).append("\n");
        }
        
        chatTextArea.setText(sb.toString());
        
    }//GEN-LAST:event_showMessagesButtonActionPerformed

    private void showChatStatsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showChatStatsButtonActionPerformed
        ChatStats cs = new ChatStats();
        
        cs.setVisible(true);
    }//GEN-LAST:event_showChatStatsButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea chatTextArea;
    private javax.swing.JComboBox<String> daySelectionerBox;
    private javax.swing.JScrollPane scrollSearchDayTextArea;
    private javax.swing.JScrollPane scrollTextArea;
    private javax.swing.JTextPane searchDayTextArea;
    private javax.swing.JButton showChatStatsButton;
    private javax.swing.JButton showMessagesButton;
    // End of variables declaration//GEN-END:variables
}
