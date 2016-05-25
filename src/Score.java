import java.awt.*;

/**
 * Created by Pavilion on 25-5-2016.
 */
public class Score{
    int score;

    public Score(Main main) {
        score=0;
    }


    public void init(){

    }
    public void paint(Graphics g,Main main){
        String s=Integer.toString(score);
        g.setColor(Color.RED);
        Font f=new Font("Arial",Font.BOLD, 50);
        g.setFont(f);
        g.drawString(s,200,100);

    }




    public void update(Main main) {
        score++;
    }
}
