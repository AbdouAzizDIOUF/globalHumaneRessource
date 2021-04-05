package ihm;


import chine.ihm.ChineIHM;
import france.ihm.FranceIHM;
import lombok.SneakyThrows;
import senegal.ihm.SenegalIHM;

import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author abdou
 */
public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        chine_button = new javax.swing.JButton();
        principale_button = new javax.swing.JButton();
        senegal_button = new javax.swing.JButton();
        angleterre_button = new javax.swing.JButton();
        france_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        chine_button.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        chine_button.setText("CHINE");
        chine_button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chine_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(chine_button);
        chine_button.setBounds(200, 440, 553, 58);

        principale_button.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        principale_button.setText("PRINCIPALE");
        principale_button.addActionListener(new java.awt.event.ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                principale_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(principale_button);
        principale_button.setBounds(200, 120, 553, 58);

        senegal_button.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        senegal_button.setText("SENEGAL");
        senegal_button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senegal_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(senegal_button);
        senegal_button.setBounds(200, 200, 553, 58);

        angleterre_button.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        angleterre_button.setText("ANGLETERRE");
        angleterre_button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                angleterre_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(angleterre_button);
        angleterre_button.setBounds(200, 280, 553, 58);

        france_button.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        france_button.setText("FRANCE");
        france_button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                france_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(france_button);
        france_button.setBounds(200, 360, 553, 58);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("  GLOBAL HUMAN RESSOURCES");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(140, 10, 700, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon("E:\\Projets\\java\\classe\\projetIntegrationWithMaven\\src\\main\\resources\\icone\\Global-Human-Resource-Management.jpg")); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 960, 530);

        pack();
    }// </editor-fold>

    private void chine_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        new ChineIHM().setVisible(true);
    }

    private void principale_buttonActionPerformed(java.awt.event.ActionEvent evt) throws SQLException, IOException, ClassNotFoundException {
        new Principale().setVisible(true);
    }

    private void senegal_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        new SenegalIHM().setVisible(true);
    }

    private void angleterre_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        new Angleterre().setVisible(true);
    }

    private void france_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        new FranceIHM().setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Menu m = new Menu();
                m.setSize(958, 632);
                m.setVisible(true);
            }
        });
    }

    private javax.swing.JButton angleterre_button;
    private javax.swing.JButton chine_button;
    private javax.swing.JButton france_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton principale_button;
    private javax.swing.JButton senegal_button;
    // End of variables declaration

}
