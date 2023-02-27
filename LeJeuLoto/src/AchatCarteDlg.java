
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;


public class AchatCarteDlg extends javax.swing.JDialog {

    private int parameters []; //type de jeu, NbCol, nbNum
    private LesJoueurs ljc; // Liste des joueurs entré en parametres du constructeur
    private Joueur jc; // Joueur en focus
    private CarteLoto cc; // Carte actuel
    private boolean achat; //Est ce qu'un joueur au moins a acheté 
    
    public AchatCarteDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public AchatCarteDlg(java.awt.Frame parent, boolean modal, int parameters[], LesJoueurs joueurs) {
        super(parent, modal);
        initComponents();
        this.parameters = parameters;
        this.ljc=joueurs;
        initListeJoueurs();
        this.achat=false;
        this.cc=new CarteLoto();
        majMsg();
        initCarte(); // Contient Creer ET affiche une carte
    }

    //Construit la JComboBox selon les joueurs entré en parametres
    private void initListeJoueurs(){
        for(int i =0;i<this.ljc.getNbJoueurs();i++){
            ListeJoueurs.addItem(this.ljc.getJoueur(i).getPseudo());
        }
    }
    //Mes a jour le message qui informe sur quel joueur on est et l'argent don il dispose
    private void majMsg(){
        this.jc = this.ljc.getJoueur(ListeJoueurs.getSelectedIndex());
        msgSolde.setText(jc.getPseudo()+" dipose de "+jc.getSolde()+"€");
    }
    //Retourne la valeur de this.achat
    public boolean getAchat(){
        return this.achat;
    }
    
    //Génère une nouvelle carte et l'affiche
    private void initCarte(){
        CENTER.removeAll();
        CENTER.setLayout(new GridLayout(3,this.parameters[1]));
        this.cc = new CarteLoto(this.parameters[1],this.parameters[2]);
        for(int i = 0; i<cc.getNbLig();i++){
            for(int j = 0; j<this.parameters[1];j++){
                JButton bouton;
                if(cc.getCase(i,j)==0){
                    bouton= new JButton("");
                } else {
                    bouton= new JButton(""+this.cc.getCase(i,j));
                }
                CENTER.add(bouton);
            }
        }
        CENTER.revalidate();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NORTH = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        CENTER = new javax.swing.JPanel();
        SOUTH = new javax.swing.JPanel();
        North = new javax.swing.JPanel();
        msgSolde = new javax.swing.JLabel();
        South = new javax.swing.JPanel();
        ListeJoueurs = new javax.swing.JComboBox<>();
        autreChoix = new javax.swing.JButton();
        Achat = new javax.swing.JButton();
        Quitter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Acheter une ou plusieurs cartes");
        NORTH.add(jLabel1);

        getContentPane().add(NORTH, java.awt.BorderLayout.NORTH);

        javax.swing.GroupLayout CENTERLayout = new javax.swing.GroupLayout(CENTER);
        CENTER.setLayout(CENTERLayout);
        CENTERLayout.setHorizontalGroup(
            CENTERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        CENTERLayout.setVerticalGroup(
            CENTERLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 229, Short.MAX_VALUE)
        );

        getContentPane().add(CENTER, java.awt.BorderLayout.CENTER);

        SOUTH.setLayout(new java.awt.BorderLayout());

        msgSolde.setText("Solde");
        North.add(msgSolde);

        SOUTH.add(North, java.awt.BorderLayout.NORTH);

        South.setLayout(new java.awt.GridLayout(1, 4));

        ListeJoueurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListeJoueursActionPerformed(evt);
            }
        });
        South.add(ListeJoueurs);

        autreChoix.setText("Autre choix");
        autreChoix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autreChoixActionPerformed(evt);
            }
        });
        South.add(autreChoix);

        Achat.setText("Acheter");
        Achat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AchatActionPerformed(evt);
            }
        });
        South.add(Achat);

        Quitter.setText("Quitter");
        Quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitterActionPerformed(evt);
            }
        });
        South.add(Quitter);

        SOUTH.add(South, java.awt.BorderLayout.SOUTH);

        getContentPane().add(SOUTH, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Retourne la carte actuelle. Pour l'achat.
    public CarteLoto getCc(){
        return this.cc;
    }
    
    private void ListeJoueursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListeJoueursActionPerformed
        majMsg();
        Achat.setBackground(Quitter.getBackground());
        autreChoix.setBackground(Quitter.getBackground());
    }//GEN-LAST:event_ListeJoueursActionPerformed

    private void autreChoixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autreChoixActionPerformed
        this.jc= this.ljc.getJoueur(ListeJoueurs.getSelectedIndex());
        if(this.jc.retirSolde(1)){
            initCarte();
            autreChoix.setBackground(Color.green);
            majMsg();
        } else {
            autreChoix.setBackground(Color.red);
        }
        
        Achat.setBackground(Quitter.getBackground());
    }//GEN-LAST:event_autreChoixActionPerformed

    private void AchatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AchatActionPerformed
        this.jc= this.ljc.getJoueur(ListeJoueurs.getSelectedIndex());
        if(this.jc.acheter(this.cc)){
            Achat.setBackground(Color.green);
            this.achat=true;
            initCarte();
        } else {
            Achat.setBackground(Color.red);
        }
        autreChoix.setBackground(Quitter.getBackground());
        majMsg();
    }//GEN-LAST:event_AchatActionPerformed

    private void QuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitterActionPerformed
       dispose();
    }//GEN-LAST:event_QuitterActionPerformed

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
            java.util.logging.Logger.getLogger(AchatCarteDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AchatCarteDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AchatCarteDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AchatCarteDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AchatCarteDlg dialog = new AchatCarteDlg(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton Achat;
    private javax.swing.JPanel CENTER;
    private javax.swing.JComboBox<String> ListeJoueurs;
    private javax.swing.JPanel NORTH;
    private javax.swing.JPanel North;
    private javax.swing.JButton Quitter;
    private javax.swing.JPanel SOUTH;
    private javax.swing.JPanel South;
    private javax.swing.JButton autreChoix;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel msgSolde;
    // End of variables declaration//GEN-END:variables
}
