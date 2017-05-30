/** *****************************************************************************
 * File: Main.java
 * Authors: Arsham Ravanipour
 *          John Quiros
 *          Cesar Pedroza
 *          William Wells
 *
 * Class CS 445 - Computer Graphics
 *
 * Assignment: Quarter Project - Check Point 1
 * Date last modified: 5/17/2017
 *
 * Purpose: Draws a cube and allows the user to control the camera and move
 * around using w,a,s,d,e and space.
 ***************************************************************************** */

import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import static org.lwjgl.util.glu.GLU.gluPerspective;


public class Main {
    public static final int DISPLAY_HEIGHT = 480;
    public static final int DISPLAY_WIDTH = 640;
    private DisplayMode displayMode;
    private FPCameraController fp;
    
    private FloatBuffer lightPosition;
    private FloatBuffer whiteLight;

    public static void main(String[] args) {
        Main main = null;
        main = new Main();
        main.start();
    }

    public void start() {
        try {
            createWindow();
            Keyboard.create();

            initGL();
            fp  = new FPCameraController(0F, 0F, 0F);
            fp.gameLoop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        Keyboard.destroy();
        Display.destroy();
    }

    //Creates the window
    private void createWindow() throws Exception {
        displayMode = new DisplayMode(DISPLAY_WIDTH, DISPLAY_HEIGHT);
        Display.setDisplayMode(displayMode);
        //Enable this to fix screen-ripping issue on certain monitors
//        Display.setVSyncEnabled(true);
        Display.setFullscreen(false);
        Display.setTitle("Quarter Project - Check Point 1");
        Display.create();
    }

    public void initGL() {
glEnable(GL_DEPTH_TEST);
        glDepthFunc(GL_LEQUAL);
        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        GLU.gluPerspective(100f, (float) Display.getWidth() / (float) Display.getHeight(), 0.1f, 300f);
        glMatrixMode(GL_MODELVIEW);
        glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
		
		glEnableClientState(GL_VERTEX_ARRAY);
		glEnableClientState(GL_COLOR_ARRAY);
		glEnable(GL_DEPTH_TEST);
		
		glEnable(GL_TEXTURE_2D);
		glEnableClientState(GL_TEXTURE_COORD_ARRAY);
		
		initLightArrays();
		glLight(GL_LIGHT0, GL_POSITION, lightPosition);
		glLight(GL_LIGHT0, GL_SPECULAR, whiteLight);
		glLight(GL_LIGHT0, GL_DIFFUSE, whiteLight);
		glLight(GL_LIGHT0, GL_AMBIENT, whiteLight);
		
		glEnable(GL_LIGHTING);
		glEnable(GL_LIGHT0);
    }
    
    private void initLightArrays() {
	lightPosition = BufferUtils.createFloatBuffer(4);
	lightPosition.put(0f).put(0f).put(0f).put(1f).flip();
		
	whiteLight = BufferUtils.createFloatBuffer(4);
	whiteLight.put(1f).put(1f).put(1f).put(0f).flip();

    }

}
