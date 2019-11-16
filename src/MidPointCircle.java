import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
public class MidPointCircle implements GLEventListener {

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
         
          //begin
          
         //  Ellipse(gl, 100, 50);
           drawCircle(gl, 50, 50, 400);
        
        //   drawCircle(gl, -100, 100, 50);
          // drawCircle(gl, 200, 100, 50);
           //drawCircle(gl, 50, -100, 80);
            //end
    }
    public void Ellipse(GL2 gl,int a, int b){
       
    }
   private void drawCircle(GL2 gl, int cx,int cy,int r){
        int x = 0, y = r;
        int d = 1-r;
        int dE = 2*x+3, dSE = 2*(x-y)+5;
        gl.glBegin(GL2.GL_POINTS);
        
        while(x<=y){
            gl.glVertex2i(x+cx, y+cy);
            gl.glVertex2i(y+cx, x+cy);
            
            gl.glVertex2i(-x+cx, y+cy);
            gl.glVertex2i(-y+cx, x+cy);                        
           
            gl.glVertex2i(x+cx, -y+cy);
            gl.glVertex2i(y+cx, -x+cy);
            
            gl.glVertex2i(-x+cx, -y+cy);
            gl.glVertex2i(-y+cx, -x+cy);
            
            dE = dE+2;
            
            if(d<0){
                
                d = d+dE;
                dSE -= -2;
            }else{
                
                d=d+dSE;
                y--;
                dSE -= -4;
            }
            x++;
        }
        gl.glEnd();
    }
   @Override
   public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
       
   }
   
}