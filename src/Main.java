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
import static org.lwjgl.util.glu.GLU.gluPerspective;


public class Main {
    public static final int DISPLAY_HEIGHT = 480;
    public static final int DISPLAY_WIDTH = 640;
    private DisplayMode displayMode;
    private FPCameraController fp;

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
        
        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        glEnableClientState(GL_VERTEX_ARRAY);
        glEnableClientState(GL_COLOR_ARRAY);
        
        glEnable(GL_TEXTURE_2D);
        glEnableClientState (GL_TEXTURE_COORD_ARRAY);
        glEnable(GL_DEPTH_TEST);
        
        glEnable(GL_CULL_FACE);
        glCullFace(GL_FRONT);
        glEnable(GL_DEPTH_TEST);
        
        initLightArrays();

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        gluPerspective(
                100.0f, (float) displayMode.getWidth()
                / (float) displayMode.getHeight(), 0.1f, 300.0f);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        glMatrixMode(GL_MODELVIEW);
        glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
    }
    
    private void initLightArrays() {
        FloatBuffer lightPosition = BufferUtils.createFloatBuffer(4);
        lightPosition.put(0.2f).put(-0.2f).put(0.0f).put(1.0f).flip();
        FloatBuffer ambient = BufferUtils.createFloatBuffer(4);
        ambient.put(0.3f).put(0.3f).put(0.3f).put(1f).flip();
        FloatBuffer diffuse = BufferUtils.createFloatBuffer(4);
        diffuse.put(1f).put(1f).put(1f).put(1.0f).flip();
        FloatBuffer specular = BufferUtils.createFloatBuffer(4);
        specular.put(0.8f).put(0.8f).put(0.8f).put(1.0f).flip();
        
        glLight(GL_LIGHT0, GL_POSITION, lightPosition); //sets our light’s position
        glLight(GL_LIGHT0, GL_SPECULAR, specular);//sets our specular light
        glLight(GL_LIGHT0, GL_DIFFUSE, diffuse);//sets our diffuse light
        glLight(GL_LIGHT0, GL_AMBIENT, ambient);//sets our ambient light
        glEnable(GL_LIGHTING);//enables our lighting
        glEnable(GL_LIGHT0);//enables light0

    }

}