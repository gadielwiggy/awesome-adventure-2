import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class tag extends Applet implements Runnable, KeyListener {
	
	
	public void init(){
		super.init();
		setSize(800, 480);
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(this);
		Frame frame = (Frame) this.getParent().getParent();
	     frame.setTitle("Awesome adventure 2");
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
			repaint();
			try {
				Thread.sleep(17);
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
