import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
/**
 * Write a description of class Body here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Body extends JPanel
{
    private String snake = "body.png";

    private int dx;
    private int dy;
    private int x;
    private int y;
    private Image image;
    private Body next;
    private Body previous;

    public Body() {
        //ImageIcon ii = new ImageIcon("images/"+this.getClass().getResource("head.png"));
        //ImageIcon ii = new ImageIcon(Image.class.getClassLoader().getResource("head.png"));
        ImageIcon ii = new ImageIcon("images/body.png");
        image = ii.getImage();
        x = 85;
        y = 60;
    }
    public Body(int _x, int _y) {
        //ImageIcon ii = new ImageIcon("images/"+this.getClass().getResource("head.png"));
        //ImageIcon ii = new ImageIcon(Image.class.getClassLoader().getResource("head.png"));
        ImageIcon ii = new ImageIcon("images/body.png");
        image = ii.getImage();
        x = _x;
        y = _y;
    }

    public void moveX(int _x) {
        x += _x;
    }

    public void moveY(int _y){
        y += _y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void setX(int _x){
        x = _x;
    }
    
    public void setY(int _y){
        y = _y;
    }

    public Body getNext(){
        return next;
    }

    public void setNext(Body _body){
        next = _body;
    }

    public Body getPrevious(){
        return previous;
    }

    public void setPrevious(Body _body){
        previous = _body;
    }

    public Image getImage() {
        return image;
    }
}