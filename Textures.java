/*******************************************************************************
 * File Textures.java
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
 ******************************************************************************/
public class Textures {
    float offset;
    
    public Textures(float offset) {
        this.offset = offset;
    }
    
    float[] grass() {
        return new float[] {
      
            
            // Top
            offset*3, offset*1,
             offset*2, offset*1,
             offset*2, offset*0,
             offset*3, offset*0,
             // Bottom 
             offset*3, offset*0,
             offset*2, offset*0,
            offset*2, offset*1,
             offset*3, offset*1,
            // FRONT 
             offset*3, offset*0,
             offset*4, offset*0,
             offset*4, offset*1,
             offset*3, offset*1,
            // BACK 
            offset*4, offset*1,
            offset*3, offset*1,
             offset*3, offset*0,
             offset*4, offset*0,
            // LEFT 
             offset*3, offset*0,
             offset*4, offset*0,
             offset*4, offset*1,
            offset*3, offset*1,
            // RIGHT 
            offset*3, offset*0,
            offset*4, offset*0,
            offset*4, offset*1,
            offset*3, offset*1};

    }
    
    float[] sand() {
        return new float[] {
            // Top
            offset*3, offset*11,
            offset*2, offset*11,
            offset*2, offset*10,
            offset*3, offset*10,
            // Bottom
            offset*3, offset*10,
            offset*2, offset*10,
            offset*2, offset*11,
            offset*3, offset*11,
            // Front
            offset*2, offset*10,
            offset*3, offset*10,
            offset*3, offset*11,
            offset*2, offset*11,
            // Back
            offset*3, offset*11,
            offset*2, offset*11,
            offset*2, offset*10,
            offset*3, offset*10,
            // Left
            offset*2, offset*10,
            offset*3, offset*10,
            offset*3, offset*11,
            offset*2, offset*11,
            // Right
            offset*2, offset*10,
            offset*3, offset*10,
            offset*3, offset*11,
            offset*2, offset*11};
    }
    
    float[] water() {
        return new float[] {
            // Top
            offset*2, offset*12,
            offset*1, offset*12,
            offset*1, offset*11,
            offset*2, offset*11,
            // Bottom
            offset*2, offset*11,
            offset*1, offset*11,
            offset*1, offset*12,
            offset*2, offset*12,
            // Front
            offset*1, offset*11,
            offset*2, offset*11,
            offset*2, offset*12,
            offset*1, offset*12,
            // Back
            offset*2, offset*12,
            offset*1, offset*12,
            offset*1, offset*11,
            offset*2, offset*11,
            // Left
            offset*1, offset*11,
            offset*2, offset*11,
            offset*2, offset*12,
            offset*1, offset*12,
            // Right
            offset*1, offset*11,
            offset*2, offset*11,
            offset*2, offset*12,
            offset*1, offset*12};
       
    }
    
    float[] dirt() {
        return new float[] {
            // Top
             offset*2, offset*11,
            offset*1, offset*11,
            offset*1, offset*10,
            offset*2, offset*10,
            // Bottom
            offset*2, offset*10,
            offset*1, offset*10,
            offset*1, offset*11,
            offset*2, offset*11,
            // Front
            offset*1, offset*10,
            offset*2, offset*10,
            offset*2, offset*11,
            offset*1, offset*11,
            // Back
            offset*2, offset*11,
            offset*1, offset*11,
            offset*1, offset*10,
            offset*2, offset*10,
            // Left
            offset*1, offset*10,
            offset*2, offset*10,
            offset*2, offset*11,
            offset*1, offset*11,
            // Right
            offset*1, offset*10,
            offset*2, offset*10,
            offset*2, offset*11,
            offset*1, offset*11};
    }
    
    float[] stone() {
        return new float[] {
            offset*2, offset*1,
             offset*1, offset*1,
             offset*1, offset*0,
             offset*2, offset*0,
             // BOTTOM 
             offset*2, offset*0,
             offset*1, offset*0,
            offset*1, offset*1,
             offset*2, offset*1,
            // FRONT 
             offset*1, offset*0,
             offset*2, offset*0,
             offset*2, offset*1,
             offset*1, offset*1,
            // BACK 
            offset*2, offset*1,
            offset*1, offset*1,
             offset*1, offset*0,
             offset*2, offset*0,
            // LEFT 
             offset*1, offset*0,
             offset*2, offset*0,
             offset*1, offset*1,
            offset*1, offset*1,
            // RIGHT 
            offset*1, offset*0,
            offset*2, offset*0,
            offset*2, offset*1,
            offset*1, offset*1};
    }
    
    float[] bedrock() {
        return new float[] {
           offset*2, offset*2,
             offset*1, offset*2,
             offset*1, offset*1,
             offset*2, offset*1,
             // BOTTOM 
             offset*2, offset*1,
             offset*1, offset*1,
            offset*1, offset*2,
             offset*2, offset*2,
            // FRONT 
             offset*1, offset*1,
             offset*2, offset*1,
             offset*2, offset*2,
             offset*1, offset*2,
            // BACK 
            offset*2, offset*2,
            offset*1, offset*2,
             offset*1, offset*1,
             offset*2, offset*1,
            // LEFT 
             offset*1, offset*1,
             offset*2, offset*1,
             offset*1, offset*2,
            offset*1, offset*2,
            // RIGHT 
            offset*1, offset*1,
            offset*2, offset*1,
            offset*2, offset*2,
            offset*1, offset*2};
    }

}