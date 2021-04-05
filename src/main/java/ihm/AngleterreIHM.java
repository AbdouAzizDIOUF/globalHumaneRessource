package ihm;

import lombok.SneakyThrows;
import mediateur.Mediateur;

import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author abdou
 */
public class AngleterreIHM extends javax.swing.JFrame {

    static Map<String, String> periodePaie;

    DefaultTableModel model= null;
    Mediateur m = new Mediateur();

    public AngleterreIHM() throws SQLException, IOException, ClassNotFoundException {

        System.out.println(m.getSenegal().pourcentageCadres());
        System.out.println(m.getSenegal().pourcentageOuvriers());

        periodePaie = new HashMap<>();
        periodePaie.put("Janvier", "01/01/2021-31/01/2021");
        periodePaie.put("Fevrier", "01/02/2021-28/02/2021");
        periodePaie.put("Mars", "01/03/2021-31/03/2021");
        periodePaie.put("Avril", "01/04/2021-31/04/2021");

        initComponents();

        String pays = Objects.requireNonNull(listeDate1.getSelectedItem()).toString();
        String date = Objects.requireNonNull(listeDate.getSelectedItem()).toString();
        afficheListeSalaire("Angleterre", "01/01/2021-31/01/2021");
        nombreSalariales("01/01/2021-31/01/2021");
        getPourcentage();
        nombreEmployes();
    }

    public void afficheListeSalaire(String pays,String date) throws SQLException, IOException, ClassNotFoundException, IOException, SQLException {
        model = new DefaultTableModel();
        model.addColumn("Matricule");
        model.addColumn("Nom");
        model.addColumn("Poste");
        model.addColumn("Contrat");
        model.addColumn("Pays");
        model.addColumn("Salaire");
        m.getSalairesEmployes(pays, date).forEach(salaire->{
            model.addRow(
                    new Object[]{
                            salaire.getMatricule(),
                            salaire.getNom(),
                            salaire.getPoste(),
                            salaire.getContrat(),
                            salaire.getPays(),
                            salaire.getSalaire()
                    });
            System.out.println(salaire.toString());
        });
        txtTable.setModel(model);
    }


    public void getPourcentage() throws SQLException, IOException, ClassNotFoundException {
        pHomme.setText(String.valueOf(m.getPourcentageHomme())+" %");
        pFemme.setText(String.valueOf(m.getPourcentageFemme())+" %");
        pCadre.setText(String.valueOf(m.getPourcentageCadres())+" %");
        pOuvrier.setText(String.valueOf(m.getPourcentageOuvrier())+ " %");
    }


    public void nombreSalariales(String date) throws SQLException, IOException, ClassNotFoundException {
        nbSalaries_sen1.setText(String.valueOf(Math.round(m.getSenegal().getBudgetTotal(date)))+" %");
        nbSalaries_ang1.setText(String.valueOf(Math.round(m.getAngleterre().getBudgetTotal(date)))+" %");
        nbSalaries_chi2.setText(String.valueOf(Math.round(m.getChine().getBudgetTotal(date)))+" %");
        nbSalaries_fra1.setText(String.valueOf(Math.round(m.getFrance().getBudgetTotal(date)))+" %");
        nbSalaries_totale1.setText(String.valueOf(Math.round(m.getBudgetTotal(date)))+" %");
    }

    public void nombreEmployes() throws SQLException, IOException, ClassNotFoundException {
        nbSalaries_sen.setText(String.valueOf(Math.round(m.getSenegal().getNombreEmployer())));
        nbSalaries_ang.setText(String.valueOf(Math.round(m.getAngleterre().getNombreEmployer())));
        nbSalaries_chi1.setText(String.valueOf(Math.round(m.getChine().getNombreEmployer())));
        nbSalaries_fra.setText(String.valueOf(Math.round(m.getFrance().getNombreEmployer())));
        nbSalaries_totale.setText(String.valueOf(Math.round(m.getNombreEmployes())));
    }
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtTable = new javax.swing.JTable();
        listeDate = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pOuvrier = new javax.swing.JTextField();
        pHomme = new javax.swing.JTextField();
        pFemme = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        pCadre = new javax.swing.JTextField();
        listeDate1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        nbSalaries_totale = new javax.swing.JLabel();
        nbSalaries_sen = new javax.swing.JLabel();
        nbSalaries_ang = new javax.swing.JLabel();
        nbSalaries_fra = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        nbSalaries_chi1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        nbSalaries_sen1 = new javax.swing.JLabel();
        nbSalaries_ang1 = new javax.swing.JLabel();
        nbSalaries_fra1 = new javax.swing.JLabel();
        nbSalaries_chi2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        nbSalaries_totale1 = new javax.swing.JLabel();
        txtMatricule = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtPoste = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtContrat = new javax.swing.JTextField();
        txtPays = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtSalaire = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        txtTable.setBackground(new java.awt.Color(204, 204, 255));
        txtTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                new String [] {
                        "Matricule", "Nom", "Poste", "Contrat", "Salaire", "Pays"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false
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
        jScrollPane1.setBounds(10, 100, 660, 220);

        listeDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        listeDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mars", "Janvier", "Fevrier " }));
        listeDate.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listeDateActionPerformed(evt);
            }
        });
        getContentPane().add(listeDate);
        listeDate.setBounds(820, 120, 110, 30);

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setText("Afficher");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(760, 170, 110, 40);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Pourcentage Ouvrier");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(1010, 560, 150, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Pourcentage Homme");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(730, 620, 160, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Pourcentage Femme");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(1000, 620, 148, 30);

        pOuvrier.setEditable(false);
        pOuvrier.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pOuvrierActionPerformed(evt);
            }
        });
        getContentPane().add(pOuvrier);
        pOuvrier.setBounds(1180, 560, 70, 30);

        pHomme.setEditable(false);
        pHomme.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        pHomme.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pHommeActionPerformed(evt);
            }
        });
        getContentPane().add(pHomme);
        pHomme.setBounds(900, 620, 70, 30);

        pFemme.setEditable(false);
        pFemme.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pFemmeActionPerformed(evt);
            }
        });
        getContentPane().add(pFemme);
        pFemme.setBounds(1180, 620, 70, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Pourcentage Cadre");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(730, 560, 140, 30);

        pCadre.setEditable(false);
        pCadre.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pCadreActionPerformed(evt);
            }
        });
        getContentPane().add(pCadre);
        pCadre.setBounds(900, 560, 70, 30);

        listeDate1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        listeDate1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Senegal", "France", "Angleterre", "Chine", "Max Salaire", "Min Salaire", " " }));
        listeDate1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listeDate1ActionPerformed(evt);
            }
        });
        getContentPane().add(listeDate1);
        listeDate1.setBounds(680, 120, 110, 30);

        jLabel2.setBackground(new java.awt.Color(204, 204, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("Budget Salariales");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(270, 410, 160, 40);

        jLabel9.setBackground(new java.awt.Color(255, 102, 153));
        jLabel9.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel9.setText("Chine");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(10, 580, 100, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel10.setText("Senegal");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(10, 490, 100, 20);

        jLabel11.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel11.setText("Angleterre");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(10, 520, 100, 20);

        jLabel12.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel12.setText("France");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(10, 550, 100, 20);

        nbSalaries_totale.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        nbSalaries_totale.setText("XX.xx");
        getContentPane().add(nbSalaries_totale);
        nbSalaries_totale.setBounds(110, 640, 60, 23);

        nbSalaries_sen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nbSalaries_sen.setText("XX.xx");
        getContentPane().add(nbSalaries_sen);
        nbSalaries_sen.setBounds(120, 490, 50, 30);

        nbSalaries_ang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nbSalaries_ang.setText("XX.xx");
        getContentPane().add(nbSalaries_ang);
        nbSalaries_ang.setBounds(120, 520, 50, 30);

        nbSalaries_fra.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nbSalaries_fra.setText("XX.xx");
        getContentPane().add(nbSalaries_fra);
        nbSalaries_fra.setBounds(120, 550, 50, 30);

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparator1.setOpaque(true);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(260, 620, 180, 10);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel8.setText("Totale ");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(10, 640, 80, 22);

        nbSalaries_chi1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nbSalaries_chi1.setText("XX.xx");
        getContentPane().add(nbSalaries_chi1);
        nbSalaries_chi1.setBounds(120, 580, 50, 30);

        jLabel13.setBackground(new java.awt.Color(204, 204, 255));
        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel13.setText("Nombre de Salaries");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(10, 410, 200, 40);

        jLabel14.setBackground(new java.awt.Color(204, 255, 51));
        jLabel14.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel14.setText("Senegal");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(260, 490, 100, 20);

        jLabel15.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel15.setText("Angleterre");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(260, 520, 100, 20);

        jLabel16.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel16.setText("Senegal");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(260, 550, 100, 20);

        jLabel17.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel17.setText("Angleterre");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(260, 585, 100, 20);

        nbSalaries_sen1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nbSalaries_sen1.setText("XX.xx");
        getContentPane().add(nbSalaries_sen1);
        nbSalaries_sen1.setBounds(390, 490, 50, 20);

        nbSalaries_ang1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nbSalaries_ang1.setText("XX.xx");
        getContentPane().add(nbSalaries_ang1);
        nbSalaries_ang1.setBounds(390, 520, 50, 20);

        nbSalaries_fra1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nbSalaries_fra1.setText("XX.xx");
        getContentPane().add(nbSalaries_fra1);
        nbSalaries_fra1.setBounds(390, 550, 50, 20);

        nbSalaries_chi2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nbSalaries_chi2.setText("XX.xx");
        getContentPane().add(nbSalaries_chi2);
        nbSalaries_chi2.setBounds(390, 580, 50, 20);

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparator2.setOpaque(true);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(10, 620, 170, 10);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel18.setText("Totale ");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(260, 640, 80, 22);

        nbSalaries_totale1.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        nbSalaries_totale1.setText("XX.xx");
        getContentPane().add(nbSalaries_totale1);
        nbSalaries_totale1.setBounds(370, 640, 60, 23);

        txtMatricule.setEditable(false);
        txtMatricule.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatriculeActionPerformed(evt);
            }
        });
        getContentPane().add(txtMatricule);
        txtMatricule.setBounds(1080, 120, 160, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Maricule :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(960, 130, 100, 17);

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel19.setText("Nom     :");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(960, 170, 100, 17);

        txtNom.setEditable(false);
        txtNom.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomActionPerformed(evt);
            }
        });
        getContentPane().add(txtNom);
        txtNom.setBounds(1080, 160, 160, 30);

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel20.setText("Poste :");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(960, 210, 100, 17);

        txtPoste.setEditable(false);
        txtPoste.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPosteActionPerformed(evt);
            }
        });
        getContentPane().add(txtPoste);
        txtPoste.setBounds(1080, 200, 160, 30);

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel21.setText("Contrat :");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(960, 250, 100, 17);

        txtContrat.setEditable(false);
        txtContrat.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContratActionPerformed(evt);
            }
        });
        getContentPane().add(txtContrat);
        txtContrat.setBounds(1080, 240, 160, 30);

        txtPays.setEditable(false);
        txtPays.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaysActionPerformed(evt);
            }
        });
        getContentPane().add(txtPays);
        txtPays.setBounds(1080, 280, 160, 30);

        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel22.setText("Pays   :");
        getContentPane().add(jLabel22);
        jLabel22.setBounds(960, 290, 100, 17);

        txtSalaire.setEditable(false);
        txtSalaire.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalaireActionPerformed(evt);
            }
        });
        getContentPane().add(txtSalaire);
        txtSalaire.setBounds(1080, 320, 160, 30);

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel23.setText("Salaire   :");
        getContentPane().add(jLabel23);
        jLabel23.setBounds(960, 330, 100, 17);

        jLabel1.setBackground(new java.awt.Color(255, 255, 153));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("   Glabale Human Ressource");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(390, 10, 420, 40);

        jLabel24.setBackground(new java.awt.Color(0, 153, 153));
        jLabel24.setForeground(new java.awt.Color(0, 153, 153));
        jLabel24.setIcon(new javax.swing.ImageIcon("E:\\Projets\\java\\classe\\projetIntegrationWithMaven\\src\\main\\resources\\icone\\backroung1.jpg")); // NOI18N
        getContentPane().add(jLabel24);
        jLabel24.setBounds(0, 400, 510, 290);

        pack();
    }// </editor-fold>

    private void listeDateActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    @SneakyThrows
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException, IOException, ClassNotFoundException {
        String pays = listeDate1.getSelectedItem().toString();
        System.out.println(pays);
        String date = listeDate.getSelectedItem().toString();
        System.out.println(periodePaie.get(date));
        afficheListeSalaire(pays, periodePaie.get(date));
        nombreSalariales(periodePaie.get(date));
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

    private void pCadreActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void listeDate1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void txtMatriculeActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void txtNomActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void txtPosteActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void txtContratActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void txtPaysActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void txtSalaireActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

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
            java.util.logging.Logger.getLogger(AngleterreIHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AngleterreIHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AngleterreIHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AngleterreIHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {

                AngleterreIHM angleterreIHM = new AngleterreIHM();
                angleterreIHM.setSize(550, 580);
                angleterreIHM.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    public static javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel20;
    public static javax.swing.JLabel jLabel21;
    public static javax.swing.JLabel jLabel22;
    public static javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox<String> listeDate;
    private javax.swing.JComboBox<String> listeDate1;
    private javax.swing.JLabel nbSalaries_ang;
    private javax.swing.JLabel nbSalaries_ang1;
    private javax.swing.JLabel nbSalaries_chi1;
    private javax.swing.JLabel nbSalaries_chi2;
    private javax.swing.JLabel nbSalaries_fra;
    private javax.swing.JLabel nbSalaries_fra1;
    private javax.swing.JLabel nbSalaries_sen;
    private javax.swing.JLabel nbSalaries_sen1;
    private javax.swing.JLabel nbSalaries_totale;
    private javax.swing.JLabel nbSalaries_totale1;
    private javax.swing.JTextField pCadre;
    private javax.swing.JTextField pFemme;
    private javax.swing.JTextField pHomme;
    private javax.swing.JTextField pOuvrier;
    public static javax.swing.JTextField txtContrat;
    public static javax.swing.JTextField txtMatricule;
    public static javax.swing.JTextField txtNom;
    public static javax.swing.JTextField txtPays;
    public static javax.swing.JTextField txtPoste;
    public static javax.swing.JTextField txtSalaire;
    private javax.swing.JTable txtTable;
    // End of variables declaration
}
