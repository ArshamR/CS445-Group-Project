/*******************************************************************************
 * File Block.java
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
public class Block {
    private boolean IsActive;
    private BlockType Type;
private float x,y,z;
public enum BlockType
{
    BlockType_Grass(0),
    BlockType_Sand(1),
    BlockType_Water(2),
    BlockType_Dirt(3),
    BlockType_Stone(4),
    BlockType_Bedrock(5),
    BlockType_Default(6);

    private int BlockID;

    BlockType(int i) {
        BlockID =i;
    }
    public int GetID(){
        return BlockID;
    }
    public void SetID(int i){
        BlockID = i;
    }
}

    public Block(BlockType type ){
        Type = type;
    }

    public void setCoords(float x, float y, float z){
        this.x =x;
        this.y = y;
        this.z=z;
    }

    public boolean isActive(){
        return IsActive;
    }

    public void setActive(boolean active){
        IsActive = active;
    }

    public int getId(){
        return Type.GetID();
    }
}