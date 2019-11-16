import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

import static java.lang.StrictMath.abs;

public class MidpointLine implements GLEventListener {
    /**
     * Interface to the GLU library.
     */
    private GLU glu;

    /**
     * Take care of initialization here.
     *
     * @param gld
     */
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

    /**
     * Take care of drawing here.
     *
     * @param drawable
     */
    @Override
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        /*
         * put your code here
         */
        //points should be in the same zone
        DrawMPL(gl, 0, 50, 120, -200);
        //DrawMPL(gl,10,-10,60,-50);
        //DrawMPL(gl,-30,-10,-100,-40);
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        //do nothing
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
        //do nothing
    }

    private int dx, dy, b;

    private void DrawMPL(GL2 gl, int x1, int y1, int x2, int y2) {
        //write your own code
        gl.glPointSize(2.0f);
        gl.glColor3d(1, 0, 0);
        gl.glBegin(GL2.GL_POINTS);


        int zone = findZone(x1, y1, x2, y2);
        drawLine(gl, zone, abs(x1), abs(y1), abs(x2), abs(y2));
        gl.glEnd();
    }

     private void drawLine(GL2 gl, int zone, int x1, int y1, int x2, int y2) {
        int dx, dy, d, incE, incNE, x, y;
        dx = x2 - x1;
        dy = y2 - y1;
        d = 2 * dy - dx;
        incE = 2 * dy;
        incNE = 2 * (dy - dx);
        y = y1;
        System.out.println(zone);
        for (x = x1; x <= x2; x++) {
            //System.out.println(zone);
            draw8wayPixel(gl,zone, x, y);
            if (d > 0) {
                d = d + incNE;
                y = y + 1;
            } else {
                d = d + incE;
            }
        }
    }

    private void draw8wayPixel(GL2 gl,int zone, int x, int y){
        if(zone==0){
            gl.glVertex2d(x, y);
        }
        else if(zone==1){
            gl.glVertex2d(y, x);
        }
        else if(zone==2){
            gl.glVertex2d(-y, x);
        }
        else if(zone==3){
            gl.glVertex2d(-x, y);
        }
        else if(zone==4){
            gl.glVertex2d(-x, -y);
        }
        else if(zone==5){
            gl.glVertex2d(-y, -x);
        }
        else if(zone==6){
            gl.glVertex2d(y, -x);
        }
        else {
            gl.glVertex2d(x, -y);
        }
    }


    //y=mx+b
    private int func(int x, float y) {
        return (int) (dy * x - y * dx + b * dx);
    }


     private int findZone(int x1, int y1, int x2, int y2) {
        int zone;

        int dx = x2 - x1;
        int dy = y2 - y1;

        if (dx >= 0 && dy >= 0) {
            if (dx >= dy) {
                zone = 0;
            } else {
                zone = 1;
            }
        } else if (dx < 0 && dy >= 0) {
            if (Math.abs(dx) > dy) {
                zone = 3;
            } else {
                zone = 2;
            }
        } else if (dx < 0 && dy < 0) {
            if (Math.abs(dx) > Math.abs(dy)) {
                zone = 4;
            } else {
                zone = 5;
            }
        } else {
            if (dx < Math.abs(dy)) {
                zone = 6;
            } else {
                zone = 7;
            }
        }
        return zone;
    }

    int convertX(int x, int y, int zone) {
        int convertedX = 0;
        return convertedX;
    }

    int convertY(int x, int y, int zone) {
        int convertedY = 0;
        return convertedY;
    }


    public void dispose(GLAutoDrawable arg0) {
        //do nothing
    }
}
