package ihm;

import angleterre.dao.IDaoFunctionImplAngletterre;
import angleterre.model.SalaireAngleterre;
import lombok.SneakyThrows;

import javax.swing.table.DefaultTableModel;
import java.io.IOException;

/**
 *
 * @author abdou
 */
public class AngleterreIHM2 extends javax.swing.JFrame {

    DefaultTableModel model=new DefaultTableModel();
    IDaoFunctionImplAngletterre iDaoFunctionImplAngletterre = new IDaoFunctionImplAngletterre();

    public AngleterreIHM2() throws IOException {
        initComponents();
        model.addColumn("Matricule");
        model.addColumn("Nom");
        model.addColumn("Prenom");
        model.addColumn("NombreHeure");
        model.addColumn("HeureSup");
        model.addColumn("Avantage");
        model.addColumn("IndLogement");
        model.addColumn("IndTransport");
        model.addColumn("Pret");
        model.addColumn("SalaireAngleterre");

        for (SalaireAngleterre salaire: iDaoFunctionImplAngletterre.getSalairesByMounth("01/03/2021-31/03/2021")){
            model.addRow(
                    new Object[]{
                            salaire.getMatricule(),
                            salaire.getNom(),
                            salaire.getPrenom(),
                            salaire.getNombreHeure(),
                            salaire.getHeureSup(),
                            salaire.getAvantage(),
                            salaire.getIndLogement(),
                            salaire.getIndTransport(),
                            salaire.getPret(),
                            salaire.getSalaire()
                    });
        }
        txtTable.setModel(model);

        pHomme.setText(String.valueOf(iDaoFunctionImplAngletterre.pourcentageHomme())+" %");
        pFemme.setText(String.valueOf(iDaoFunctionImplAngletterre.pourcentageFeminin())+" %");
        pCadre.setText(String.valueOf(iDaoFunctionImplAngletterre.pourcentageCadres())+" %");
        pOuvrier.setText(String.valueOf(iDaoFunctionImplAngletterre.pourcentageOuvriers())+ " %");
        bSalaire.setText(String.valueOf(iDaoFunctionImplAngletterre.getBudgetTotal("01/03/2021-31/03/2021"))+" %");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        listeDate = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pOuvrier = new javax.swing.JTextField();
        pHomme = new javax.swing.JTextField();
        pFemme = new javax.swing.JTextField();
        bSalaire = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        pCadre = new javax.swing.JTextField();
        listeDate1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        txtTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null}
                },
                new String [] {
                        "Matricule", "Nom", "Prenom", "NombreHeure", "HeureSup", "Avantage", "IndLogement", "IndTransport", "Pret", "Salaire"
                }
        ) {
            Class[] types = new Class [] {
                    String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false, false, false, false
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(txtTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 110, 860, 110);

        jLabel1.setBackground(new java.awt.Color(153, 204, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("   Glabale Human Ressource");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(210, 20, 480, 50);

        listeDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        listeDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mars", "Janvier", "Fevrier ", "Avril", "Main", "Juin", "Julliet", "Aout", "Septembre", "Octobre", "Novembre", "Decembre"}));
        listeDate.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listeDateActionPerformed(evt);
            }
        });
        getContentPane().add(listeDate);
        listeDate.setBounds(1060, 110, 110, 30);

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setText("Afficher");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(980, 170, 110, 40);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("      Pourcentage Ouvrier");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(430, 260, 200, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("      Pourcentage Homme");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 260, 200, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("      Pourcentage Femme");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 310, 200, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("      Budget Salariale");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 360, 200, 30);

        pOuvrier.setEditable(false);
        pOuvrier.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pOuvrierActionPerformed(evt);
            }
        });
        getContentPane().add(pOuvrier);
        pOuvrier.setBounds(660, 250, 70, 40);

        pHomme.setEditable(false);
        pHomme.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        pHomme.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pHommeActionPerformed(evt);
            }
        });
        getContentPane().add(pHomme);
        pHomme.setBounds(280, 260, 70, 40);

        pFemme.setEditable(false);
        pFemme.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pFemmeActionPerformed(evt);
            }
        });
        getContentPane().add(pFemme);
        pFemme.setBounds(280, 310, 70, 40);

        bSalaire.setEditable(false);
        bSalaire.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalaireActionPerformed(evt);
            }
        });
        getContentPane().add(bSalaire);
        bSalaire.setBounds(280, 360, 70, 40);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("      Pourcentage Cadre");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(430, 310, 200, 30);

        pCadre.setEditable(false);
        pCadre.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pCadreActionPerformed(evt);
            }
        });
        getContentPane().add(pCadre);
        pCadre.setBounds(660, 300, 70, 40);

        listeDate1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        listeDate1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Senegal", "France", "Angleterre", "Chine" }));
        listeDate1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listeDate1ActionPerformed(evt);
            }
        });
        getContentPane().add(listeDate1);
        listeDate1.setBounds(920, 110, 110, 30);

        pack();
    }// </editor-fold>

    private void listeDateActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void pOuvrierActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void pHommeActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void pFemmeActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void bSalaireActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void pCadreActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void listeDate1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AngleterreIHM2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AngleterreIHM2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AngleterreIHM2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AngleterreIHM2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {

                AngleterreIHM2 angleterreIHM = new AngleterreIHM2();
                angleterreIHM.setSize(950, 680);
                angleterreIHM.setVisible(true);
            }
        });
    }

    private javax.swing.JTextField bSalaire;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> listeDate;
    private javax.swing.JComboBox<String> listeDate1;
    private javax.swing.JTextField pCadre;
    private javax.swing.JTextField pFemme;
    private javax.swing.JTextField pHomme;
    private javax.swing.JTextField pOuvrier;
    private javax.swing.JTable txtTable;
    // End of variables declaration
}
