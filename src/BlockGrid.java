// ---------------------------------------------------------
// Project name: Tetris
// Class added by John Spink on 17/12/2018
// ---------------------------------------------------------

import java.awt.*;

public class BlockGrid {

    public static final int BLOCK_SIDE = 25;
    public static final Color BACKGROUND_COLOR = Color.WHITE;

    private Color[][] blocks;
    private Color currentColor = BACKGROUND_COLOR;

    public BlockGrid(int width, int height)
    {
        blocks = new Color[width][height];
    }

    public void drawSquare(int x, int y)
    {
        try
        {
            blocks[x][y] = currentColor;
        }
        catch(Exception ex)
        {
        }
    }

    public void setColor(Color color)
    {
        currentColor = color;
    }

    public int getWidth()
    {
        return blocks.length;
    }

    public int getHeight()
    {
        return blocks[0].length;
    }

    public int getGraphicsWidth()
    {
        return getWidth()*BLOCK_SIDE;
    }

    public int getGraphicsHeight()
    {
        return getHeight()*BLOCK_SIDE;
    }

    public void clear()
    {
        blocks = new Color[blocks.length][blocks[0].length];
    }

    public void draw(Graphics g)
    {
        for(int i = 0; i < blocks.length; i++)
        {
            for(int j = 0; j < blocks[0].length; j++)
            {
                if(blocks[i][j] != null)
                    g.setColor(blocks[i][j]);
                else
                    g.setColor(BACKGROUND_COLOR);
                g.fillRect(i*BLOCK_SIDE, j*BLOCK_SIDE, BLOCK_SIDE-1, BLOCK_SIDE-1);
                g.setColor(Color.BLACK);
                g.drawRect(i*BLOCK_SIDE, j*BLOCK_SIDE, BLOCK_SIDE-1, BLOCK_SIDE-1);
            }
        }
    }

    public String toString()
    {
        String ret = "";
        for(int j = 0; j < blocks[0].length; j++)
        {
            if(j != 0)
                ret+="\n";
            for(int i = 0; i < blocks.length; i++)
            {
                if(blocks[i][j] != null)
                    ret+="#";
                else
                    ret+="-";
            }
        }
        return ret;
    }
}
