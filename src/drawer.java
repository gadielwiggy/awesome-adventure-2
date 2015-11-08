import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

public class drawer {
	int width, height;
	int[][] map;
	int rowNum,colNum,tileSize;
	  public static Image backbuffer;
	public  Graphics backg;
	 public drawer(Graphics backg, int rowNum,int colNum,int tileSize)
	 {    
		// backg = backbuffer.getGraphics();
	  //   backg = backg2;// backbuffer.getGraphics();
		 this.rowNum =rowNum;
		 this.colNum=colNum;
		 this.tileSize=tileSize;
		 this.backg=backg;
         map=new int[rowNum][colNum];
	     backg.setColor( Color.BLUE );
	     backg.fillRect( 0, 0, width, height );
	     backg.setColor( Color.blue); 
	 }
	 public void checkers()
	 {
		 int row;   // Row number, from 0 to 7
         int col;  
         for ( row = 0;  row < rowNum;  row++ ) {
             
             for ( col = 0;  col < colNum;  col++) {
           
                if ( (row % 2) == (col % 2) )
                	map[row][col]=1;
                else
                	map[row][col]=0;
              //  backg.fillRect(x, y, tileSize, tileSize);
             } 
          }
	 }	
	 static class Point{
	    	Integer r;
	    	Integer c;
	    	Point parent;
	    	public Point(int x, int y, Point p){
	    		r=x;c=y;parent=p;
	    	}
	    	// compute opposite node given that it is in the other direction from the parent
	    	public Point opposite(){
	    		if(this.r.compareTo(parent.r)!=0)
	    			return new Point(this.r+this.r.compareTo(parent.r),this.c,this);
	    		if(this.c.compareTo(parent.c)!=0)
	    			return new Point(this.r,this.c+this.c.compareTo(parent.c),this);
	    		return null;
	    	}
	    }
	 public void maze()
	 {
		 int r=rowNum;   // Row number, from 0 to 7
         int c=colNum;  
         int stx;
         int sty;
        ///int r=10, c=10;

     	// build maze and initialize with only walls
         StringBuilder s = new StringBuilder(c);
         for(int x=0;x<c;x++)
         	s.append('*');
         char[][] maz = new char[r][c];
         for(int x=0;x<r;x++) maz[x] = s.toString().toCharArray();

         // select random point and open as start node
         Point st = new Point((int)(Math.random()*r),(int)(Math.random()*c),null);
         maz[st.r][st.c] = 'S';
         stx=st.r;
         sty=st.c;
         // iterate through direct neighbors of node
         ArrayList<Point> frontier = new ArrayList<Point>();
         for(int x=-1;x<=1;x++)
         	for(int y=-1;y<=1;y++){
         		if(x==0&&y==0||x!=0&&y!=0)
         			continue;
         		try{
         			if(maz[st.r+x][st.c+y]=='.') continue;
         		}catch(Exception e){ // ignore ArrayIndexOutOfBounds
         			continue;
         		}
         		// add eligible points to frontier
         		frontier.add(new Point(st.r+x,st.c+y,st));
         	}

         Point last=null;
         while(!frontier.isEmpty()){

         	// pick current node at random
         	Point cu = frontier.remove((int)(Math.random()*frontier.size()));
         	Point op = cu.opposite();
         	try{
         		// if both node and its opposite are walls
         		if(maz[cu.r][cu.c]=='*'){
         			if(maz[op.r][op.c]=='*'){

         				// open path between the nodes
         				maz[cu.r][cu.c]='.';
         				maz[op.r][op.c]='.';

         				// store last node in order to mark it later
         				last = op;

         				// iterate through direct neighbors of node, same as earlier
         				for(int x=-1;x<=1;x++)
 				        	for(int y=-1;y<=1;y++){
 				        		if(x==0&&y==0||x!=0&&y!=0)
 				        			continue;
 				        		try{
 				        			if(maz[op.r+x][op.c+y]=='.') continue;
 				        		}catch(Exception e){
 				        			continue;
 				        		}
 				        		frontier.add(new Point(op.r+x,op.c+y,op));
 				        	}
         			}
         		}
         	}catch(Exception e){ // ignore NullPointer and ArrayIndexOutOfBounds
         	}

         	// if algorithm has resolved, mark end node
         	if(frontier.isEmpty())
         		maz[last.r][last.c]='E';
         	
         }
         for(int i=0;i<r;i++){
 			for(int j=0;j<c;j++)
 				if(maz[i][j]=='*')
 					map[i][j]=0;
 				else
 					map[i][j]=1;
 		}

         map[last.r][last.c]=3;
         map[stx][sty]=2;
       //  map[10][10]=2;
	 }
	 public void drawMap(Graphics g)
	 {
		 
		//int rowNum,colNum;
		 int row;   // Row number, from 0 to 7
         int col;   // Column number, from 0 to 7
         int x,y;   // Top-left corner of square
         
         
         for ( row = 0;  row < rowNum;  row++ ) {
         
            for ( col = 0;  col < colNum;  col++) {
               x = col * tileSize;
               y = row * tileSize;
               if ( map[row][col]==1)
                  g.setColor(Color.white);
               else if  ( map[row][col]==2)
            	   g.setColor(Color.blue);  
               else if  ( map[row][col]==3)
                	   g.setColor(Color.red);
               else
                  g.setColor(Color.black);
               g.fillRect(x, y, tileSize, tileSize);
            } 
         }
	 }
}
