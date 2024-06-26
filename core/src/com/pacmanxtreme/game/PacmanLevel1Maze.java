package com.pacmanxtreme.game;

public class PacmanLevel1Maze {
    // Define wall positions for Pac-Man level 1 maze
    //{x position , y position, width (change of x), height (change of y) }
    //max range
    //x: 640
    //y: 480
    //x mid: 320
    // y mid: 240


    public static final int[][] WALL_POSITIONS = {
//            1.
           {0, 308, 10, 130},
//            2.
           {0, 308, 120,5},
//            3.
           {115, 260, 10, 53},
//            4.
           {0, 260, 120, 5},
//            5.
           {0, 230, 122, 5},
//            6.
           {115, 180, 10, 53},
//            7.
           {0, 180, 120, 5},
//            8.
           {0, 25, 10, 160},
//            9.
            {0, 100, 60, 12},
//            10.
            {0, 25, 640, 10},
//            11.
            {630, 25, 10, 160},
//            12.
            {580, 100, 60, 12},
//            13.
            {513, 180, 130, 5},
//            14.
            {513, 180, 10, 53},
//            15.
            {513, 230, 130, 5},
//            16.
            {513, 260, 130, 5},
//            17.
           {513, 260, 10, 53},
//            18.
            {513, 308, 130, 5},
//            19.
           {630, 308, 10, 130},
//            20.
            {0, 438, 640, 10},
//            21.
           {310, 380, 20, 60},
//            22.
//            Mistake
//            23.
//            Mistake
//            24.
            {55, 380, 70, 28},
//            25.
            {55, 340, 75, 15},
//            26.
           {170, 380, 93, 28},
//            27.
            {170, 260, 23, 92},
//            28.
            {170, 300, 93, 13},
//            29.
            {170, 180, 23, 53},
//            30.
            {55, 140, 70, 15},
//            31.
            {105, 100, 20, 50},
//            32.
            {55, 60, 205, 15},
//            33.
            {170, 60, 23, 55},
//            34.
            {170, 140 , 93, 13},
//            35.
            {240, 100, 160, 13},
//            36.
            {310, 60, 20, 50},
//            37.
            {375, 60, 205, 15},
//            38.
            {445, 60, 23, 55},
//            39.
            {513, 100, 20, 50},
//            40.
            {513, 140, 70, 15},
//            41.
            {375, 140 , 93, 13},
//            42.
            {310, 140, 20, 50},
//            43.
            {240, 180, 160, 13},
//            44.
            {445, 180, 23, 53},
//            45.
            {445, 260, 23, 92},
//            46.
            {375, 300, 93, 13},
//            47.
            {513, 340, 75, 15},
//            48.
            {513, 380, 70, 28},
//            49.
            {375, 380, 93, 28},
//            50.
            {240, 340, 160, 13},
//            51.
            {310, 300, 20, 50},
//            52.
            {240, 268, 55, 10},
//            53.
            {240, 220, 10, 48},
//            54.
            {240, 220, 155, 10},
//            55.
            {390, 220, 10, 48},
//            56.
            {340, 268, 60, 10},
    };

    public static int[][] getWallPositions() {
        return WALL_POSITIONS;
    }


    private static final int[][] COIN_POSITIONS = {
            //Red

//            1.
            {34,420},
//            2.
            {57, 420},
//            3.
            {80, 420},
//            4.
            {103, 420},
//            5.
            {126, 420},
//            6.
            {149, 420},
//            7.
            {172, 420},
//            8.
            {195, 420},
//            9.
            {218, 420},
//            10.
            {241, 420},
//            11.
            {264, 420},
//            12.
            {286, 420},
//            13.
            {286, 406},
//            14.
            {286, 392},
//            15.
            {286, 378},
//            16.
            {286, 365},
//            17.
            {309, 365},
//            18.
            {332, 365},
//            19.
            {354, 365},
//            20.
            {354, 378},
//            21.
            {354, 392},
//            22.
            {354, 406},
//            23.
            {354, 420},
//            24.
            {377, 420},
//            25.
            {400, 420},
//            26.
            {423, 420},
//            27.
            {446, 420},
//            28.
            {469, 420},
//            29.
            {492, 420},
//            30.
            {514, 420},
//            31.
            {537, 420},
//            32.
            {560, 420},
//            33.
            {583, 420},
//            34.
            {606, 420},
//            35.
            {606, 406},
//            36.
            {606, 380},
//            37.
            {606, 365},
//            38.
            {606, 353},
//            39.
            {606, 340},
//            40.
            {606, 325},
//            41.
            {583, 325},
//            42.
            {560, 325},
//            43.
            {537, 325},
//            44.
            {514, 325},
//            45.
            {492, 325},
//            46.
            {492, 312},
//            47.
            {492, 300},
//            48.
            {492, 285},
//            49.
            {492, 273},
//            50.
            {492, 259},
//            51.
            {492, 245},
//            52.
            {492, 233},
//            53.
            {492, 219},
//            54.
            {492, 205},
//            55.
            {492, 191},
//            56.
            {492, 179},
//            57.
            {492, 165},
//            58.
            {514, 165},
//            59.
            {537, 165},
//            60.
            {560, 165},
//            61.
            {583, 165},
//            62.
            {606, 165},
//            63.
            {606, 153},
//            64.
            {606, 139},
//            65.
            {583, 127},
//            66.
            {560, 127},
//            67.
            {560, 113},
//            68.
            {560, 99},
//            69.
            {560, 85},
//            70.
            {583, 85},
//            71.
            {606, 85},
//            72.
            {606, 73},
//            73.
            {606, 59},
//            74.
            {606, 45},
//            75.
            {583, 45},
//            76.
            {560, 45},
//            77.
            {537, 45},
//            78.
            {514, 45},
//            79.
            {491, 45},
//            80.
            {468, 45},
//            81.
            {446, 45},
//            82.
            {423, 45},
//            83.
            {400, 45},
//            84.
            {377, 45},
//            85.
            {354, 45},
//            86.
            {331, 45},
//            87.
            {308, 45},
//            88.
            {286, 45},
//            89.
            {263, 45},
//            90.
            {240, 45},
//            91.
            {217, 45},
//            92.
            {194, 45},
//            93.
            {171, 45},
//            94.
            {148, 45},
//            95.
            {126, 45},
//            96.
            {103, 45},
//            97.
            {80, 45},
//            98.
            {57, 45},
//            99.
            {34, 45},
//            100.
            {34, 59},
//            101.
            {34, 73},
//            102.
            {34, 85},
//            103.
            {57, 85},
//            104.
            {80, 99},
//            105.
            {80, 113},
//            106.
            {80, 127},
//            107.
            {57, 127},
//            108.
            {34, 139},
//            109.
            {34, 153},
//            110.
            {34, 165},
//            111.
            {57, 165},
//            112.
            {80, 165},
//            113.
            {103, 165},
//            114.
            {126, 165},
//            115.
            {149, 165},
//            116.
            {149, 179},
//            117.
            {149, 191},
//            118.
            {149, 205},
//            119.
            {149, 219},
//            120.
            {149, 233},
//            121.
            {149, 245},
//            122.
            {149, 259},
//            123.
            {149, 273},
//            124.
            {149, 285},
//            125.
            {149, 300},
//            126.
            {149, 312},
//            127.
            {149, 325},
//            128.
            {126, 325},
//            129.
            {103, 325},
//            130.
            {80, 325},
//            131.
            {57, 325},
//            132.
            {34, 325},
//            133.
            {34, 338},
//            134.
            {34, 352},
//            135.
            {34, 365},
//            136.
            {34, 378},
//            137.
            {34, 406},


            //blue

//            1.
            {57, 365},
//            2.
            {80, 365},
//            3.
            {103, 365},
//            4.
            {126, 365},
//            5.
            {149, 365},
//            6.
            {172, 365},
//            7.
            {194, 365},
//            8.
            {217, 365},
//            9.
            {240, 365},
//            10.
            {263, 365},
//            11.
            {377, 365},
//            12.
            {400, 365},
//            13.
            {423, 365},
//            14.
            {446, 365},
//            15.
            {469, 365},
//            16.
            {492, 365},
//            17.
            {514, 365},
//            18.
            {537, 365},
//            19.
            {560, 365},
//            20.
            {583, 365},
//            21.
            {149, 406},
//            22.
            {149, 392},
//            23.
            {149, 378},
//            24.
            {149, 352},
//            25.
            {149, 338},
//            26.
            {492, 406},
//            27.
            {492, 392},
//            28.
            {492, 378},
//            29.
            {492, 352},
//            30.
            {492, 338},
//            31.
            {217, 352},
//            32.
            {217, 338},
//            33.
            {217, 324},
//            34.
            {240, 324},
//            35.
            {263, 324},
//            36.
            {286, 324},
//            37.
            {354, 324},
//            38.
            {377, 324},
//            39.
            {400, 324},
//            40.
            {423, 324},
//            41.
            {423, 338},
//            42.
            {423, 352},


            //magenta
//            1.
            {80, 85},
//            2.
            {103, 85},
//            3.
            {126, 85},
//            4.
            {149, 85},
//            5.
            {149, 99},
//            6.
            {149, 113},
//            7.
            {149, 127},
//            8.
            {149, 141},
//            9.
            {149, 153},
//            10.
            {172, 165},
//            11.
            {194, 165},
//            12.
            {217, 165},
//            13.
            {240, 165},
//            14.
            {263, 165},
//            15.
            {286, 165},
//            16.
            {286, 153},
//            17.
            {286, 141},
//            17 1/2.
            {286, 127},
//            18.
            {263, 127},
//            19.
            {240, 127},
//            20.
            {217, 127},
//            21.
            {194, 127},
//            22.
            {171, 127},
//            23.
            {217, 113},
//            24.
            {217, 99},
//            25.
            {217, 85},
//            26.
            {240, 85},
//            27.
            {263, 85},
//            28.
            {286, 85},
//            29.
            {286, 72},
//            30.
            {286, 58},
//            31.
            {354, 58},
//            32.
            {354, 72},
//            33.
            {354, 85},
//            34.
            {377, 85},
//            35.
            {400, 85},
//            36.
            {423, 85},
//            37.
            {423, 99},
//            38.
            {423, 113},
//            39.
            {423, 127},
//            40.
            {400, 127},
//            41.
            {377, 127},
//            42.
            {354, 127},
//            43.
            {354, 141},
//            44.
            {354, 155},
//            45.
            {354, 169},
//            46.
            {377, 169},
//            47.
            {400, 169},
//            48.
            {423, 169},
//            49.
            {446, 169},
//            50.
            {469, 169},

//            51.
            {492, 153},
//            52.
            {492, 139},
//            53.
            {492, 125},
//            54.
            {469, 127},
//            55.
            {446, 127},
//            56.
            {492, 113},
//            57.
            {492, 99},
//            58.
            {492, 85},
//            59.
            {514, 85},
//            60.
            {537, 85},



    };

    public static int [][] getCoinPositions() {return COIN_POSITIONS;}
}