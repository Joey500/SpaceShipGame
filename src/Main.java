import java.applet.Applet;
import java.awt.*;

/**
 * Created by Pavilion on 14-5-2016.
 */
public class Main extends Applet implements Runnable {
    Score s;
    int score;
    Player p;
    Enemy e,e2,e3,e4;
    Image dbgImage;
    Graphics dbg;
    Image img1;
    MediaTracker tr;
    public void init() {
        setSize(400, 400);
        p=new Player(this);
        e=new Enemy(this);
        e2=new Enemy(200,300,this);
        e3=new Enemy(300,400,this);
        e4=new Enemy(400,500,this);
        s=new Score(this);
        img1 = getImage(getDocumentBase(),"bg.jpg");
        int score=0;
    }

    public void start(){
        Thread tr=new Thread(this);
        tr.start();
    }
    public void stop(){

    }
    public void destroy(){

    }

    public void paint(Graphics g){
        g.drawImage(img1,0,0,this);
        p.paint(g,this);
        e.paint(g,this);
        e2.paint(g,this);
        e3.paint(g,this);
        e3.paint(g,this);
        e4.paint(g,this);
        s.paint(g,this);
//        String s=Integer.toString(score);
//        g.setColor(Color.RED);
//        Font f=new Font("Arial",Font.BOLD, 50);
//        g.setFont(f);
//        g.drawString(s,200,100);



    }

public void update(Graphics g){
    dbgImage=createImage(getWidth(),getHeight());
    dbg=dbgImage.getGraphics();
    paint(dbg);
    g.drawImage(dbgImage,0,0,this);
    score++;
}

    @Override
    public void run() {
        while(true){
            repaint();
            p.update(this);
            e.update(this,p);
            e2.update(this,p);
            e3.update(this,p);
            e4.update(this,p);
            s.update(this);
         try{
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    }


}
