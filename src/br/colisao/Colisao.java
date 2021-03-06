package br.colisao;

import br.Game;

import java.awt.*;

public class Colisao {
    public static Rectangle[] colisaoOver = {
            new Rectangle(-Game.ESCALA, -Game.ESCALA, 17 * Game.ESCALA, 1417 * Game.ESCALA),
            new Rectangle(-Game.ESCALA, 1384 * Game.ESCALA - Game.ESCALA, 4113 * Game.ESCALA, 33 * Game.ESCALA),
            new Rectangle(-Game.ESCALA, -Game.ESCALA, 1217 * Game.ESCALA, 33 * Game.ESCALA),
            new Rectangle(17 * Game.ESCALA - Game.ESCALA, 33 * Game.ESCALA - Game.ESCALA, 95 * Game.ESCALA, 177 * Game.ESCALA),
            new Rectangle(1241 * Game.ESCALA - Game.ESCALA, -Game.ESCALA, 1358 * Game.ESCALA, 33 * Game.ESCALA),
            new Rectangle(2623 * Game.ESCALA - Game.ESCALA, -Game.ESCALA, 586 * Game.ESCALA, 33 * Game.ESCALA),
            new Rectangle(3233 * Game.ESCALA - Game.ESCALA, -Game.ESCALA, 880 * Game.ESCALA, 33 * Game.ESCALA),
            new Rectangle(4080 * Game.ESCALA - Game.ESCALA, -Game.ESCALA, 33 * Game.ESCALA, 1417 * Game.ESCALA),
            new Rectangle(132 * Game.ESCALA - Game.ESCALA, 98 * Game.ESCALA - Game.ESCALA, 142 * Game.ESCALA, 112 * Game.ESCALA),
            new Rectangle(112 * Game.ESCALA - Game.ESCALA, 33 * Game.ESCALA - Game.ESCALA, 290 * Game.ESCALA, 48 * Game.ESCALA),
            new Rectangle(274 * Game.ESCALA - Game.ESCALA, 114 * Game.ESCALA - Game.ESCALA, 16 * Game.ESCALA, 31 * Game.ESCALA),
            new Rectangle(274 * Game.ESCALA - Game.ESCALA, 145 * Game.ESCALA - Game.ESCALA, 95 * Game.ESCALA, 65 * Game.ESCALA),
            new Rectangle(389 * Game.ESCALA - Game.ESCALA, 145 * Game.ESCALA - Game.ESCALA, 93 * Game.ESCALA, 65 * Game.ESCALA),
            new Rectangle(482 * Game.ESCALA - Game.ESCALA, 113 * Game.ESCALA - Game.ESCALA, 16 * Game.ESCALA, 113 * Game.ESCALA),
            new Rectangle(531 * Game.ESCALA - Game.ESCALA, 99 * Game.ESCALA - Game.ESCALA, 31 * Game.ESCALA, 159 * Game.ESCALA),
            new Rectangle(498 * Game.ESCALA - Game.ESCALA, 99 * Game.ESCALA - Game.ESCALA, 33 * Game.ESCALA, 497 * Game.ESCALA),
            new Rectangle(482 * Game.ESCALA - Game.ESCALA, 33 * Game.ESCALA - Game.ESCALA, 193 * Game.ESCALA, 46 * Game.ESCALA),
            new Rectangle(582 * Game.ESCALA - Game.ESCALA, 99 * Game.ESCALA - Game.ESCALA, 93 * Game.ESCALA, 111 * Game.ESCALA),
            new Rectangle(582 * Game.ESCALA - Game.ESCALA, 210 * Game.ESCALA - Game.ESCALA, 29 * Game.ESCALA, 48 * Game.ESCALA),
            new Rectangle(611 * Game.ESCALA - Game.ESCALA, 210 * Game.ESCALA - Game.ESCALA, 16 * Game.ESCALA, 31 * Game.ESCALA),
            new Rectangle(627 * Game.ESCALA - Game.ESCALA, 210 * Game.ESCALA - Game.ESCALA, 16 * Game.ESCALA, 15 * Game.ESCALA),
            new Rectangle(482 * Game.ESCALA - Game.ESCALA, 308 * Game.ESCALA - Game.ESCALA, 16 * Game.ESCALA, 288 * Game.ESCALA),
            new Rectangle(17 * Game.ESCALA - Game.ESCALA, 210 * Game.ESCALA - Game.ESCALA, 16 * Game.ESCALA, 31 * Game.ESCALA),
            new Rectangle(33 * Game.ESCALA - Game.ESCALA, 210 * Game.ESCALA - Game.ESCALA, 16 * Game.ESCALA, 15 * Game.ESCALA),
            new Rectangle(17 * Game.ESCALA - Game.ESCALA, 293 * Game.ESCALA - Game.ESCALA, 16 * Game.ESCALA, 1026 * Game.ESCALA),
            new Rectangle(33 * Game.ESCALA - Game.ESCALA, 309 * Game.ESCALA - Game.ESCALA, 16 * Game.ESCALA, 93 * Game.ESCALA),
            new Rectangle(49 * Game.ESCALA - Game.ESCALA, 324 * Game.ESCALA - Game.ESCALA, 433 * Game.ESCALA, 63 * Game.ESCALA),
            new Rectangle(225 * Game.ESCALA - Game.ESCALA, 501 * Game.ESCALA - Game.ESCALA, 65 * Game.ESCALA, 63 * Game.ESCALA),
            new Rectangle(225 * Game.ESCALA - Game.ESCALA, 678 * Game.ESCALA - Game.ESCALA, 65 * Game.ESCALA, 63 * Game.ESCALA),
            new Rectangle(33 * Game.ESCALA - Game.ESCALA, 855 * Game.ESCALA - Game.ESCALA, 190 * Game.ESCALA, 111 * Game.ESCALA),
            new Rectangle(33 * Game.ESCALA - Game.ESCALA, 840 * Game.ESCALA - Game.ESCALA, 15 * Game.ESCALA, 13 * Game.ESCALA),
            new Rectangle(241 * Game.ESCALA - Game.ESCALA, 855 * Game.ESCALA - Game.ESCALA, 33 * Game.ESCALA, 272 * Game.ESCALA),
            new Rectangle(255 * Game.ESCALA - Game.ESCALA, 1032 * Game.ESCALA - Game.ESCALA, 16 * Game.ESCALA, 79 * Game.ESCALA),
            new Rectangle(274 * Game.ESCALA - Game.ESCALA, 855 * Game.ESCALA - Game.ESCALA, 353 * Game.ESCALA, 63 * Game.ESCALA),
            new Rectangle(274 * Game.ESCALA - Game.ESCALA, 918 * Game.ESCALA - Game.ESCALA, 16 * Game.ESCALA, 16 * Game.ESCALA),
            new Rectangle(274 * Game.ESCALA - Game.ESCALA, 1017 * Game.ESCALA - Game.ESCALA, 16 * Game.ESCALA, 16 * Game.ESCALA),
            new Rectangle(274 * Game.ESCALA - Game.ESCALA, 1033 * Game.ESCALA - Game.ESCALA, 144 * Game.ESCALA, 94 * Game.ESCALA),
            new Rectangle(531 * Game.ESCALA - Game.ESCALA, 840 * Game.ESCALA - Game.ESCALA, 15 * Game.ESCALA, 15 * Game.ESCALA),
            new Rectangle(482 * Game.ESCALA - Game.ESCALA, 647 * Game.ESCALA - Game.ESCALA, 49 * Game.ESCALA, 208 * Game.ESCALA),
            new Rectangle(531 * Game.ESCALA - Game.ESCALA, 741 * Game.ESCALA - Game.ESCALA, 16 * Game.ESCALA, 15 * Game.ESCALA),
            new Rectangle(596 * Game.ESCALA - Game.ESCALA, 759 * Game.ESCALA - Game.ESCALA, 95 * Game.ESCALA, 62 * Game.ESCALA),
            new Rectangle(531 * Game.ESCALA - Game.ESCALA, 647 * Game.ESCALA - Game.ESCALA, 16 * Game.ESCALA, 16 * Game.ESCALA),
            new Rectangle(531 * Game.ESCALA - Game.ESCALA, 663 * Game.ESCALA - Game.ESCALA, 31 * Game.ESCALA, 15 * Game.ESCALA),
            new Rectangle(531 * Game.ESCALA - Game.ESCALA, 678 * Game.ESCALA - Game.ESCALA, 562 * Game.ESCALA, 63 * Game.ESCALA),
            new Rectangle(450 * Game.ESCALA - Game.ESCALA, 918 * Game.ESCALA - Game.ESCALA, 97 * Game.ESCALA, 32 * Game.ESCALA),
            new Rectangle(450 * Game.ESCALA - Game.ESCALA, 1001 * Game.ESCALA - Game.ESCALA, 97 * Game.ESCALA, 126 * Game.ESCALA),
            new Rectangle(547 * Game.ESCALA - Game.ESCALA, 1033 * Game.ESCALA - Game.ESCALA, 48 * Game.ESCALA, 94 * Game.ESCALA),
            new Rectangle(241 * Game.ESCALA - Game.ESCALA, 1178 * Game.ESCALA - Game.ESCALA, 177 * Game.ESCALA, 94 * Game.ESCALA),
            new Rectangle(196 * Game.ESCALA - Game.ESCALA, 1210 * Game.ESCALA - Game.ESCALA, 45 * Game.ESCALA, 62 * Game.ESCALA),
            new Rectangle(225 * Game.ESCALA - Game.ESCALA, 1194 * Game.ESCALA - Game.ESCALA, 16 * Game.ESCALA, 16 * Game.ESCALA),
            new Rectangle(174 * Game.ESCALA - Game.ESCALA, 1210 * Game.ESCALA - Game.ESCALA, 22 * Game.ESCALA, 46 * Game.ESCALA),
            new Rectangle(33 * Game.ESCALA - Game.ESCALA, 1210 * Game.ESCALA - Game.ESCALA, 141 * Game.ESCALA, 62 * Game.ESCALA),
            new Rectangle(33 * Game.ESCALA - Game.ESCALA, 1272 * Game.ESCALA - Game.ESCALA, 32 * Game.ESCALA, 16 * Game.ESCALA),
            new Rectangle(33 * Game.ESCALA - Game.ESCALA, 1288 * Game.ESCALA - Game.ESCALA, 16 * Game.ESCALA, 15 * Game.ESCALA),
            new Rectangle(17 * Game.ESCALA - Game.ESCALA, 1339 * Game.ESCALA - Game.ESCALA, 16 * Game.ESCALA, 45 * Game.ESCALA),
            new Rectangle(33 * Game.ESCALA - Game.ESCALA, 1355 * Game.ESCALA - Game.ESCALA, 16 * Game.ESCALA, 29 * Game.ESCALA),
            new Rectangle(49 * Game.ESCALA - Game.ESCALA, 1371 * Game.ESCALA - Game.ESCALA, 15 * Game.ESCALA, 13 * Game.ESCALA),
            new Rectangle(466 * Game.ESCALA - Game.ESCALA, 1354 * Game.ESCALA - Game.ESCALA, 81 * Game.ESCALA, 30 * Game.ESCALA),
            new Rectangle(450 * Game.ESCALA - Game.ESCALA, 1178 * Game.ESCALA - Game.ESCALA, 161 * Game.ESCALA, 93 * Game.ESCALA),
            new Rectangle(464 * Game.ESCALA - Game.ESCALA, 1271 * Game.ESCALA - Game.ESCALA, 147 * Game.ESCALA, 17 * Game.ESCALA),
            new Rectangle(482 * Game.ESCALA - Game.ESCALA, 1288 * Game.ESCALA - Game.ESCALA, 65 * Game.ESCALA, 16 * Game.ESCALA),
            new Rectangle(547 * Game.ESCALA - Game.ESCALA, 1288 * Game.ESCALA - Game.ESCALA, 64 * Game.ESCALA, 32 * Game.ESCALA),
            new Rectangle(611 * Game.ESCALA - Game.ESCALA, 1291 * Game.ESCALA - Game.ESCALA, 273 * Game.ESCALA, 77 * Game.ESCALA),
            new Rectangle(255 * Game.ESCALA - Game.ESCALA, 1032 * Game.ESCALA - Game.ESCALA, 16 * Game.ESCALA, 79 * Game.ESCALA),
            new Rectangle(531 * Game.ESCALA - Game.ESCALA, 309 * Game.ESCALA - Game.ESCALA, 16 * Game.ESCALA, 286 * Game.ESCALA),
            new Rectangle(547 * Game.ESCALA - Game.ESCALA, 501 * Game.ESCALA - Game.ESCALA, 79 * Game.ESCALA, 78 * Game.ESCALA),
            new Rectangle(595 * Game.ESCALA - Game.ESCALA, 579 * Game.ESCALA - Game.ESCALA, 31 * Game.ESCALA, 33 * Game.ESCALA),
            new Rectangle(577 * Game.ESCALA - Game.ESCALA, 579 * Game.ESCALA - Game.ESCALA, 18 * Game.ESCALA, 17 * Game.ESCALA),
            new Rectangle(723 * Game.ESCALA - Game.ESCALA, 630 * Game.ESCALA - Game.ESCALA, 81 * Game.ESCALA, 48 * Game.ESCALA),
            new Rectangle(723 * Game.ESCALA - Game.ESCALA, 501 * Game.ESCALA - Game.ESCALA, 81 * Game.ESCALA, 111 * Game.ESCALA),
            new Rectangle(547 * Game.ESCALA - Game.ESCALA, 324 * Game.ESCALA - Game.ESCALA, 641 * Game.ESCALA, 63 * Game.ESCALA),
            new Rectangle(739 * Game.ESCALA - Game.ESCALA, 387 * Game.ESCALA - Game.ESCALA, 49 * Game.ESCALA, 114 * Game.ESCALA),
            new Rectangle(788 * Game.ESCALA - Game.ESCALA, 387 * Game.ESCALA - Game.ESCALA, 16 * Game.ESCALA, 15 * Game.ESCALA),
            new Rectangle(788 * Game.ESCALA - Game.ESCALA, 486 * Game.ESCALA - Game.ESCALA, 16 * Game.ESCALA, 15 * Game.ESCALA),
            new Rectangle(659 * Game.ESCALA - Game.ESCALA, 501 * Game.ESCALA - Game.ESCALA, 64 * Game.ESCALA, 62 * Game.ESCALA),
            new Rectangle(707 * Game.ESCALA - Game.ESCALA, 563 * Game.ESCALA - Game.ESCALA, 16 * Game.ESCALA, 33 * Game.ESCALA),
            new Rectangle(689 * Game.ESCALA - Game.ESCALA, 563 * Game.ESCALA - Game.ESCALA, 18 * Game.ESCALA, 17 * Game.ESCALA),
            new Rectangle(563 * Game.ESCALA - Game.ESCALA, 419 * Game.ESCALA - Game.ESCALA, 64 * Game.ESCALA, 16 * Game.ESCALA),
            new Rectangle(659 * Game.ESCALA - Game.ESCALA, 419 * Game.ESCALA - Game.ESCALA, 64 * Game.ESCALA, 16 * Game.ESCALA),
            new Rectangle(611 * Game.ESCALA - Game.ESCALA, 404 * Game.ESCALA - Game.ESCALA, 64 * Game.ESCALA, 15 * Game.ESCALA),
            new Rectangle(563 * Game.ESCALA - Game.ESCALA, 451 * Game.ESCALA - Game.ESCALA, 48 * Game.ESCALA, 16 * Game.ESCALA),
            new Rectangle(675 * Game.ESCALA - Game.ESCALA, 451 * Game.ESCALA - Game.ESCALA, 48 * Game.ESCALA, 16 * Game.ESCALA),
            new Rectangle(579 * Game.ESCALA - Game.ESCALA, 937 * Game.ESCALA - Game.ESCALA, 225 * Game.ESCALA, 77 * Game.ESCALA),
            new Rectangle(646 * Game.ESCALA - Game.ESCALA, 563 * Game.ESCALA - Game.ESCALA, 13 * Game.ESCALA, 49 * Game.ESCALA),
            new Rectangle(646 * Game.ESCALA - Game.ESCALA, 501 * Game.ESCALA - Game.ESCALA, 13 * Game.ESCALA, 62 * Game.ESCALA),
            new Rectangle(804 * Game.ESCALA - Game.ESCALA, 501 * Game.ESCALA - Game.ESCALA, 64 * Game.ESCALA, 63 * Game.ESCALA),
            new Rectangle(887 * Game.ESCALA - Game.ESCALA, 485 * Game.ESCALA - Game.ESCALA, 13 * Game.ESCALA, 79 * Game.ESCALA),
            new Rectangle(932 * Game.ESCALA - Game.ESCALA, 486 * Game.ESCALA - Game.ESCALA, 16 * Game.ESCALA, 78 * Game.ESCALA),
            new Rectangle(884 * Game.ESCALA - Game.ESCALA, 387 * Game.ESCALA - Game.ESCALA, 64 * Game.ESCALA, 16 * Game.ESCALA),
            new Rectangle(900 * Game.ESCALA - Game.ESCALA, 403 * Game.ESCALA - Game.ESCALA, 32 * Game.ESCALA, 161 * Game.ESCALA),
            new Rectangle(516 * Game.ESCALA - Game.ESCALA, 255 * Game.ESCALA - Game.ESCALA, 31 * Game.ESCALA, 18 * Game.ESCALA),

    };
}
