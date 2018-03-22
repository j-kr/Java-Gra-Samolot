
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


public class Przeszkody {
    
    private int x, y;
    private int srednica=50;
    private Image ogien;
    
    public Przeszkody(int x, int y)
    {
        this.x=x;
        this.y=y-srednica;
        
        try {
            ogien= ImageIO.read(new File("ogien.png"));
        } catch (IOException ex) {}
    }
    
    public void update(Gra gr, Samolot samolot)
    {
        if(y>=gr.getHeight())
        {
            y= 0-srednica;
        }
        else
        {
            y++;
            y++;
            
        }
        sprKolizja(samolot);
    }
    
    public void sprKolizja(Samolot samolot)
    {
        int samolotX=samolot.getX();
        int samolotY=samolot.getY();
        int promienSamolot=samolot.getSrednica()/2;
        
        int a= samolotX-x;
        int b=samolotY-y;
        int sumaProm= promienSamolot+srednica/2;
        
        double c=Math.sqrt((double)(a*a)+(double)(b*b));
        if(c<sumaProm)
        {
            samolot.setX(300);
            samolot.setY(600);
        }
    }
    
    public void stop(Thread t){
        t.stop();
    }
    
    public void paint(Graphics g)
    {
//        g.fillOval(x, y, srednica, srednica);
        g.drawImage(ogien, x, y, null);
    }
    
    
    
    
}
