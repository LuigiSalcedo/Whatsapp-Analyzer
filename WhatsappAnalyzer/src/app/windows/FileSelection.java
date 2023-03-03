package app.windows;

import app.control.Controller;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;


/**
 *
 * @author Luigi Salcedo
 */
public class FileSelection extends javax.swing.JFrame 
{
    private static File chatFile;
    static FileSelection fs;
    
    /**
     * Creates new form fileSelector
     */
    public FileSelection() {
        initComponents();
        launchButton.setEnabled(false);
        this.setTitle("Whatsapp Analyzer");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        mainTitle = new javax.swing.JLabel();
        message = new javax.swing.JLabel();
        selectFileButton = new javax.swing.JButton();
        fileName = new javax.swing.JLabel();
        launchButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(500, 300, 0, 0));

        mainTitle.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        mainTitle.setText("Whatsapp Analyzer");

        message.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        message.setText("Please select a chat file . . .");

        selectFileButton.setBackground(new java.awt.Color(231, 255, 229));
        selectFileButton.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        selectFileButton.setText("Select file");
        selectFileButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        selectFileButton.setFocusable(false);
        selectFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectFileButtonActionPerformed(evt);
            }
        });

        fileName.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        fileName.setText("No file selected yet.");

        launchButton.setBackground(new java.awt.Color(229, 255, 255));
        launchButton.setText("Launch");
        launchButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        launchButton.setFocusable(false);
        launchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                launchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(message)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(selectFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fileName))
                    .addComponent(mainTitle))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(152, Short.MAX_VALUE)
                .addComponent(launchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(message)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectFileButton)
                    .addComponent(fileName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(launchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
       
    /*
     *  Método listener: botón "Select file".
     * 
     *  Abrir el selecto de archivos.
     */
    private void selectFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectFileButtonActionPerformed

        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivo de texto plano", "txt"));
        fileChooser.showOpenDialog(this);
        
        chatFile = fileChooser.getSelectedFile();
        
        if(chatFile != null)
        {
            if(!chatFile.getName().equals(""))
            {
                fileName.setText(chatFile.getName());
                launchButton.setEnabled(true);   
            }
        }
        else
        {
            fileName.setText("No file selected yet.");
            launchButton.setEnabled(false);
        }   
    }//GEN-LAST:event_selectFileButtonActionPerformed

    /*
     *  Método listener: botón "Launch".
     *  
     *  Ejecutar el procesamiento del archivo seleccionado.
     */
    private void launchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_launchButtonActionPerformed
        
        LoadingData ld = new LoadingData();
        
        ld.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        ld.setVisible(true);
        
        Controller.readFile(ld);
        Controller.setStats(ld);
        
        ld.setVisible(false);
       
        fs = this;
        
        this.setVisible(false);
        
        MainWindow mw = new MainWindow();
        
        mw.setVisible(true);
        
        mw.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_launchButtonActionPerformed

    /*
     *  Métodos propios.
     */
    
    public static File getFile()
    {
        return chatFile;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JLabel fileName;
    private javax.swing.JButton launchButton;
    private javax.swing.JLabel mainTitle;
    private javax.swing.JLabel message;
    private javax.swing.JButton selectFileButton;
    // End of variables declaration//GEN-END:variables
}
