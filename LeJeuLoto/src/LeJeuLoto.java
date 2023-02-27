
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class LeJeuLoto extends javax.swing.JFrame {

    LesJoueurs lstJ = new LesJoueurs();
    LesCartes lstC = new LesCartes();
    LesJoueurs gagnant = new LesJoueurs();
    Joueur leGagnant = new Joueur();
    
    LesLots lstL = new LesLots();
    
    LesLots lstL1 = new LesLots();
    LesLots lstL2 = new LesLots();
    LesLots lstL3 = new LesLots();
    
    int boules[] = new int[90]; //Table des nombres tirés
    
    int parametres[] = {1, 5, 4};// ChoixOpt, nbCol, nbNum
    

    public LeJeuLoto() {
        initComponents();
        initJoueurs();
        initLots();
        editOptions(false);
    }

    // Va ajouter deux joueurs à lstJ pour les tests
    public void initJoueurs() {
        lstJ.ajoutJoueur(new Joueur("Adam", Color.red, 20,null));
        lstJ.ajoutJoueur(new Joueur("Eva", Color.blue, 20, null));
        initBoules();
        redrawButtons();
    }

    //Initialise les boules a 0. Necessaire pou rle bon fonctionnement du tirage.
    public void initBoules() {
        for (int i = 0; i < boules.length; i++) {
            boules[i] = 0;
        }
    }

    //Initialise les lots. Les lots ne contiennes que des coupons
    public void initLots() {
        this.lstL.ajoutLot(new Lot("Coupon cadeau Carrefour", true, 1, 12.29));
        this.lstL.ajoutLot(new Lot("Coupon cadeau Boulanger", true, 2, 13));
        this.lstL.ajoutLot(new Lot("Coupon cadeau MomieManga", true, 3, 15.99));
        this.lstL.ajoutLot(new Lot("Coupon cadeau Lidl", true, 1, 10.99));
        this.lstL.ajoutLot(new Lot("Coupon cadeau Electro Depot", true, 2, 15));
        this.lstL.ajoutLot(new Lot("Coupon cadeau Saveur d'Asie", true, 3, 21.90));
        this.lstL.ajoutLot(new Lot("Coupon cadeau Fit & Food", true, 1, 9.75));
        this.lstL.ajoutLot(new Lot("Coupon cadeau Soins beauté", true, 2, 15.70));
        this.lstL.ajoutLot(new Lot("Coupon cadeau Bouchara", true, 3, 35.99));
    }

    //Tire une boule, verifie son état. Va vérifie a chaque fois s'il y a un gagnant. Modifiera l'interface selon les cas.
    public int tireBoule() {
        boolean flag = true;
        int numTire = 0;
        do {
            flag = false;
            numTire = 1 + (int) (Math.random() * ((90 - 1) + 1));
            for (int i = 0; i < boules.length; i++) {
                if (boules[i] == numTire) {
                    flag = true;
                }
                if (boules[i + 1] == 0) {
                    i = boules.length;
                }
            }
        } while (flag);
        return numTire;
    }

    //Redessine les boutons de joueurs. (Efface et refait les boutons selon les informations du joueur
    public void redrawButtons() {
        EAST.removeAll(); // Retire tous les boutons precédant
        int i;

        //Recréer un bouton abonné à un écouteur par joueur
        for (i = 0; i < lstJ.getNbJoueurs(); i++) {
            Joueur jx = lstJ.getJoueur(i);
            JButton bouton = new JButton();
            bouton.setText(jx.getPseudo());
            bouton.setBackground(jx.getCouleur());
            bouton.setName(("" + i));
            //Abonnement a un listener
            bouton.addActionListener(new java.awt.event.ActionListener() {
                //Ce qui doit s'activer lorsque le listener est activé
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    //Lance la méthode "butonActionPerformed" qui doit être crée manuellement
                    boutonActionPerformed(evt);
                }
            });
            EAST.add(bouton);
        }

        //Complète par des bouttons de remplissage s'il y a moins de 4 joueurs
        while (i < 4) {
            JButton bouton = new JButton();
            bouton.setText("Joueur" + (i + 1));
            bouton.setName(("" + i));
            EAST.add(bouton);
            i++;
        }
        EAST.revalidate(); // Va actualiser l'affichage de EAST
    }

    // Evenement sur boutons joueurs. Affiche les informations du joueur via VisuJoueur
    public void boutonActionPerformed(java.awt.event.ActionEvent evt) {
        JButton focus = (JButton) evt.getSource();
        Joueur J = lstJ.getJoueur(Integer.parseInt(focus.getName()));
        VisuJoueurDlg windowJoueur = new VisuJoueurDlg(this, true, J);
        windowJoueur.setVisible(true);
        redrawButtons();
    }

    public String getTypeJeu() {
        switch (parametres[0]) {
            case 1:
                return "Quinte - Une ligne complète";
            case 2:
                return "Double Quinte - Deux complètes";
            case 3:
                return "Carton plein - Trois lignes complètes";
            default:
                return "Erreur - GetTypeJeu";
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NORTH = new javax.swing.JPanel();
        northText = new javax.swing.JLabel();
        LesCartons = new javax.swing.JPanel();
        Pane1 = new javax.swing.JPanel();
        Pane2 = new javax.swing.JPanel();
        Pane3 = new javax.swing.JPanel();
        Pane4 = new javax.swing.JPanel();
        Pane5 = new javax.swing.JPanel();
        Pane6 = new javax.swing.JPanel();
        Pane7 = new javax.swing.JPanel();
        Pane8 = new javax.swing.JPanel();
        EAST = new javax.swing.JPanel();
        SOUTH = new javax.swing.JPanel();
        southNorth = new javax.swing.JPanel();
        zoneMsgLot = new javax.swing.JLabel();
        southSouth = new javax.swing.JPanel();
        southTop = new javax.swing.JPanel();
        zoneMsgHist = new javax.swing.JLabel();
        zoneOptionChoisie = new javax.swing.JLabel();
        southBottom = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        historiqueBoules = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        Tirage = new javax.swing.JButton();
        zoneNumTiree = new javax.swing.JLabel();
        closeButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        add = new javax.swing.JMenu();
        addPlayer = new javax.swing.JMenuItem();
        addGift = new javax.swing.JMenuItem();
        action = new javax.swing.JMenu();
        gameOptions = new javax.swing.JMenuItem();
        startGame = new javax.swing.JMenuItem();
        buyCards = new javax.swing.JMenuItem();
        proceed = new javax.swing.JMenuItem();
        restart = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 400));

        northText.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        northText.setText("Voici les cartes don vous disposez");
        NORTH.add(northText);

        getContentPane().add(NORTH, java.awt.BorderLayout.NORTH);

        LesCartons.setLayout(new java.awt.GridLayout(4, 2));

        Pane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout Pane1Layout = new javax.swing.GroupLayout(Pane1);
        Pane1.setLayout(Pane1Layout);
        Pane1Layout.setHorizontalGroup(
            Pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 303, Short.MAX_VALUE)
        );
        Pane1Layout.setVerticalGroup(
            Pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        LesCartons.add(Pane1);

        Pane2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout Pane2Layout = new javax.swing.GroupLayout(Pane2);
        Pane2.setLayout(Pane2Layout);
        Pane2Layout.setHorizontalGroup(
            Pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 303, Short.MAX_VALUE)
        );
        Pane2Layout.setVerticalGroup(
            Pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        LesCartons.add(Pane2);

        Pane3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout Pane3Layout = new javax.swing.GroupLayout(Pane3);
        Pane3.setLayout(Pane3Layout);
        Pane3Layout.setHorizontalGroup(
            Pane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 303, Short.MAX_VALUE)
        );
        Pane3Layout.setVerticalGroup(
            Pane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        LesCartons.add(Pane3);

        Pane4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout Pane4Layout = new javax.swing.GroupLayout(Pane4);
        Pane4.setLayout(Pane4Layout);
        Pane4Layout.setHorizontalGroup(
            Pane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 303, Short.MAX_VALUE)
        );
        Pane4Layout.setVerticalGroup(
            Pane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        LesCartons.add(Pane4);

        Pane5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout Pane5Layout = new javax.swing.GroupLayout(Pane5);
        Pane5.setLayout(Pane5Layout);
        Pane5Layout.setHorizontalGroup(
            Pane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 303, Short.MAX_VALUE)
        );
        Pane5Layout.setVerticalGroup(
            Pane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        LesCartons.add(Pane5);

        Pane6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout Pane6Layout = new javax.swing.GroupLayout(Pane6);
        Pane6.setLayout(Pane6Layout);
        Pane6Layout.setHorizontalGroup(
            Pane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 303, Short.MAX_VALUE)
        );
        Pane6Layout.setVerticalGroup(
            Pane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        LesCartons.add(Pane6);

        Pane7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout Pane7Layout = new javax.swing.GroupLayout(Pane7);
        Pane7.setLayout(Pane7Layout);
        Pane7Layout.setHorizontalGroup(
            Pane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 303, Short.MAX_VALUE)
        );
        Pane7Layout.setVerticalGroup(
            Pane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        LesCartons.add(Pane7);

        Pane8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout Pane8Layout = new javax.swing.GroupLayout(Pane8);
        Pane8.setLayout(Pane8Layout);
        Pane8Layout.setHorizontalGroup(
            Pane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 303, Short.MAX_VALUE)
        );
        Pane8Layout.setVerticalGroup(
            Pane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        LesCartons.add(Pane8);

        getContentPane().add(LesCartons, java.awt.BorderLayout.CENTER);

        EAST.setLayout(new java.awt.GridLayout(4, 1));
        getContentPane().add(EAST, java.awt.BorderLayout.EAST);

        SOUTH.setLayout(new java.awt.BorderLayout());

        zoneMsgLot.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        zoneMsgLot.setText("Cadeau :");
        southNorth.add(zoneMsgLot);

        SOUTH.add(southNorth, java.awt.BorderLayout.NORTH);

        southSouth.setLayout(new java.awt.BorderLayout());

        southTop.setLayout(new java.awt.GridLayout(1, 2));

        zoneMsgHist.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        zoneMsgHist.setText("Historique du tirage des boules");
        southTop.add(zoneMsgHist);

        zoneOptionChoisie.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        zoneOptionChoisie.setText("Option choisie :");
        southTop.add(zoneOptionChoisie);

        southSouth.add(southTop, java.awt.BorderLayout.NORTH);

        southBottom.setLayout(new java.awt.GridLayout(1, 2));

        historiqueBoules.setEditable(false);
        historiqueBoules.setColumns(20);
        historiqueBoules.setLineWrap(true);
        historiqueBoules.setRows(5);
        historiqueBoules.setAutoscrolls(false);
        jScrollPane1.setViewportView(historiqueBoules);

        southBottom.add(jScrollPane1);

        jPanel4.setLayout(new java.awt.GridLayout(1, 3));

        Tirage.setText("Tirage");
        Tirage.setEnabled(false);
        Tirage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TirageActionPerformed(evt);
            }
        });
        jPanel4.add(Tirage);

        zoneNumTiree.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        zoneNumTiree.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(zoneNumTiree);

        closeButton.setText("Arrêter");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        jPanel4.add(closeButton);

        southBottom.add(jPanel4);

        southSouth.add(southBottom, java.awt.BorderLayout.CENTER);

        SOUTH.add(southSouth, java.awt.BorderLayout.SOUTH);

        getContentPane().add(SOUTH, java.awt.BorderLayout.SOUTH);

        add.setText("Ajout");

        addPlayer.setText("Joueur");
        addPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlayerActionPerformed(evt);
            }
        });
        add.add(addPlayer);

        addGift.setText("Lot");
        addGift.setEnabled(false);
        add.add(addGift);

        jMenuBar1.add(add);

        action.setText("Action");

        gameOptions.setText("Option jeu");
        gameOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameOptionsActionPerformed(evt);
            }
        });
        action.add(gameOptions);

        startGame.setText("Démarrer Jeu");
        startGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startGameActionPerformed(evt);
            }
        });
        action.add(startGame);

        buyCards.setText("Acheter cartes");
        buyCards.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyCardsActionPerformed(evt);
            }
        });
        action.add(buyCards);

        proceed.setText("Continuer");
        proceed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proceedActionPerformed(evt);
            }
        });
        action.add(proceed);

        restart.setText("Recommencer");
        restart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartActionPerformed(evt);
            }
        });
        action.add(restart);

        jMenuBar1.add(action);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPlayerActionPerformed
        if (lstJ.getNbJoueurs() < 4) {
            AjoutJoueurDlg windowJoueur = new AjoutJoueurDlg(this, true, lstJ); // Liste des joueurs en parametres
            windowJoueur.setVisible(true);
            if (windowJoueur.getOK()) {
                //Créer le joueur et l'ajoute ) lstJ
                Joueur j = new Joueur(windowJoueur.getPseudo(), windowJoueur.getCouleur(), 20, windowJoueur.getPhoto());
                lstJ.ajoutJoueur(j);
            }
            redrawButtons();
        }
    }//GEN-LAST:event_addPlayerActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    private void gameOptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gameOptionsActionPerformed
        if (lstC.getTaille() > 0) {
            editOptions(true);
        } else {
            editOptions(false);
        }
    }//GEN-LAST:event_gameOptionsActionPerformed

    private void buyCardsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyCardsActionPerformed
        if (lstJ.getNbJoueurs() > 0) {
            AchatCarteDlg achatDlg = new AchatCarteDlg(this, true, this.parametres, this.lstJ);
            achatDlg.setVisible(true);
            if (achatDlg.getAchat()) {
                this.lstC.ajouteCarte(achatDlg.getCc());
                afficheCarte();
                gameOptions.setEnabled(false);
            }
        }
    }//GEN-LAST:event_buyCardsActionPerformed

    private void startGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startGameActionPerformed
        boolean check = true;
        for (int i = 0; i < this.lstJ.getNbJoueurs(); i++) {
            if (lstJ.getJoueur(i).getMesCartes().getTaille() == 0) {
                check = false;
            }
        }
        if (check) {
            Tirage.setEnabled(true);
            buyCards.setEnabled(false);
            addPlayer.setEnabled(false);
        }
    }//GEN-LAST:event_startGameActionPerformed
    // J'aurais dus découper ces 90 lignes en plusieurs sous méthodes pour la propreté
    private void TirageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TirageActionPerformed
        int i = -1;
        boolean flag = true; //Drapeau pour savoir si on est sur une case non utilisé (==0)
        boolean flagG = false; //Drapeau pour tester s'il y a un gagnant
        String mes = "";
        //flag sert a arrêter manuellement lorsque on a trouvé. i<90 arrête quand on est en bout de liste.
        //Tire un numero et l'ajoute dans la liste des tirages
        while (flag && i < (boules.length - 1)) {
            i++;
            if (boules[i] == 0) {
                boules[i] = tireBoule();
                flag = false; //Sort de la boucle.
            }
            historiqueBoules.setText(mes + boules[i] + " - ");
            zoneNumTiree.setText("" + boules[i]);
            mes = historiqueBoules.getText();
        }

        //Si l'on a pas tiré de boule
        if (flag) {
            zoneMsgLot.setText("Vous avez tiré : " + boules.length + " boules. \nIl n'y a plus de boule a tirer.");
            pause();
            proceed.setEnabled(false);
        }

        //Est ce qu'un joueur possède le numéro si oui leve flag et place le pion
        for (int j = 0; j < lstJ.getNbJoueurs(); j++) {
            LesCartes cartesJ = lstJ.getJoueur(j).getMesCartes();
            
            //Selon le nombre de carte du joueur (1 ou 2)
            if (cartesJ.getTaille() == 1) {
                if (cartesJ.getCarte(0).contient(boules[i])) {
                    cartesJ.getCarte(0).placePion(boules[i]);
                    flagG = true;
                }

            } else if (cartesJ.getTaille() == 2) {
                if (cartesJ.getCarte(0).contient(boules[i])) {
                    cartesJ.getCarte(0).placePion(boules[i]);
                    flagG = true;
                } else if (cartesJ.getCarte(1).contient(boules[i])) {
                    cartesJ.getCarte(1).placePion(boules[i]);
                    flagG = true;
                }

            }
        }

        //Locasile les boutons avec le numéro tiré et les grises
        for (int j = 0; j < lstJ.getNbJoueurs() * 2; j++) {
            LesCartes cartesJ = lstJ.getJoueur(j / 2).getMesCartes();
            if (j < 2) {
                if (cartesJ.getTaille() == 1) {
                    isInPanel(Pane1, boules[i]);
                } else if (cartesJ.getTaille() == 2) {
                    isInPanel(Pane1, boules[i]);
                    isInPanel(Pane2, boules[i]);
                }
            } else if (j < 4) {
                if (cartesJ.getTaille() == 1) {
                    isInPanel(Pane3, boules[i]);
                } else if (cartesJ.getTaille() == 2) {
                    isInPanel(Pane3, boules[i]);
                    isInPanel(Pane4, boules[i]);
                }
            } else if (j < 6) {
                if (cartesJ.getTaille() == 1) {
                    isInPanel(Pane5, boules[i]);
                } else if (cartesJ.getTaille() == 2) {
                    isInPanel(Pane5, boules[i]);
                    isInPanel(Pane6, boules[i]);
                }
            } else {
                if (cartesJ.getTaille() == 1) {
                    isInPanel(Pane7, boules[i]);
                } else if (cartesJ.getTaille() == 2) {
                    isInPanel(Pane7, boules[i]);
                    isInPanel(Pane8, boules[i]);
                }
            }
        }

        //Si un joueur possède le numero, vérifie les gagnants
        if (flagG) {
            if (isGagnant()) {
                winnerIs();
            }
        }

    }//GEN-LAST:event_TirageActionPerformed
    //Decide du gagnant
    public void winnerIs() {
        //Si plus d'un joueur
        if (this.gagnant.getNbJoueurs() > 1) {
            int rand = (int) (Math.random() * ((gagnant.getNbJoueurs())));;
            this.leGagnant = gagnant.getJoueur(rand);
            zoneNumTiree.setText(this.leGagnant.getPseudo());
            jPanel4.setBackground(this.leGagnant.getCouleur());
            leGagnant.gagneLot(choixLot(), zoneMsgLot);
            pause();
        } else if (this.gagnant.getNbJoueurs() == 1) {
            this.leGagnant = gagnant.getJoueur(0);
            zoneNumTiree.setText(this.leGagnant.getPseudo());
            jPanel4.setBackground(this.leGagnant.getCouleur());
            leGagnant.gagneLot(choixLot(), zoneMsgLot);
            pause();
        }
    }

    //Choix du lot. Renvoie le lot en question et le retir des listL et listLx
    public Lot choixLot() {
        Lot toReturn = new Lot();

        for (int i = 0; i < lstL.getTaille(); i++) {

            //Range les Lots dans 3 LesLots selon le niveau (1,2,3)
            switch (lstL.getLot(i).getNiveau()) {
                case 1:
                    this.lstL1.ajoutLot(lstL.getLot(i));
                    break;
                case 2:
                    this.lstL2.ajoutLot(lstL.getLot(i));
                    break;
                case 3:
                    this.lstL3.ajoutLot(lstL.getLot(i));
                    break;
            }
        }
        //Tire un lot au hasard selon le parametres[0]
        switch (parametres[0]) {
            case 1:
                if (lstL1.getTaille() == 0) {
                    return null;
                }
                int rand = (int) Math.random() * lstL1.getTaille();
                toReturn = lstL1.getLot(rand);
                lstL.retirLot(toReturn);
                lstL1.retirLot(toReturn);
                break;
            case 2:
                if (lstL2.getTaille() == 0) {
                    return null;
                }
                rand = (int) Math.random() * lstL1.getTaille();
                toReturn = lstL2.getLot(rand);
                lstL.retirLot(toReturn);
                lstL2.retirLot(toReturn);
                break;
            case 3:
                if (lstL3.getTaille() == 0) {
                    return null;
                }
                rand = (int) Math.random() * lstL1.getTaille();
                toReturn = lstL3.getLot((int) Math.random() * lstL1.getTaille());
                lstL.retirLot(toReturn);
                lstL3.retirLot(toReturn);
                break;
        }
        //Affiche le lot tiré
        zoneMsgLot.setText(toReturn.getLabel() + " : " + toReturn.getValeur() + "€");
        return toReturn;
    }
    private void restartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartActionPerformed

        //Nettoie les cartes
        for (int i = 0; i < lstJ.getNbJoueurs() * 2; i++) {
            JPanel Jclean = (JPanel) LesCartons.getComponent(i);
            Jclean.removeAll();
        }
        for (int i = 0; i < lstJ.getNbJoueurs(); i++) {
            lstJ.getJoueur(i).getMesC().videCartes();
        }
        lstC.videCartes();
        gagnant.clean();
        historiqueBoules.setText("");
        jPanel4.setBackground(southNorth.getBackground());
        gameOptions.setEnabled(true);
        startGame.setEnabled(true);
        buyCards.setEnabled(true);
        addPlayer.setEnabled(true);
        videBoules();
    }//GEN-LAST:event_restartActionPerformed

    //Reinitialise toutes les boules[] a 0
    public void videBoules() {
        for (int i = 0; i < boules.length; i++) {
            boules[i] = 0;
        }
    }

    //Retir les cartons gagnant de la main du joueur
    private void proceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proceedActionPerformed
        leGagnant.tradWinCard(parametres);
        gagnant.clean();
        jPanel4.setBackground(southNorth.getBackground());
        Tirage.setEnabled(true);
    }//GEN-LAST:event_proceedActionPerformed

    //Met le jeu en pause et bloque certaines fonctions
    private void pause() {
        gameOptions.setEnabled(false);
        startGame.setEnabled(false);
        buyCards.setEnabled(false);
        addPlayer.setEnabled(false);
        addGift.setEnabled(false);
        Tirage.setEnabled(false);
        proceed.setEnabled(true);
        restart.setEnabled(true);
    }

    //Stock les gagants dans l'array liste retourne false s'il n'y a pas de gagant
    private boolean isGagnant() {
        for (int i = 0; i < lstJ.getNbJoueurs(); i++) {
            LesCartes cartesJ = lstJ.getJoueur(i).getMesCartes();
            switch (cartesJ.getTaille()) {
                case 1:
                    if (cartesJ.getCarte(0).cartonGagnant(parametres[0])) {
                        gagnant.ajoutJoueur(lstJ.getJoueur(i));
                        return true;
                    }
                    break;
                case 2:
                    if (cartesJ.getCarte(0).cartonGagnant(parametres[0]) || cartesJ.getCarte(1).cartonGagnant(parametres[0])) {
                        gagnant.ajoutJoueur(lstJ.getJoueur(i));
                        return true;
                    }
                    break;
            }

        }
        return false;
    }

    //Va afficher les cartes dans le panneau LesCartons
    private void afficheCarte() {
        int i = 0;
        for (int j = 0; j < lstJ.getNbJoueurs(); j++) {
            Joueur jf = lstJ.getJoueur(j);
            int nbCarte = jf.getMesCartes().getTaille();
            JPanel jp;
            switch (nbCarte) {
                case 0:
                    i += 2;
                    break;
                case 1:
                    jp = (JPanel) LesCartons.getComponent(i);
                    jf.getMesCartes().getCarte(0).dessineCarte(jp, jf.getCouleur());
                    i += 2;
                    break;
                case 2:
                    jp = (JPanel) LesCartons.getComponent(i);
                    jf.getMesCartes().getCarte(0).dessineCarte(jp, jf.getCouleur());
                    i++;
                    jp = (JPanel) LesCartons.getComponent(i);
                    jf.getMesCartes().getCarte(1).dessineCarte(jp, jf.getCouleur());
                    i++;
                    break;
            }
        }
    }

    //Va chercher si la valIn correspond a un bouton dans le panneau. Si oui le grise et renvie true. note : Redondant ?
    public boolean isInPanel(JPanel pane, int valIn) {
        for (int i = 0; i < (parametres[1] * 3); i++) {
            JButton btmp = (JButton) pane.getComponent(i);
            String val = String.valueOf(valIn);
            if (btmp.getText().equals(val)) {
                btmp.setEnabled(false);
            }
        }
        return false;
    }

    //Ouvre la fenetre des options et actualise parametres[] si besoin.
    private void editOptions(boolean isLimited) {
        OptionDlg option = new OptionDlg(this, true, isLimited, parametres);
        option.setVisible(true);
        this.parametres[0] = option.getChoixOpt();
        this.parametres[1] = option.getNbCol();
        this.parametres[2] = option.getNbNum();
        switch (parametres[0]) {
            case 1:
                System.out.println("Option Choisie : Quinte");
                zoneOptionChoisie.setText("Option Choisie : " + getTypeJeu());
                break;
            case 2:
                System.out.println("Option Choisie : Double Quinte");
                zoneOptionChoisie.setText("Option Choisie : " + getTypeJeu());
                break;
            case 3:
                System.out.println("Option Choisie : Carton plein");
                zoneOptionChoisie.setText("Option Choisie : " + getTypeJeu());
                break;
            default:
                System.out.println("Erreur editOptions");
        }

    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LeJeuLoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LeJeuLoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LeJeuLoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LeJeuLoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LeJeuLoto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel EAST;
    private javax.swing.JPanel LesCartons;
    private javax.swing.JPanel NORTH;
    private javax.swing.JPanel Pane1;
    private javax.swing.JPanel Pane2;
    private javax.swing.JPanel Pane3;
    private javax.swing.JPanel Pane4;
    private javax.swing.JPanel Pane5;
    private javax.swing.JPanel Pane6;
    private javax.swing.JPanel Pane7;
    private javax.swing.JPanel Pane8;
    private javax.swing.JPanel SOUTH;
    private javax.swing.JButton Tirage;
    private javax.swing.JMenu action;
    private javax.swing.JMenu add;
    private javax.swing.JMenuItem addGift;
    private javax.swing.JMenuItem addPlayer;
    private javax.swing.JMenuItem buyCards;
    private javax.swing.JButton closeButton;
    private javax.swing.JMenuItem gameOptions;
    private javax.swing.JTextArea historiqueBoules;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel northText;
    private javax.swing.JMenuItem proceed;
    private javax.swing.JMenuItem restart;
    private javax.swing.JPanel southBottom;
    private javax.swing.JPanel southNorth;
    private javax.swing.JPanel southSouth;
    private javax.swing.JPanel southTop;
    private javax.swing.JMenuItem startGame;
    private javax.swing.JLabel zoneMsgHist;
    private javax.swing.JLabel zoneMsgLot;
    private javax.swing.JLabel zoneNumTiree;
    private javax.swing.JLabel zoneOptionChoisie;
    // End of variables declaration//GEN-END:variables
}
