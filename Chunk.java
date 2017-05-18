import java.nio.FloatBuffer;
import java.util.Random;
import org.lwjgl.BufferUtils;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;


public class Chunk{
    
    static final int CHUNK_SIZE =35;
    static final int CUBE_LENGTH = 2;
    private Block[][][] Blocks;
    private int VBOVertexHandle;
    private int VBOColorHandle;
    private int StartX;
    private int StartY;
    private int StartZ;
    private Random r;
    
    public void render(){
        glPushMatrix();
            glBindBuffer(GL_ARRAY_BUFFER,VBOVertexHandle);
            glVertexPointer(3,GL_FLOAT,0,0L);
            glBindBuffer(GL_ARRAY_BUFFER,VBOColorHandle);
            glColorPointer(3,GL_FLOAT,0,0L);
            glDrawArrays(GL_QUADS, 0,CHUNK_SIZE * CHUNK_SIZE * CHUNK_SIZE * 24);
        glPopMatrix();
    }
    
    public void rebuildMesh(float startX, float startY, float startZ){
        VBOColorHandle = glGenBuffers();
        VBOVertexHandle = glGenBuffers();
        int seed = r.nextInt(5000 - 300 + 1) + 300;
        SimplexNoise noise = new SimplexNoise(128,.1, seed);
        
        
        FloatBuffer vertexPositionData = BufferUtils.createFloatBuffer(
                    (CHUNK_SIZE * CHUNK_SIZE * CHUNK_SIZE) * 6 * 12);
        FloatBuffer vertexColorData = BufferUtils.createFloatBuffer(
                    (CHUNK_SIZE * CHUNK_SIZE * CHUNK_SIZE) * 6 * 12);
        
        for(float x = 0; x < CHUNK_SIZE; x++){
            for(float z=0; z < CHUNK_SIZE; z++){
                float height;
                int i;
                int j;
                i = (int)(startX + x * ((300 -startX) / 480));
                j = (int)(startZ + z * ((300 -startZ) / 640));
                height = (startY + (int)(100.0 * noise.getNoise(i,j)) * CUBE_LENGTH);
                //System.out.println("StartX: " + startX + " StartY: " + startY +" StartZ: " +  startZ);
               System.out.println("I: " + i + " J: " + j +" height:" +  height);

                for(float y =0; y<=height; y++){
                    if(y < CHUNK_SIZE){
                            vertexPositionData.put(createCube((startX + x*CUBE_LENGTH),
                            ((float)(CHUNK_SIZE* -1) + y*CUBE_LENGTH),
                            (startZ - z*CUBE_LENGTH))); 
                                  System.out.println("X: "  + x +" Z: " +  z  + " Y: " + y );
                                  
            vertexColorData.put(createCubeVertexCol(getCubeColor(Blocks[(int)x][(int) y][(int) z])));
                    }
            
            }
        }
        }
        vertexColorData.flip();
        vertexPositionData.flip();
        glBindBuffer(GL_ARRAY_BUFFER, VBOVertexHandle);
        glBufferData(GL_ARRAY_BUFFER, vertexPositionData, GL_STATIC_DRAW);
        glBindBuffer(GL_ARRAY_BUFFER,0);
        glBindBuffer(GL_ARRAY_BUFFER, VBOColorHandle);
        glBufferData(GL_ARRAY_BUFFER,vertexColorData,GL_STATIC_DRAW);
        glBindBuffer(GL_ARRAY_BUFFER,0);
        
    }
    private float[] createCubeVertexCol(float[] CubeColorArray) {
        float[] cubeColors = new float[CubeColorArray.length * 4 * 6];
        
        for (int i = 0; i < cubeColors.length; i++) {
            cubeColors[i] = CubeColorArray[i %
            CubeColorArray.length];
        }
        return cubeColors;
    }
    
    public static float[] createCube(float x, float y, float z) {
        int offset = CUBE_LENGTH / 2;
        return new float[] {
        // TOP QUAD
        x + offset, y + offset, z,
        x - offset, y + offset, z,
        x - offset, y + offset, z - CUBE_LENGTH,
        x + offset, y + offset, z - CUBE_LENGTH,
        // BOTTOM QUAD
        x + offset, y - offset, z - CUBE_LENGTH,
        x - offset, y - offset, z - CUBE_LENGTH,
        x - offset, y - offset, z,
        x + offset, y - offset, z,
        // FRONT QUAD
        x + offset, y + offset, z - CUBE_LENGTH,
        x - offset, y + offset, z - CUBE_LENGTH,
        x - offset, y - offset, z - CUBE_LENGTH,
        x + offset, y - offset, z - CUBE_LENGTH,
        // BACK QUAD
        x + offset, y - offset, z,
        x - offset, y - offset, z,
        x - offset, y + offset, z,
        x + offset, y + offset, z,
        // LEFT QUAD
        x - offset, y + offset, z - CUBE_LENGTH,
        x - offset, y + offset, z,
        x - offset, y - offset, z,
        x - offset, y - offset, z - CUBE_LENGTH,
        // RIGHT QUAD
        x + offset, y + offset, z,
        x + offset, y + offset, z - CUBE_LENGTH,
        x + offset, y - offset, z - CUBE_LENGTH,
        x + offset, y - offset, z };
    }
    private float[] getCubeColor(Block block) {
        switch (block.getId()) {
            case 1:
            return new float[] { 0, 1, 0 };
            case 2:
            return new float[] { 1, 0.5f, 0 };
            case 3:
            return new float[] { 0, 0f, 1f };
        }
        return new float[] { 1, 1, 1 };

}
    public Chunk(int startX, int startY, int startZ) {
        r= new Random();
        Blocks = new
        Block[CHUNK_SIZE][CHUNK_SIZE][CHUNK_SIZE];
        for (int x = 0; x < CHUNK_SIZE; x++) {
            for (int y = 0; y < CHUNK_SIZE; y++) {
                for (int z = 0; z < CHUNK_SIZE; z++) {
                    if(r.nextFloat()>0.7f){
                        Blocks[x][y][z] = new
                        Block(Block.BlockType.BlockType_Grass);
                    }else if(r.nextFloat()>0.4f){
                        Blocks[x][y][z] = new
                        Block(Block.BlockType.BlockType_Dirt);
                    }else if(r.nextFloat()>0.2f){
                        Blocks[x][y][z] = new
                        Block(Block.BlockType.BlockType_Water);
                    }
                    else{
                        Blocks[x][y][z] = new
                        Block(Block.BlockType.BlockType_Default);
                    }
                }
            }
        }
        VBOColorHandle = glGenBuffers();
        VBOVertexHandle = glGenBuffers();
        StartX = startX;
        StartY = startY;
        StartZ = startZ;
        rebuildMesh(startX, startY, startZ);
    }
}
