import java.awt.*;
import java.net.URL;

/**
 * Created by Pavilion on 14-5-2016.
 */
public class Enemy {
    private int x = 100;
    private int y = 50;
    private int speed = 5;
    private Image enemy;
    private URL url;


    public Enemy(Main mc) {
        url = mc.getDocumentBase();
        enemy = mc.getImage(url, "monster.png");
    }


    public Enemy(int i, int j, Main mc) {
        url = mc.getDocumentBase();
        enemy = mc.getImage(url, "monster.png");
        x = i;
        y = j;
    }

    public Enemy(int i, int i1) {
    }


    public void paint(Graphics g, Main mc) {

        g.drawImage(enemy, x, y, 80,80, mc);
    }

    public void update(Main mc, Player p) {
        x += speed;
        if (x <= 0) {
            speed = 8;
        } else if (x >= mc.getWidth() - 25) {
            speed = -8;

        }
        Collision(p);
    }

    private void Collision(Player p) {
        int PX = p.getX();
        int PY = p.getY();

        // int PR =p.getRadius();

        if (PX - 32 <= x && PX + 32 >= x && PY - 32 <= y && PY + 32 >= y) {
            System.out.println("collison dected!");
        }

    }
}

