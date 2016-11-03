import javax.swing.*;
import java.awt.event.*;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;
/**
 * Created by Jiyu Han on 10/28/16.
 * <b>Description:</b> This is the class that includes event handling for my Game of Life game.
 * However, the layout is NOT included in this file since I used GUIForm.
 */
public class GOLFrame extends JFrame{
    private JButton startButton;
    private JButton resetButton;
    private JPanel golGUI;
    private JPanel golGraphicField;
    private JButton gosperGliderGunButton;
    private JButton otherCoolStuffYetButton;

    private int widthOfPanel = 480, heightOfPanel = widthOfPanel * 9 / 16; // just to make sure it's 16:9, to make it "square"
    private boolean currentState[][] = new boolean[heightOfPanel][widthOfPanel], nextState[][] = new boolean[heightOfPanel][widthOfPanel];

    private boolean play = false;

    private Image offScreenImage;

    private Graphics offScreenGraphics;

    /**
     * <b>Description:</b> This is the constructor for GOLFrame. It uses the function setContentPane() to load
     * my settings in GOLFrame.form . Also, it includes basically all my event handling methods.
     */
    public GOLFrame() {
        super("Conway's Game of Life");

        setContentPane(golGUI);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**
         * this handles all the events happening with startButton. It switches the state of the game to either
         * play or pause. Also the text on the button will be switched around between pause or play, as well.
         */
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(play) {
                    startButton.setText("Play");
                    play = false;
                }
                else {
                    startButton.setText("Pause");
                    play = true;
                }
            }
        });

        /**
         * This builds the Gosper Glider Gun. It calls a method which flips several boolean variables in the array from
         * false to true in order to build the shape of Gosper Glider Gun.
         */
        gosperGliderGunButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                drawGosperGliderGun();
                refreshPanel();
            }
        });

        /**
         * This method resets the array to all "false", aka black, or empty...
         */
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (int i = 0; i < heightOfPanel; i++) {
                    for (int j = 0; j < widthOfPanel; j++) {
                        currentState[i][j] = false;
                    }
                }
                refreshPanel();
            }
        });

        /**
         * This method handles mainly on mouse clicking. When you click your mouse on the JPanel, it gets the location
         * and flips that specific point in the array then refresh the screen so you can see the "pixel" you clicked
         * turns to yellow.
         */
        golGraphicField.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                int j = widthOfPanel * mouseEvent.getX() / golGraphicField.getWidth();
                int i = heightOfPanel * mouseEvent.getY() / golGraphicField.getHeight();

                currentState[i][j] = !currentState[i][j];
                refreshPanel();
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });

        golGraphicField.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent componentEvent) {
                offScreenImage = createImage(golGraphicField.getWidth(), golGraphicField.getHeight());
                offScreenGraphics = offScreenImage.getGraphics();
                refreshPanel();
            }

            @Override
            public void componentMoved(ComponentEvent componentEvent) {

            }

            @Override
            public void componentShown(ComponentEvent componentEvent) {

            }

            @Override
            public void componentHidden(ComponentEvent componentEvent) {

            }
        });
        setVisible(true);

        offScreenImage = createImage(golGraphicField.getWidth(), golGraphicField.getHeight());
        offScreenGraphics = offScreenImage.getGraphics();

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if(play) {
                    for (int i = 0; i < heightOfPanel; i++) {
                        for (int j = 0; j < widthOfPanel; j++) {
                            nextState[i][j] = usingGameRuleToDecide(i, j);
                        }
                    }
                    for (int i = 0; i < heightOfPanel; i++) {
                        for (int j = 0; j < widthOfPanel; j++) {
                            currentState[i][j] = nextState[i][j];
                        }
                    }
                    refreshPanel();
                }
            }
        };
        timer.scheduleAtFixedRate(timerTask, 0, 50);
        refreshPanel();
    }

    private void refreshPanel() {
        offScreenGraphics.setColor(Color.BLACK);
        offScreenGraphics.fillRect(0, 0, golGraphicField.getWidth(), golGraphicField.getHeight());

        offScreenGraphics.setColor(Color.YELLOW);

        for(int i = 0; i < heightOfPanel; i++){
            for(int j = 0; j < widthOfPanel; j++) {
                if (currentState[i][j]) {
                    int xAxis = j * golGraphicField.getWidth() / widthOfPanel;
                    int yAxis = i * golGraphicField.getHeight() / heightOfPanel;
                    offScreenGraphics.fillRect(xAxis, yAxis, golGUI.getWidth() / widthOfPanel, golGraphicField.getHeight() / heightOfPanel);
                }
            }
        }
        offScreenGraphics.setColor(Color.WHITE);

        for(int i = 1; i < heightOfPanel; i++){
            int yAxis = i * golGraphicField.getHeight() / heightOfPanel;
            offScreenGraphics.drawLine(0, yAxis, golGraphicField.getWidth(), yAxis);
        }

        for(int i = 1; i < widthOfPanel; i++){
            int xAxis = i * golGraphicField.getWidth() / widthOfPanel;
            offScreenGraphics.drawLine(xAxis, 0, xAxis, golGraphicField.getHeight());
        }

        golGraphicField.getGraphics().drawImage(offScreenImage, 0, 0, golGraphicField);
    }

    private boolean usingGameRuleToDecide(int i, int j) { // i height, j width. goes right into the boolean array [i][j]
        int neighbors = 0;
        if(j > 0) {
            if(currentState[i][j - 1]) neighbors++; //left
            if(i > 0) if(currentState[i - 1][j - 1]) neighbors++; //left upper
            if(i < heightOfPanel - 1) if(currentState[i + 1][j - 1]) neighbors++; //left lower
        }
        if(j < widthOfPanel - 1){
            if(currentState[i][j + 1]) neighbors++; //right
            if(i > 0) if(currentState[i - 1][j + 1]) neighbors++; //right upper
            if(i < heightOfPanel - 1) if(currentState[i + 1][j + 1]) neighbors++; // right lower
        }
        if(i > 0) if(currentState[i - 1][j]) neighbors++; //up
        if(i < heightOfPanel -1) if(currentState[i + 1][j]) neighbors++; //down

        if(neighbors == 3) return true;
        if(currentState[i][j] && neighbors == 2) return true;

        return false;
    }

    private void drawGosperGliderGun() {
        this.currentState[6][2] = true;
        this.currentState[7][2] = true;
        this.currentState[6][3] = true;
        this.currentState[7][3] = true;
        this.currentState[6][12] = true;
        this.currentState[7][12] = true;
        this.currentState[8][12] = true;
        this.currentState[5][13] = true;
        this.currentState[9][13] = true;
        this.currentState[4][14] = true;
        this.currentState[10][14] = true;
        this.currentState[4][15] = true;
        this.currentState[10][15] = true;
        this.currentState[7][16] = true;
        this.currentState[5][17] = true;
        this.currentState[9][17] = true;
        this.currentState[6][18] = true;
        this.currentState[7][18] = true;
        this.currentState[8][18] = true;
        this.currentState[7][19] = true;
        this.currentState[4][22] = true;
        this.currentState[5][22] = true;
        this.currentState[6][22] = true;
        this.currentState[4][23] = true;
        this.currentState[5][23] = true;
        this.currentState[6][23] = true;
        this.currentState[3][24] = true;
        this.currentState[7][24] = true;
        this.currentState[2][26] = true;
        this.currentState[3][26] = true;
        this.currentState[7][26] = true;
        this.currentState[8][26] = true;
        this.currentState[4][36] = true;
        this.currentState[5][36] = true;
        this.currentState[4][37] = true;
        this.currentState[5][37] = true;
    }
}
