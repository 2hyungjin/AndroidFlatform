package org.techtown.tetris;

public class Blocks {
    static char[][][] block_L = {
            {       {0, 0, 0, 0},
                    {0, 1, 0, 0},
                    {0, 1, 1, 1},
                    {0, 0, 0, 0}
            },
            {       {0, 0, 0, 0},
                    {0, 1, 1, 0},
                    {0, 1, 0, 0},
                    {0, 1, 0, 0}
            },
            {       {0, 0, 0, 0},
                    {1, 1, 1, 0},
                    {0, 0, 1, 0},
                    {0, 0, 0, 0}
            },
            {       {0, 0, 1, 0},
                    {0, 0, 1, 0},
                    {0, 1, 1, 0},
                    {0, 0, 0, 0}
            }
    };
    static char[][] background = {
            {1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,1},
            {1,1,1,1,1,1,1,1,1,1,1,1},
    };

}