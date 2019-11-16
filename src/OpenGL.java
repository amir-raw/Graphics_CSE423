import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;
/**
 *
 * @author 
 */
public class OpenGL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
      //getting the capabilities object of GL2 profile        
      final GLProfile profile = GLProfile.get(GLProfile.GL2);
      GLCapabilities capabilities = new GLCapabilities(profile);
   
      // The canvas
      final GLCanvas glcanvas = new GLCanvas(capabilities);
     // NameInitial name = new NameInitial();
    //  emoji emo = new emoji();
      MidPointCircle midcir = new MidPointCircle();
     // MidpointLine mid = new MidpointLine();
      // Polygon drawing = new Polygon();
      //Quadraple quad = new Quadraple();
     // LineBuild line = new LineBuild();
     // glcanvas.addGLEventListener(drawing);
     // glcanvas.addGLEventListener(quad);
      glcanvas.addGLEventListener(midcir);
      glcanvas.setSize(500, 500);
   
      //creating frame
      final JFrame frame = new JFrame ("straight Line");
   
      //adding canvas to frame
      frame.getContentPane().add(glcanvas);                 
      frame.setSize(frame.getContentPane().getPreferredSize());
      frame.setVisible(true);
      
   }
    
}