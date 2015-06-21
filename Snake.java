import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
/**
 * Write a description of class Snake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snake extends JPanel
{
    private String snake = "head.png";

    private int dx;
    private int dy;
    private int x;
    private int y;
    private Image image;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean leftDirection = false;
    private boolean rightDirection = false;

    public Snake() {
        //ImageIcon ii = new ImageIcon("images/"+this.getClass().getResource("head.png"));
        //ImageIcon ii = new ImageIcon(Image.class.getClassLoader().getResource("head.png"));
        ImageIcon ii = new ImageIcon("images/head.png");
        image = ii.getImage();
        x = 40;
        y = 60;
    }

    public void setDirection(String direction){
        if(direction == "left" && rightDirection == false ){
            leftDirection = true; 
            upDirection = false;
            downDirection = false;
        }
        if(direction == "right" && leftDirection == false){
            rightDirection = true;
            upDirection = false;
            downDirection = false;
        }
        if(direction == "up" && downDirection == false){
            upDirection = true;
            leftDirection = false;
            rightDirection = false;  
        }
        if(direction == "down" && upDirection == false){
            downDirection = true;
            leftDirection = false;
            rightDirection = false;
        }
    }

    public void move() {
        if(leftDirection == true){
            x = x - 3;
        }
        if(rightDirection == true){
            x = x + 3;
        }
        if(upDirection == true){
            y = y - 3;
        }
        if(downDirection == true){
            y = y + 3;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int _y){
        y = y+ _y;
    }

    public void setX(int _x){
        x = x + _x;
    }

    public Image getImage() {
        return image;
    }
    /**
    public void keyPressed(KeyEvent e){
    int key = e.getKeyCode();

    switch(key){
    case KeyEvent.VK_LEFT:
    dx = -1;
    break;

    case KeyEvent.VK_RIGHT:
    dx = 1;
    break;

    case KeyEvent.VK_UP:
    dy = -1;
    break;

    case KeyEvent.VK_DOWN:
    dy = 1;
    break;             
    }
    }

    public void keyReleased(KeyEvent e){
    int key = e.getKeyCode();

    switch(key){
    case KeyEvent.VK_LEFT:
    dx = -1;
    break;

    case KeyEvent.VK_RIGHT:
    dx = 1;
    break;

    case KeyEvent.VK_UP:
    dy = -1;
    break;

    case KeyEvent.VK_DOWN:
    dy = 1;
    break;             
    }
    }
     */
}
