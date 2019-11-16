import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
public class LineBuild implements GLEventListener {

    private GLU glu;
    @Override
    public void init(GLAutoDrawable gld) {
        GL2 gl = gld.getGL().getGL2();
        glu = new GLU();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glViewport(-250, -150, 250, 150);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(-250.0, 250.0, -150.0, 150.0);
    }

    @Override
    public void dispose(GLAutoDrawable glad) {
        
    }

    @Override
    public void display(GLAutoDrawable drawable) {
       
        GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        gl.glPointSize(14.0f);
        gl.glColor3d(1, 0, 0);
     
     /*   File file = new File("input1.txt"); 
        Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
        while (sc.hasNextLine()){ 
          String l = sc.nextLine();
        }
        drawLine(gl,-20,-45,88,20);
        */
        int[] points = new int[20];
        try {
        	File file = new File("lab1.txt");
        	Scanner sc = new Scanner(file);
        	
        	int i = 0;
        	
        	while(sc.hasNextLine()) {
        		String a = sc.nextLine();
        		points[i] = Integer.parseInt(a);
        		if(i==19) {
        			break;
        		}
        		i++;
        	}
        		
        }catch(Exception e) {
        	System.out.println("error");
        }
        
        int j = 0;
        gl.glBegin(GL2.GL_POINTS);
        while(j<20) {
        	int x = points[j];
        	int y = points[++j];
        	 
             gl.glVertex2d(x,y);      

             ++j;
        	
        }
        gl.glEnd();
        
    
    }
  /*  public void drawLine(GL2 gl,double x1,double y1,double x2,double y2) 
    {
		double m=(y2-y1)/(x2-x1);
		double c=y1-m*x1;
		gl.glBegin(GL2.GL_POINTS);
		for(double x=x1;x<=x2;x++)
		{
			double y=m*x+c;
			gl.glVertex2d(x,y);
		}
		gl.glEnd();
    	}*/

    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
        
    }
    
}