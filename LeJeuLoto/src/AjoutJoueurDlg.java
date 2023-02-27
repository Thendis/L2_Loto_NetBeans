
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFileChooser;

public class AjoutJoueurDlg extends javax.swing.JDialog {

    private LesJoueurs lstJ; // Stock la liste de joueur
    private Joueur player; //Pour la modification du joueur
    private Color couleur; // Couleur du joueur
    private ImageIcon photo;
    private boolean OK;

    public ImageIcon getPhoto() {
        return photo;
    }

    public void setPhoto(ImageIcon photo) {
        this.photo = photo;
    }

    public AjoutJoueurDlg(java.awt.Frame parent, boolean modal, LesJoueurs lstJ) {
        super(parent, modal);
        initComponents();
        this.lstJ = lstJ;
        this.couleur = zoneCouleur.getBackground();
        paneFile.add(new PanneauImage(new ImageIcon(getClass().getResource("/imgs/defaultImg.png"))));
    }

    public AjoutJoueurDlg(JDialog parent, boolean modal, Joueur j) {
        super(parent, modal);
        initComponents();
        this.player = j;
        this.couleur = j.getCouleur();
        //Construit la carte selon Joueur j
        zonePseudo.setText(player.getPseudo());
        zoneCouleur.setBackground(player.getCouleur());
        zoneSolde.setText(player.getSolde() + "€");
        //Si pas de photo attribut au joueur la photo par défaut
        if (j.getPhoto() == null) {
            this.photo = new ImageIcon(getClass().getResource("/imgs/defaultImg.png"));
        } else {
            this.photo = j.getPhoto();
        }
        paneFile.add(new PanneauImage(this.photo));
    }

    public AjoutJoueurDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public boolean getOK() {
        return this.OK;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NORTH = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        CENTER = new javax.swing.JPanel();
        LEFT = new javax.swing.JPanel();
        mainLeft = new javax.swing.JPanel();
        pseudo = new javax.swing.JLabel();
        LabelCouleur = new javax.swing.JLabel();
        solde = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        secondLeft = new javax.swing.JPanel();
        cancel = new javax.swing.JButton();
        RIGHT = new javax.swing.JPanel();
        mainRigth = new javax.swing.JPanel();
        zonePseudo = new javax.swing.JTextField();
        paneColor = new javax.swing.JPanel();
        buttonCouleur = new javax.swing.JButton();
        zoneCouleur = new javax.swing.JTextField();
        zoneSolde = new javax.swing.JLabel();
        paneFile = new javax.swing.JPanel();
        buttonFile = new javax.swing.JButton();
        secondRigth = new javax.swing.JPanel();
        valider = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        title.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        title.setText("Saisie d'un joueur");
        NORTH.add(title);

        getContentPane().add(NORTH, java.awt.BorderLayout.NORTH);

        CENTER.setLayout(new java.awt.GridLayout(1, 2));

        LEFT.setLayout(new java.awt.BorderLayout());

        mainLeft.setLayout(new java.awt.GridLayout(4, 1));

        pseudo.setText("Pseudo");
        mainLeft.add(pseudo);

        LabelCouleur.setText("Couleur");
        mainLeft.add(LabelCouleur);

        solde.setText("Solde");
        mainLeft.add(solde);

        jLabel1.setText("Image");
        mainLeft.add(jLabel1);

        LEFT.add(mainLeft, java.awt.BorderLayout.CENTER);

        secondLeft.setLayout(new java.awt.GridLayout(1, 1));

        cancel.setText("Annuler");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        secondLeft.add(cancel);

        LEFT.add(secondLeft, java.awt.BorderLayout.SOUTH);

        CENTER.add(LEFT);

        RIGHT.setLayout(new java.awt.BorderLayout());

        mainRigth.setLayout(new java.awt.GridLayout(4, 1));
        mainRigth.add(zonePseudo);

        paneColor.setLayout(new java.awt.GridLayout(1, 2));

        buttonCouleur.setText("Choisir couleur");
        buttonCouleur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCouleurActionPerformed(evt);
            }
        });
        paneColor.add(buttonCouleur);

        zoneCouleur.setEditable(false);
        zoneCouleur.setFocusable(false);
        paneColor.add(zoneCouleur);

        mainRigth.add(paneColor);

        zoneSolde.setText("20.0 €");
        mainRigth.add(zoneSolde);

        paneFile.setLayout(new java.awt.GridLayout(1, 2));

        buttonFile.setText("Choisir une image");
        buttonFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFileActionPerformed(evt);
            }
        });
        paneFile.add(buttonFile);

        mainRigth.add(paneFile);

        RIGHT.add(mainRigth, java.awt.BorderLayout.CENTER);

        secondRigth.setLayout(new java.awt.GridLayout(1, 0));

        valider.setText("Valider");
        valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validerActionPerformed(evt);
            }
        });
        secondRigth.add(valider);

        RIGHT.add(secondRigth, java.awt.BorderLayout.SOUTH);

        CENTER.add(RIGHT);

        getContentPane().add(CENTER, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void validerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validerActionPerformed
        PanneauImage tmp = (PanneauImage) paneFile.getComponent(1);
        this.OK = true;
        dispose();
    }//GEN-LAST:event_validerActionPerformed

    private void buttonCouleurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCouleurActionPerformed
        //Genère un objet de type JColorChooser
        JColorChooser windowColor = new JColorChooser();
        //Ouvre la JColorhooser et retourne la couleur choisi
        Color col = windowColor.showDialog(this, "Couleur", Color.black);
        zoneCouleur.setBackground(col);
        this.couleur = col;


    }//GEN-LAST:event_buttonCouleurActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        this.OK = false;
        dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void buttonFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFileActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setMultiSelectionEnabled(false);
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { // Si le fichier retourné est conforme
            String path = fc.getSelectedFile().getPath(); // chemin complet; 

            Image img = Toolkit.getDefaultToolkit().getImage(path);
            ImageIcon pic = new ImageIcon(img);
            this.photo = pic;
            PanneauImage zoneImage = (PanneauImage) paneFile.getComponent(1);
            zoneImage.setImage(pic);
        }
    }//GEN-LAST:event_buttonFileActionPerformed

    public String getPseudo() {
        return zonePseudo.getText();
    }

    public Color getCouleur() {
        return this.couleur;
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
            java.util.logging.Logger.getLogger(AjoutJoueurDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjoutJoueurDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjoutJoueurDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjoutJoueurDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AjoutJoueurDlg dialog = new AjoutJoueurDlg(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel LEFT;
    private javax.swing.JLabel LabelCouleur;
    private javax.swing.JPanel NORTH;
    private javax.swing.JPanel RIGHT;
    private javax.swing.JButton buttonCouleur;
    private javax.swing.JButton buttonFile;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel mainLeft;
    private javax.swing.JPanel mainRigth;
    private javax.swing.JPanel paneColor;
    private javax.swing.JPanel paneFile;
    private javax.swing.JLabel pseudo;
    private javax.swing.JPanel secondLeft;
    private javax.swing.JPanel secondRigth;
    private javax.swing.JLabel solde;
    private javax.swing.JLabel title;
    private javax.swing.JButton valider;
    private javax.swing.JTextField zoneCouleur;
    private javax.swing.JTextField zonePseudo;
    private javax.swing.JLabel zoneSolde;
    // End of variables declaration//GEN-END:variables
}
