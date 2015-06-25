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

    private int px;
    private int py;
    private int x;
    private int y;
    private Image image;
    private int delay = 10;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean leftDirection = true;
    private boolean rightDirection = false;
    private boolean body = false;
    private Snake next;
    private Snake previous;

    public Snake() {
        //ImageIcon ii = new ImageIcon("images/"+this.getClass().getResource("head.png"));
        //ImageIcon ii = new ImageIcon(Image.class.getClassLoader().getResource("head.png"));
        ImageIcon ii = new ImageIcon("images/left.png");
        image = ii.getImage();
        x = 500;
        y = 300;
    }

    public Snake(int x, int y){
        ImageIcon ii = new ImageIcon("images/body.png");
        image = ii.getImage();
        this.x = x;
        this.y = y;
        body = true;
    }

    public void setDirection(String direction){
        if(direction == "left" && rightDirection == false && body == false ){
            ImageIcon ii = new ImageIcon("images/left.png");
            image = ii.getImage();
            leftDirection = true; 
            upDirection = false;
            downDirection = false;
        }
        if(direction == "right" && leftDirection == false && body == false ){
            ImageIcon ii = new ImageIcon("images/right.png");
            image = ii.getImage();
            rightDirection = true;
            upDirection = false;
            downDirection = false;
        }
        if(direction == "up" && downDirection == false && body == false ){
            ImageIcon ii = new ImageIcon("images/upLeft.png");
            image = ii.getImage();
            upDirection = true;
            leftDirection = false;
            rightDirection = false;  
        }
        if(direction == "down" && upDirection == false && body == false ){
            ImageIcon ii = new ImageIcon("images/downLeft.png");
            image = ii.getImage();
            downDirection = true;
            leftDirection = false;
            rightDirection = false;
        }
    }

    public String getDirection(){
        if(leftDirection == true){
            return "left";
        }
        if(rightDirection == true){
            return "right";
        }
        if(upDirection == true){
            return "up";
        }
        if(downDirection == true){
            return "down";
        }
        return "";
    }

    public void move() {
        if(leftDirection == true){
            x = x - delay;
        }
        if(rightDirection == true){
            x = x + delay;
        }
        if(upDirection == true){
            y = y - delay;
        }
        if(downDirection == true){
            y = y + delay;
        }
    }

    public void setImage(String image){
        if(image.equals("body")){
            ImageIcon ii = new ImageIcon("images/body.png");
            this.image = ii.getImage();
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int _y){
        y =_y;
    }

    public void setX(int _x){
        x = _x;
    }

    public void setPreviousY(int _y){
        py = _y;
    }

    public void setPreviousX(int _x){
        px = _x;
    }

    public int getPreviousY(){
        return py;
    }

    public int getPreviousX(){
        return px;
    }

    public Snake getNext(){
        return next;
    }

    public void setNext(Snake _body){
        next = _body;
    }

    public Snake getPrevious(){
        return previous;
    }

    public void setPrevious(Snake _body){
        previous = _body;
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
