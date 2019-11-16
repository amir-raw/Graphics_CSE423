import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
public class Polygon implements GLEventListener {

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
           gl.glPointSize(19.0f);
           gl.glColor3d(2, 1, 20);
           
           gl.glBegin(GL2.GL_POLYGON);//begin
          
           gl.glVertex2d(-30,20);
           gl.glVertex2d(-30,-40);
           gl.glVertex2d(30,-40);
           gl.glVertex2d(30,40);
           gl.glVertex2d(0,70);
           
           gl.glEnd(); //end
    }

    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
        
    }
    
}
