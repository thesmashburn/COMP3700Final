
import java.awt.CardLayout;
import java.awt.Image;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author The Smashburn
 */
public class LoginServerClient extends javax.swing.JFrame {

    /**
     * Creates new form LoginServerClient
     */
    public LoginServerClient() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        loginNameField = new javax.swing.JTextField();
        loginPassField = new javax.swing.JPasswordField();
        loginSubmit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Login To MarketPlace");

        loginSubmit.setText("Submit");
        loginSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(328, 328, 328)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(loginPassField, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(loginNameField))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(257, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(203, 203, 203))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(loginSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(258, 258, 258))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(124, 124, 124)
                .addComponent(loginNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginPassField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(loginSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginSubmitActionPerformed
        // TODO add your handling code here:
        String username = loginNameField.getText();
        char[] passwordChar = loginPassField.getPassword();
        String password = new String(passwordChar);
        Boolean valid = false;
        
        
        Socket echoSocket = null;
        ObjectOutputStream out = null;
        ObjectInputStream in = null;

        try {
           
            echoSocket = new Socket("127.0.0.1", 10007);
            
            out = new ObjectOutputStream(echoSocket.getOutputStream());
            in = new ObjectInputStream(echoSocket.getInputStream());

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: taranis.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                               + "the connection to: taranis.");
            System.exit(1);
        }

	User send  = new User(username, password, "", 0);
        User recieve = null;
        try {
        System.out.println ("Sending point: " + send + " to Server");
	out.writeObject(send);
        out.flush();
        System.out.println ("Send point, waiting for return value");

        try {
             recieve = (User) in.readObject();
             valid = true;
            }
        catch (Exception ex)
            {
             System.out.println (ex.getMessage());
            }

	System.out.println("Got point: " + recieve + " from Server");

	out.close();
	in.close();
	echoSocket.close();
        } catch(Exception e) {
            System.out.print("nope");
        }
        /*
        if (valid) {
             CardLayout card = (CardLayout)mainPanel.getLayout();
             card.show(mainPanel, "card3");
             homeNameLabel.setText(username);
             
             if (!MarketPlaceDriver.mainSys.isAdmin()) {
                 //setvisibility
                 homeReportButton.setVisible(false);
                 homeManagementButton.setVisible(false);
                 updateButton.setVisible(false);
                 addButton.setVisible(false);
             }
             
             //Set Profile Picture
              try {
                User mainuser = MarketPlaceDriver.mainSys.getUser();
                URL url = new URL(mainuser.getProfilePic());
                Image image = ImageIO.read(url);
                Image resizedImage =  image.getScaledInstance(homeNameLabel.getWidth(), homeNameLabel.getHeight(), 1);
                homeNameLabel.setIcon(new ImageIcon(resizedImage));
        } catch (Exception e) {
            
        }*/
             
    }//GEN-LAST:event_loginSubmitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginServerClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginServerClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginServerClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginServerClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginServerClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField loginNameField;
    private javax.swing.JPasswordField loginPassField;
    private javax.swing.JButton loginSubmit;
    // End of variables declaration//GEN-END:variables
}
