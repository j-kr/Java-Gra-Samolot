
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


public class Samolot {
    
    int x;
    int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSrednica() {
        return srednica;
    }

    public void setSrednica(int srednica) {
        this.srednica = srednica;
    }
    int srednica=50;
    Image samolot1, samolot2, samolot3, samolot;

    public Samolot(int x, int y) {
       
            this.x=x;
            this.y=y;
         try {    
            samolot1=ImageIO.read(new File("samolot1.png"));
            samolot2=ImageIO.read(new File("samolot2.png"));
            samolot3=ImageIO.read(new File("samolot3.png"));  
            samolot=samolot1;
        } catch (IOException ex) {}
        
        
    }
    
    
    
    public void update(Gra gra)
    {
        if(x+srednica>=gra.getWidth())
        {
            x= gra.getWidth()-srednica;
        }
        else if(x<=0)
        {
            x=0;
        }
       
        if(y<0)
        {
            y=0;
        }
        else if(y+srednica>=gra.getHeight())
        {
            y=gra.getHeight()-srednica;
        }
        else
        {
            y++;
        }
        
    }
    
    public void paint(Graphics g )
    {
//        g.fillOval(x, y, srednica, srednica);
        g.drawImage(samolot, x, y, null);
        
    }

    void ruchLewo() {
        x-=8;  
        samolot=samolot2;
    }

    void ruchPrawo() {
        x+=8;
        samolot=samolot3;
    }

    void ruchGora() {
        y-=8;
        samolot=samolot1;
    }

    void ruchDol() {
        y+=8;
        samolot=samolot1;
    }

    void pozWyjsciowa() {
        samolot=samolot1;
    }
    
    
    
    
}
