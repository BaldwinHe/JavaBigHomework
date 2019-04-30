/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catchtigerchess;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import mouseclick.ChessClick;
import javax.swing.JProgressBar;
import java.awt.Image;
import javax.swing.JLabel;
import java.awt.image.BufferedImage;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;
import javax.swing.Timer;
/**
 *
 * @author heyanbai
 */
public class ChessWindow extends JFrame {
    
    public static ChessBoarder chessBoarder;
    private static String PlayerNow;
    private static ImageIcon TIGERMOVE;
    private static ImageIcon DOGMOVE;
    ChessBoardCanvas chessCanvas;
    Timer timer;
    
    /**
     * Creates new form ChessWindow
     */
    public ChessWindow(int totalTime) {
        initComponents();
        //System.err.println(this.getClass().getResource("..").getPath());
        TIGERMOVE = new javax.swing.ImageIcon(getClass().getResource("/images/TIGERMOVE.png"));
        DOGMOVE = new javax.swing.ImageIcon(getClass().getResource("/images/DOGMOVE.png"));

        PlayerNow = new String("Tiger");
        chessBoarder = new ChessBoarder();
        
        this.setTitle("CatchTigerChess");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        timeLeftBar.setMinimum(0);
        if (totalTime < 0) {
            timeLeftBar.setMaximum(100000000);
            totalTime = 100000000;
        }else{
            timeLeftBar.setMaximum(totalTime*60*1000);
        }
        timer = new Timer(totalTime, new ActionListener() {
            int counter = 1;
            @Override
            public void actionPerformed(ActionEvent ae) {
                timeLeftBar.setValue(++counter);
            }
        });
        timer.start();
        chessCanvas = new ChessBoardCanvas();
        chessCanvas.setBounds(0, 0, 500, 700);
        chessCanvas.repaint();
        chessCanvas.addMouseListener(new ChessClick());
        gameBoard.add(chessCanvas);
        
    }
    public static void setGameStatus(String status){
        if(status.equals("TIGERMOVE")){
            System.out.println("??");
            gameStatusImage.setIcon(TIGERMOVE);
            gameStatusText.setText("<html><font color=\"94A7DC\" size=\"6\" face=\"Gill Sans\">The </font><font color=\"#EFCAC2\" size=\"7\" face=\"Gill Sans\">tiger</font><font color=\"94A7DC\" size=\"6\" face=\"Gill Sans\"> is ready to move !</font></html>");
        }
        if(status.equals("DOGMOVE")){
            System.err.println("!!");
            gameStatusImage.setIcon(DOGMOVE);
            gameStatusText.setText("<html><font color=\"94A7DC\" size=\"6\" face=\"Gill Sans\">The </font><font color=\"#EFCAC2\" size=\"7\" face=\"Gill Sans\">dogs</font><font color=\"94A7DC\" size=\"6\" face=\"Gill Sans\"> are ready to move !</font></html>");
        }
    }
    public static void setPlayer(){
        System.out.println(PlayerNow);
        if(PlayerNow.equals("Tiger")){
            PlayerNow = "Dog";
            setGameStatus("DOGMOVE");
        }
        else {
            PlayerNow = "Tiger";
            setGameStatus("TIGERMOVE");
        }
    }
    public static String getPlayer(){
        return PlayerNow;
    }
    public static ChessPieces[][] getChessPieces(){
        return chessBoarder.getChessPieces();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gameBoard = new JPanel();
        gameStatus = new javax.swing.JPanel();
        gameStatusImage = new javax.swing.JLabel();
        gameStatusText = new javax.swing.JLabel();
        timeLeftBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        gameBoard.setBackground(new java.awt.Color(60, 255, 65));
        gameBoard.setPreferredSize(new java.awt.Dimension(375, 525));

        javax.swing.GroupLayout gameBoardLayout = new javax.swing.GroupLayout(gameBoard);
        gameBoard.setLayout(gameBoardLayout);
        gameBoardLayout.setHorizontalGroup(
            gameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        gameBoardLayout.setVerticalGroup(
            gameBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        gameStatus.setBackground(new java.awt.Color(170, 248, 234));

        gameStatusImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TIGERMOVE.png"))); // NOI18N

        gameStatusText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gameStatusText.setText("<html><font color=\"94A7DC\" size=\"6\" face=\"Gill Sans\">The </font><font color=\"#EFCAC2\" size=\"7\" face=\"Gill Sans\">tiger</font><font color=\"94A7DC\" size=\"6\" face=\"Gill Sans\"> is ready to move !</font></html>");
        gameStatusText.setToolTipText("");
        gameStatusText.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        gameStatusText.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout gameStatusLayout = new javax.swing.GroupLayout(gameStatus);
        gameStatus.setLayout(gameStatusLayout);
        gameStatusLayout.setHorizontalGroup(
            gameStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameStatusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gameStatusImage, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(gameStatusText, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                .addContainerGap())
        );
        gameStatusLayout.setVerticalGroup(
            gameStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameStatusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gameStatusImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(gameStatusLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(gameStatusText, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        timeLeftBar.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gameBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gameStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timeLeftBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gameStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(timeLeftBar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(gameBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel gameBoard;
    private static javax.swing.JPanel gameStatus;
    private static javax.swing.JLabel gameStatusImage;
    private static javax.swing.JLabel gameStatusText;
    private static javax.swing.JProgressBar timeLeftBar;
    // End of variables declaration//GEN-END:variables
}
