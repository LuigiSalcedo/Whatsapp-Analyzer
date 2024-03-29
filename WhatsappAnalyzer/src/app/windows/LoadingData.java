package app.windows;

import app.control.Controller;
import javax.swing.JLabel;

/**
 *
 * @author Luigi Salcedo
 */
public class LoadingData extends javax.swing.JFrame {

    public LoadingData() {
        initComponents();
        Controller.readFile(this);
        Controller.setStats(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loadingChatDataText = new javax.swing.JLabel();
        loadingEmojiDataText = new javax.swing.JLabel();
        ladoSettingsDataText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Loading data, please wait . . .");

        loadingChatDataText.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        loadingChatDataText.setText("Cargando información del chat . . . (Espere)");

        loadingEmojiDataText.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        loadingEmojiDataText.setText("Cargando emojis disponibles . . . (Espere)");

        ladoSettingsDataText.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        ladoSettingsDataText.setText("Organizando información del chat . . . (Espere)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loadingChatDataText)
                    .addComponent(loadingEmojiDataText)
                    .addComponent(ladoSettingsDataText))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(loadingChatDataText)
                .addGap(18, 18, 18)
                .addComponent(loadingEmojiDataText)
                .addGap(18, 18, 18)
                .addComponent(ladoSettingsDataText)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        loadingChatDataText.getAccessibleContext().setAccessibleName("Cargando información del chat . . . (Espere) ");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JLabel getLadoSettingsDataText() {
        return ladoSettingsDataText;
    }

    public void setLadoSettingsDataText(JLabel ladoSettingsDataText) {
        this.ladoSettingsDataText = ladoSettingsDataText;
    }

    public JLabel getLoadingChatDataText() {
        return loadingChatDataText;
    }

    public void setLoadingChatDataText(JLabel loadingChatDataText) {
        this.loadingChatDataText = loadingChatDataText;
    }

    public JLabel getLoadingEmojiDataText() {
        return loadingEmojiDataText;
    }

    public void setLoadingEmojiDataText(JLabel loadingEmojiDataText) {
        this.loadingEmojiDataText = loadingEmojiDataText;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ladoSettingsDataText;
    private javax.swing.JLabel loadingChatDataText;
    private javax.swing.JLabel loadingEmojiDataText;
    // End of variables declaration//GEN-END:variables
}
