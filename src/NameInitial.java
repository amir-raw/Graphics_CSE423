import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
public class NameInitial implements GLEventListener {

    private GLU glu;
    @Override
    public void init(GLAutoDrawable gld) {
        GL2 gl = gld.getGL().getGL2();
        glu = new GLU();


        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glViewport(-500, -500, 500, 500);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(-500, 500, -500, 500);
    }

    @Override
    public void dispose(GLAutoDrawable glad) {
        
    }

    @Override
    public void display(GLAutoDrawable drawable) {
    	   GL2 gl = drawable.getGL().getGL2();
           gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
           gl.glPointSize(2.3f);
           gl.glColor3d(1, 1, 0);
           
          //A
           DDA(gl, -100,0,0,140);
           DDA(gl, -58,58,58,58);
           DDA(gl, 0,140,100,0);
           //F
           DDA(gl, 120,0,120,140);
           DDA(gl, 120,140,230,140);
           DDA(gl, 120,70,230,70);
           //Z
           DDA(gl, 240,140,340,140);
           DDA(gl, 240,0,340,140);
           DDA(gl, 240,0,340,0);
           
           
    }
    private void DDA(GL2 gl,double x1, double y1,double x2, double y2) { 

    	gl.glPointSize(1.0f);
        gl.glColor3d(1, 0, 0);
        gl.glBegin(GL2.GL_POINTS);

        gl.glVertex2d(x1, y1);

        double length = 0;
        double delx = Math.abs(x2 - x1);
        double dely = Math.abs(y2 - y1);
        if (delx >= dely) {
            length = delx;
        } else {
            length = dely;
        }
        delx = (x2 - x1) / length;
        dely = (y2 - y1) / length;

        double x, y;
        x = x1 + .5 * delx;
        y = y1 + .5 * dely;

        gl.glPointSize(1.0f);
        gl.glColor3d(1, 0, 0);
        gl.glBegin(GL2.GL_POINTS);

        for (int i = 0; i <= length; i++) {
            gl.glVertex2d(x, y);
            x = x + delx;
            y = y + dely;
        }
        // gl.glVertex2d(x2, y2);
        gl.glEnd();
    } 

    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
        
    }
    
}

