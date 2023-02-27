
import java.awt.Color;

public class OptionDlg extends javax.swing.JDialog {
//Ne fonctionne pas comme les autre JDialog avec un boolean de retour vrai ou faux.
//Ici je sauvegarde les parametres dans paramSave.
//Si on valide, je recupère choixOpt, nbCol, nbNum (Modifié)
//Si on ne valide pas, je change choixOpt, nbCol, nbNum selon pâramSave et je récupère les options non modifié en exterieur
    private int choixOpt;
    private int nbCol;
    private int nbNum;
    private int[] paramSave;//Sauvegarde des parametres

    //Servira pour construire parametres en sortie 
    public int getChoixOpt() {
        return choixOpt;
    }
    //Servira pour construire parametres en sortie 
    public int getNbCol() {
        return nbCol;
    }
    //Servira pour construire parametres en sortie 
    public int getNbNum() {
        return nbNum;
    }

    public OptionDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        remplirComboCol();
        NbNumero.setText("4");
    }

    public OptionDlg(java.awt.Frame parent, boolean modal, boolean isLimited, int[] parametres) {
        super(parent, modal);
        initComponents();
        //Rensseigne les parametres exterieurs
        this.paramSave = parametres;
        //Selection du mode de jeu selon l'entrée
        switch (parametres[0]) {
            case 2:
                select2.setSelected(true);
                this.choixOpt = 2;
                break;
            case 3:
                select3.setSelected(true);
                this.choixOpt = 3;
                break;
            default:
                select1.setSelected(true);
                this.choixOpt = 1;
        }

        if (isLimited) {
            ComboNbCol.addItem("" + parametres[1]);
        } else {
            remplirComboCol();
        }

        NbNumero.setText("" + parametres[2]);
        //Debloque les options verouillé si isLimited==true
        if (isLimited) {
            ComboNbCol.setEnabled(false);
            NbNumero.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        NORTH = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        CENTER = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        select1 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        select2 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        select3 = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        ComboNbCol = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        NbNumero = new javax.swing.JTextField();
        Message = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel7.setText("Option du jeu");
        NORTH.add(jLabel7);

        getContentPane().add(NORTH, java.awt.BorderLayout.NORTH);

        CENTER.setLayout(new java.awt.GridLayout(1, 2));

        jPanel6.setLayout(new java.awt.GridLayout(9, 1));

        jLabel2.setText("Comment voulez vous jouer ?");
        jPanel6.add(jLabel2);
        jPanel6.add(jLabel3);

        buttonGroup1.add(select1);
        select1.setText("Quinte - Une ligne complète");
        select1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select1ActionPerformed(evt);
            }
        });
        jPanel6.add(select1);
        jPanel6.add(jLabel4);

        buttonGroup1.add(select2);
        select2.setText("Double Quinte - Deux lignes complètes");
        select2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select2ActionPerformed(evt);
            }
        });
        jPanel6.add(select2);
        jPanel6.add(jLabel5);

        buttonGroup1.add(select3);
        select3.setText("Carton plein - Trois lignes complètes");
        select3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select3ActionPerformed(evt);
            }
        });
        jPanel6.add(select3);
        jPanel6.add(jLabel6);

        jButton1.setText("Annuler");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton1);

        CENTER.add(jPanel6);

        jPanel7.setLayout(new java.awt.GridLayout(9, 1));

        jLabel8.setText("Configuration des cartons");
        jPanel7.add(jLabel8);
        jPanel7.add(jLabel9);

        jPanel8.setLayout(new java.awt.GridLayout(1, 2));

        jLabel14.setText("Combien de colonnes ?");
        jPanel8.add(jLabel14);

        ComboNbCol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboNbColActionPerformed(evt);
            }
        });
        jPanel8.add(ComboNbCol);

        jPanel7.add(jPanel8);
        jPanel7.add(jLabel10);

        jPanel9.setLayout(new java.awt.GridLayout(1, 2));

        jLabel15.setText("Combien de numéro ?");
        jPanel9.add(jLabel15);
        jPanel9.add(NbNumero);

        jPanel7.add(jPanel9);
        jPanel7.add(Message);
        jPanel7.add(jLabel12);
        jPanel7.add(jLabel13);

        jButton2.setText("Valider");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton2);

        CENTER.add(jPanel7);

        getContentPane().add(CENTER, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.choixOpt = this.paramSave[0];
        this.nbCol = this.paramSave[1];
        this.nbNum = this.paramSave[2];
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void remplirComboCol() {
        ComboNbCol.addItem("5");
        ComboNbCol.addItem("6");
        ComboNbCol.addItem("7");
        ComboNbCol.addItem("8");
        ComboNbCol.addItem("9");
        //Place la ComboBox sur le bon indice selon ce qui est selectionné en entrée
        ComboNbCol.setSelectedIndex(paramSave[1] - 5);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //IsParasable et Vérifie que pas de vides
        if (isParsable(NbNumero.getText()) && !NbNumero.getText().equals("")) {
            int nbNumero = Integer.parseInt((String) NbNumero.getText());
            //Verifie que le nb de numero est cohérent
            if (nbNumero <= (3 * this.nbCol) && nbNumero > 4) {
                this.nbNum = Integer.parseInt((String) NbNumero.getText());
                dispose();
            } else {
                //Met la zone en rouge si pas bon
                this.nbNum = this.paramSave[2];
                NbNumero.setBackground(Color.red);
            }
        } else {
            //Met la zone en rouge si pas bon
            this.nbNum = this.paramSave[2];
            NbNumero.setBackground(Color.red);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void select1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select1ActionPerformed
        this.choixOpt = 1;
    }//GEN-LAST:event_select1ActionPerformed

    private void select2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select2ActionPerformed
        this.choixOpt = 2;
    }//GEN-LAST:event_select2ActionPerformed

    private void select3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select3ActionPerformed
        this.choixOpt = 3;
    }//GEN-LAST:event_select3ActionPerformed

    private void ComboNbColActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboNbColActionPerformed
        if (isParsable((String) ComboNbCol.getSelectedItem())) {
            this.nbCol = Integer.parseInt((String) ComboNbCol.getSelectedItem());
        }
    }//GEN-LAST:event_ComboNbColActionPerformed

    //Verifei que mot est Parsable
    private boolean isParsable(String mot) {
        char a[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int cmp = 0;
        for (int i = 0; i < mot.length(); i++) {
            for (int j = 0; j < a.length; j++) {
                if (mot.charAt(i) == a[j]) {
                    cmp++;
                }
            }
        }
        if (cmp == mot.length()) {
            return true;
        } else {
            return false;
        }
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
            java.util.logging.Logger.getLogger(OptionDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OptionDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OptionDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OptionDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                OptionDlg dialog = new OptionDlg(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CENTER;
    private javax.swing.JComboBox<String> ComboNbCol;
    private javax.swing.JLabel Message;
    private javax.swing.JPanel NORTH;
    private javax.swing.JTextField NbNumero;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton select1;
    private javax.swing.JRadioButton select2;
    private javax.swing.JRadioButton select3;
    // End of variables declaration//GEN-END:variables
}
