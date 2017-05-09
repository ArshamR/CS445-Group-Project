/*******************************************************************************
 * file Main.java
 * author: Arsham Ravanipour
 * class CS 445 - Computer Graphics
 * 
 * assignment: Program 3
 * date last modified 5/2/2017
 * 
 * purpose: This program reads a file and draws a polygon filled with the 
 * specified color and with the specified transformations performed.
 * This program also doesn't work so thats an extra feature.
 ******************************************************************************/

import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import static org.lwjgl.util.glu.GLU.gluPerspective;

public class Main {
    public static final int DISPLAY_HEIGHT = 480;
    public static final int DISPLAY_WIDTH = 640;
    private DisplayMode displayMode;
    private FPCameraController fp = new FPCameraController(0F,0F,0F);

  public static void main(String[] args) {
      Main main = null;
      main = new Main();
      main.start();   
  }
  
  public void start(){
    
    try{

    createWindow();
    Keyboard.create();
 
    initGL();
    fp.gameLoop();
    
    }catch(Exception e){
        e.printStackTrace();
    }
  }
  public void destroy() {
    Keyboard.destroy();
    Display.destroy();
  }
  
   private void createWindow() throws Exception{
       displayMode = new DisplayMode(DISPLAY_WIDTH, DISPLAY_HEIGHT);
    Display.setDisplayMode(displayMode);
    Display.setFullscreen(false);
    Display.setTitle("Program 3");
    Display.create();
    }
   
    
   
   public void initGL() {
    glClearColor(0.0f,0.0f,0.0f,0.0f);
    
    glMatrixMode(GL_PROJECTION);
      glLoadIdentity();
       gluPerspective(
          45.0f,
          (float) displayMode.getWidth() / (float) displayMode.getHeight(),
          0.1f,
          100.0f);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
    glOrtho(0,640,0,480,1,-1);
    glMatrixMode(GL_MODELVIEW);
     glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
  }
    
}
