import java.applet.Applet;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
 
public class tag extends Applet implements Runnable, KeyListener {
	int width,height;
	int rowNum=100;
	int colNum=200;
	int tileSize=8;
	drawer drawer;
	 Image backbuffer;
	 public  Graphics backg;
	 drawer draw;
	public void init(){
		super.init();
		width=(colNum)*tileSize;
		height=(rowNum)*tileSize;
		setSize(width, height);
		//setBackground(Color.BLACK);
		setFocusable(true);
	//	addKeyListener(this);
		Frame frame = (Frame) this.getParent().getParent();
		 //width = getSize().width;
	      //height = getSize().height;

	      backbuffer = createImage( width, height );
	      backg = backbuffer.getGraphics();
	     // backg.setColor( Color.blue );
	      //b;ckg.fillRect( 0, 0, width, height );
	      //backg.setColor( Color.white );
	      drawer = new drawer(backg,rowNum, colNum,tileSize);
		/* backbuffer = createImage( getSize().width, getSize().height );
	System.out.println(getSize().width);
	     frame.setTitle("Awesome adventure 2");
	     draw=new drawer(backbuffer,getSize().width,getSize().height);
	    */ repaint();
	    //  e.consume();
	 
			addKeyListener(this);
	}
	
	public void start(){
		super.start();
		Thread game = new Thread(this);
		game.start();
	}

	public void stop(){
		super.stop();
	}
	
	public void destroy(){
		super.destroy();
	}
	
	public void run(){
		while(true){
			   drawer.maze();
			    //drawer.checkers();
			    drawer.drawMap(backg);
			repaint();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:

		   
			System.out.println("moving up");
		break;
		//oops
		case KeyEvent.VK_DOWN:

		   
            System.out.println("moving down");
		break;
			
		case KeyEvent.VK_LEFT:
            System.out.println("moving left");
		break;
		
		case KeyEvent.VK_RIGHT:
            System.out.println("moving right");
		break;
		
		case KeyEvent.VK_F:
            System.out.println("jumping");

		break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
        case KeyEvent.VK_UP:
            System.out.println("Stop moving up");
            break;

        case KeyEvent.VK_DOWN:
            System.out.println("Stop moving down");
            break;

        case KeyEvent.VK_LEFT:
            System.out.println("Stop moving left");
            break;

        case KeyEvent.VK_RIGHT:
            System.out.println("Stop moving right");
            break;

        case KeyEvent.VK_SPACE:
            System.out.println("Stop jumping");
            break;

        }
		
	}
	   public void update( Graphics g ) {
		      g.drawImage(backbuffer, 0, 0, this );
		   }

		   public void paint( Graphics g ) {
		      update( g );
		   }
	/* public void paint(Graphics g) {
         
         int row;   // Row number, from 0 to 7
         int col;   // Column number, from 0 to 7
         int x,y;   // Top-left corner of square
      
         for ( row = 0;  row < 8;  row++ ) {
         
            for ( col = 0;  col < 8;  col++) {
               x = col * 20;
               y = row * 20;
               if ( (row % 2) == (col % 2) )
                  g.setColor(Color.red);
               else
                  g.setColor(Color.black);
               g.fillRect(x, y, 20, 20);
            } 
         
         } // end for row
      
      }  // end paint()
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
		 update(draw.backg)
}*/

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}}
