import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

/**
 * Created by Pavilion on 14-5-2016.
 */
public class Player implements KeyListener{
    private int x = 200;
    private int y = 200;
    private int radius = 20;
    private int VelX = 0;
    private int VelY = 0;
    private Image player;
    private URL url;


    public Player(Main mc){
        url=mc.getDocumentBase();
        player=mc.getImage(url,"space.png");
    }
    public void update(Main mc) {
       mc.addKeyListener(this);
        x +=VelX;
        y+=VelY;
    }



    public void paint(Graphics g, Main mc) {
            g.drawImage(player, x , y, 100, 100, mc);
        for(int i=0; i<5; i++) {
            g.setColor(Color.blue);
            g.fillRect(10, 10, 50*i+10,5*i+10);

        for(int j=0; j<5; j++) {
            g.setColor(Color.blue);
            g.fillRect(10, 10, 50*j,5*j+10);
        }}
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
                VelY=-5;
                break;
            case KeyEvent.VK_DOWN:
                VelY=5;
                break;
            case KeyEvent.VK_LEFT:
                VelX=-5;
                break;
            case KeyEvent.VK_RIGHT:
                VelX=5;
                break;

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
                VelY=0;
                break;
            case KeyEvent.VK_DOWN:
                VelY=0;
                break;
            case KeyEvent.VK_LEFT:
                VelX=0;
                break;
            case KeyEvent.VK_RIGHT:
                VelX=0;
                break;
        }
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
    public int getRadius(){
        return radius;
    }

}
