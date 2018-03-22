
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Random;


public class Gra extends Applet implements Runnable, KeyListener
{
    private Image img;
    private Graphics gg;
    private Samolot samolot;
    private Przeszkody []przeszkody=new Przeszkody[8];
    private Image tlo;
    

    @Override
    public void init() {
        setSize(500, 600);
        addKeyListener(this);
       
    }

    @Override
    public void start() {
        
        samolot=new Samolot(100,100);
        for(int i=0; i<przeszkody.length;i++)
        {
            Random r= new Random();
            
            przeszkody[i]=new Przeszkody(r.nextInt(450),-(r.nextInt(600)));
        }
        
        Thread t= new Thread(this);
        t.start();
        
    }

    @Override
    public void update(Graphics g) {
        if(img==null)
        {
            img=createImage(this.getSize().width, this.getSize().height);
            gg=img.getGraphics();
        }
        
        gg.setColor(getBackground());
        gg.fillRect(0, 0, getSize().width, getSize().height);
        gg.setColor(getForeground());
        paint(gg);
        
        g.drawImage(img, 0, 0, this);
        
    }

    @Override
    public void paint(Graphics g) {
        samolot.paint(g);
         for(int i=0; i<przeszkody.length;i++)
        {
        przeszkody[i].paint(g);
        }
        
        
         
       
    }

    @Override
    public void run() {
        
        while(true){
            samolot.update(this);
             for(int i=0; i<przeszkody.length;i++)
        {
            przeszkody[i].update(this, samolot );
        }
            
            
            
            repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {}
        }
    }
    
     @Override
    public void keyPressed(KeyEvent e) {
        
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_LEFT:
                samolot.ruchLewo();
                break;
            case KeyEvent.VK_RIGHT:
                samolot.ruchPrawo();
                break;
            case KeyEvent.VK_UP:
                samolot.ruchGora();
                
                break;
            case KeyEvent.VK_DOWN:
                samolot.ruchDol();
                break;    
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

   

    @Override
    public void keyReleased(KeyEvent e) {
        
        samolot.pozWyjsciowa();
    }
    
    
    
}
