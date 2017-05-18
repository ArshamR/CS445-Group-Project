public class Textures {
    float offset;
    
    public Textures(float offset) {
        this.offset = offset;
    }
    
    float[] grass() {
        return new float[] {
      
            
            // TOP!
            offset*3, offset*1,
             offset*2, offset*1,
             offset*2, offset*0,
             offset*3, offset*0,
             // BOTTOM QUAD(DOWN=+Y)
             offset*3, offset*0,
             offset*2, offset*0,
            offset*2, offset*1,
             offset*3, offset*1,
            // FRONT QUAD
             offset*3, offset*0,
             offset*4, offset*0,
             offset*4, offset*1,
             offset*3, offset*1,
            // BACK QUAD
            offset*4, offset*1,
            offset*3, offset*1,
             offset*3, offset*0,
             offset*4, offset*0,
            // LEFT QUAD
             offset*3, offset*0,
             offset*4, offset*0,
             offset*4, offset*1,
            offset*3, offset*1,
            // RIGHT QUAD
            offset*3, offset*0,
            offset*4, offset*0,
            offset*4, offset*1,
            offset*3, offset*1};

    }
    
    float[] sand() {
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
            offset*2, offset*11,
            offset*3, offset*11,
            offset*3, offset*12,
            offset*2, offset*12,
            // Back
            offset*3, offset*12,
            offset*2, offset*12,
            offset*2, offset*11,
            offset*3, offset*11,
            // Left
            offset*2, offset*11,
            offset*3, offset*11,
            offset*3, offset*12,
            offset*2, offset*12,
            // Right
            offset*2, offset*11,
            offset*3, offset*11,
            offset*3, offset*12,
            offset*2, offset*12};
       
    }
    
    float[] dirt() {
        return new float[] {
            // Top
            offset*3, offset*1,
             offset*2, offset*1,
             offset*2, offset*0,
             offset*3, offset*0,
             // BOTTOM QUAD(DOWN=+Y)
             offset*3, offset*0,
             offset*2, offset*0,
            offset*2, offset*1,
             offset*3, offset*1,
            // FRONT QUAD
             offset*2, offset*0,
             offset*3, offset*0,
             offset*3, offset*1,
             offset*2, offset*1,
            // BACK QUAD
            offset*3, offset*1,
            offset*2, offset*1,
             offset*2, offset*0,
             offset*3, offset*0,
            // LEFT QUAD
             offset*2, offset*0,
             offset*3, offset*0,
             offset*3, offset*1,
            offset*2, offset*1,
            // RIGHT QUAD
            offset*2, offset*0,
            offset*3, offset*0,
            offset*3, offset*1,
            offset*2, offset*1};
    }
    
    float[] stone() {
        return new float[] {
            offset*2, offset*1,
             offset*1, offset*1,
             offset*1, offset*0,
             offset*2, offset*0,
             // BOTTOM QUAD(DOWN=+Y)
             offset*2, offset*0,
             offset*1, offset*0,
            offset*1, offset*1,
             offset*2, offset*1,
            // FRONT QUAD
             offset*1, offset*0,
             offset*2, offset*0,
             offset*2, offset*1,
             offset*1, offset*1,
            // BACK QUAD
            offset*2, offset*1,
            offset*1, offset*1,
             offset*1, offset*0,
             offset*2, offset*0,
            // LEFT QUAD
             offset*1, offset*0,
             offset*2, offset*0,
             offset*1, offset*1,
            offset*1, offset*1,
            // RIGHT QUAD
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
             // BOTTOM QUAD(DOWN=+Y)
             offset*2, offset*1,
             offset*1, offset*1,
            offset*1, offset*2,
             offset*2, offset*2,
            // FRONT QUAD
             offset*1, offset*1,
             offset*2, offset*1,
             offset*2, offset*2,
             offset*1, offset*2,
            // BACK QUAD
            offset*2, offset*2,
            offset*1, offset*2,
             offset*1, offset*1,
             offset*2, offset*1,
            // LEFT QUAD
             offset*1, offset*1,
             offset*2, offset*1,
             offset*1, offset*2,
            offset*1, offset*2,
            // RIGHT QUAD
            offset*1, offset*1,
            offset*2, offset*1,
            offset*2, offset*2,
            offset*1, offset*2};
    }

}