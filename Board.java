import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.io.File;

public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Score score;
    private Snake snake;
    private Body body;
    private int bodyCount;
    private int delay = 140;
    
    private Image food;
    private int food_x;
    private int food_y;
    
    private int widthGame = 800;
    private int heightGame = 600;


    private boolean isPlaying = true;
    private Font font;
    public Board() {
        addKeyListener(new TAdapter());
        setFocusable(true);        
        setDoubleBuffered(true);
        setBackground(Color.WHITE);
        loadFoodImage();
        snake = new Snake();
        body = new Body();

        score = new Score();
        add(score);       
        showFood();
        timer = new Timer(delay, this);
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        score.paintComponent(g);

        Graphics2D g2d = (Graphics2D)g;        

        paintIntro(g);

        Toolkit.getDefaultToolkit().sync();
        g.dispose();

    }

    public void paintIntro(Graphics g) {
        if(isPlaying){
            //isPlaying = false;
            Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(food,food_x,food_y,null);
            try{
                File file = new File("fonts/VT323-Regular.ttf");
                font = Font.createFont(Font.TRUETYPE_FONT, file);
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(font);
                font = font.deriveFont(Font.PLAIN,40);
                g2d.setFont(font);
            }catch (Exception e){
                System.out.println(e.toString());
            }   
            //g2d.drawString("S N A K E: " + this.score, 300, 300);
            g2d.drawImage(snake.getImage(),snake.getX(),snake.getY(),null);
            g2d.drawImage(body.getImage(),body.getX(),body.getY(),null);
        }
    }

    public void actionPerformed(ActionEvent e) {
        snake.move();
        checkCollision();
        checkFood();
        repaint();  
    }
    
    private void loadFoodImage(){
        ImageIcon iic = new ImageIcon("images/fries.png");
        food = iic.getImage();
    }
    
    private void checkFood(){
        if((snake.getX() == food_x) && (snake.getY() == food_y)){
            bodyCount++;
            showFood();
        }
    }
    
    private void checkCollision(){
        if(snake.getX() >= widthGame){
            isPlaying = false;
        }
        if(snake.getX() < 0){
            isPlaying = false;
        }
        if(snake.getY() >= heightGame){
            isPlaying = false;
        }
        if(snake.getY() < 0){
            isPlaying = false;
        }
        if(!isPlaying){
            timer.stop();
        }
    }
    
    private void showFood(){
        int randomPosition = (int) (Math.random() * 50);
        food_x = randomPosition * 10;

        randomPosition = (int) (Math.random() * 50);
        food_y = randomPosition * 10;
    }

    private class TAdapter extends KeyAdapter {

        public void keyPressed(KeyEvent e) {

            // Obtém o código da tecla
            int key =  e.getKeyCode();

            switch (key){
                case KeyEvent.VK_ENTER:
                break;

                case KeyEvent.VK_LEFT:
                    snake.setDirection("left");
                break;

                case KeyEvent.VK_RIGHT :
                    snake.setDirection("right");
                break;

                case KeyEvent.VK_UP:
                    snake.setDirection("up");
                break;

                case KeyEvent.VK_DOWN:
                    snake.setDirection("down");
                break;
            }

        }
    }

}