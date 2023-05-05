package app.windows;

import org.jfree.data.category.DefaultCategoryDataset;
import app.control.ChatData;
import app.elements.ChatDay;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Luigi Salcedo
 */
public class ChatStats extends javax.swing.JFrame 
{
    private BufferedImage comparationImage;
    private BufferedImage pieImage;
    
    public ChatStats() 
    {      
        loadMessagesComparationImage(); // Cargar la imagen de los chats
        loadPieComparation(); // Cargar gráfica de pastel
        
        initComponents();
        
        this.setSize(new Dimension(900, 900));
        
        pack();
        repaint();
    }
    
    private void loadPieComparation()
    {
        DefaultPieDataset data = new DefaultPieDataset();
        
        data.setValue(ChatData.userName + " total messages: " + ChatData.userTotalMessages, ChatData.userTotalMessages);
        data.setValue(ChatData.otherName + " total messages: " + ChatData.otherTotalMessages, ChatData.otherTotalMessages);
        
        JFreeChart messagesComparation = ChartFactory.createPieChart("Messages per person", data, true, true, true);
        
        pieImage = messagesComparation.createBufferedImage(400, 300);
    }
    
    private void loadMessagesComparationImage()
    {
        DefaultCategoryDataset dayMessagesData = new DefaultCategoryDataset(); 
        
        for(ChatDay day : ChatData.chatDays)
        {
            dayMessagesData.setValue(day.getMessages().size(), "Messages", day.getDate());
        }
        
        JFreeChart dayMessagesComparation = ChartFactory.createBarChart("Comparison of messages per day", "Dates", "Messages", dayMessagesData, PlotOrientation.VERTICAL, true, true, false);
        
        comparationImage = dayMessagesComparation.createBufferedImage(1100, 500);        
    }
    
    private String getTopDaysMessage()
    {
        StringBuilder sb = new StringBuilder("TOP DAYS WITH HIGHEST MESSAGES NUMBER");
        sb.append("\n").append("\n");
        
        if(ChatData.chatDays.size() > 10)
        {
            for(int i = 0; i < 10; i++)
            {
                sb.append((i+1)).append(". ").append(ChatData.sortedDays.get(i).toString())
                        .append(" - Messages: ").append(ChatData.sortedDays.get(i).getMessages().size()).append("\n");
            }        
        }
        else
        {
            for(int i = 0; i < ChatData.chatDays.size(); i++)
            {
                sb.append((i+1)).append(". ").append(ChatData.sortedDays.get(i).toString())
                        .append(" - Messages: ").append(ChatData.sortedDays.get(i).getMessages().size()).append("\n");
            }            
        }
        
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollTopDays = new javax.swing.JScrollPane();
        topDaysText = new javax.swing.JTextArea();
        pieChartImage = new javax.swing.JLabel();
        comparationAreaScroll = new javax.swing.JScrollPane();
        comparationArea = new javax.swing.JLabel();
        chatSearcherScroll = new javax.swing.JScrollPane();
        chatSearcherPanel = new javax.swing.JPanel();
        searchButton = new javax.swing.JButton();
        resultScroll = new javax.swing.JScrollPane();
        resultTextArea = new javax.swing.JTextArea();
        searchTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(10, 10, 0, 0));
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));

        topDaysText.setEditable(false);
        topDaysText.setColumns(20);
        topDaysText.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        topDaysText.setRows(5);
        topDaysText.setText(getTopDaysMessage());
        topDaysText.setBorder(null);
        topDaysText.setOpaque(false);
        scrollTopDays.setViewportView(topDaysText);

        pieChartImage.setIcon(new ImageIcon(pieImage));
        pieChartImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        comparationArea.setIcon(new ImageIcon(comparationImage));
        comparationArea.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        comparationAreaScroll.setViewportView(comparationArea);

        searchButton.setBackground(new java.awt.Color(231, 255, 229));
        searchButton.setText("Search");
        searchButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        resultTextArea.setEditable(false);
        resultTextArea.setColumns(20);
        resultTextArea.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12)); // NOI18N
        resultTextArea.setRows(5);
        resultTextArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        resultScroll.setViewportView(resultTextArea);

        searchTextField.setText("Type a sentence to search . . .");
        searchTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout chatSearcherPanelLayout = new javax.swing.GroupLayout(chatSearcherPanel);
        chatSearcherPanel.setLayout(chatSearcherPanelLayout);
        chatSearcherPanelLayout.setHorizontalGroup(
            chatSearcherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(resultScroll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
            .addGroup(chatSearcherPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(chatSearcherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chatSearcherPanelLayout.createSequentialGroup()
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(searchTextField))
                .addContainerGap())
        );
        chatSearcherPanelLayout.setVerticalGroup(
            chatSearcherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chatSearcherPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resultScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
        );

        chatSearcherScroll.setViewportView(chatSearcherPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comparationAreaScroll)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollTopDays, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pieChartImage, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chatSearcherScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comparationAreaScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollTopDays)
                    .addComponent(pieChartImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chatSearcherScroll))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        
        if(searchTextField.getText().equals(""))
        {
            resultTextArea.setText("");
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        
        ChatData
            .chatDays.stream()
            .flatMap(chatDay -> chatDay.getMessages().stream())
            .filter(message -> message.contains(searchTextField.getText().toLowerCase())).forEach(message -> sb.append(message).append("\n"));
        
        resultTextArea.setText(sb.toString());
        
        searchTextField.setText("");
  
    }//GEN-LAST:event_searchButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel chatSearcherPanel;
    private javax.swing.JScrollPane chatSearcherScroll;
    private javax.swing.JLabel comparationArea;
    private javax.swing.JScrollPane comparationAreaScroll;
    private javax.swing.JLabel pieChartImage;
    private javax.swing.JScrollPane resultScroll;
    private javax.swing.JTextArea resultTextArea;
    private javax.swing.JScrollPane scrollTopDays;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JTextArea topDaysText;
    // End of variables declaration//GEN-END:variables

}
