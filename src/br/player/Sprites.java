package br.player;

import java.awt.image.BufferedImage;

import br.graficos.Link;

public class Sprites {
	public static final BufferedImage arma_up[][] = {
			{ Link.ssLink.getSprite(18, 97, 16, 12), Link.ssLink.getSprite(35, 98, 16, 11),
					Link.ssLink.getSprite(52, 106, 16, 3) },

			{ Link.ssLink.getSprite(111, 97, 16, 12), Link.ssLink.getSprite(128, 98, 16, 11),
					Link.ssLink.getSprite(145, 106, 16, 3) },

			{ Link.ssLink.getSprite(204, 97, 16, 12), Link.ssLink.getSprite(221, 98, 16, 11),
					Link.ssLink.getSprite(238, 106, 16, 3) },

			{ Link.ssLink.getSprite(297, 97, 16, 12), Link.ssLink.getSprite(314, 98, 16, 11),
					Link.ssLink.getSprite(331, 106, 16, 3) } },
			corpo_up[][] = {
					{ Link.ssLink.getSprite(1, 109, 16, 16), Link.ssLink.getSprite(18, 109, 16, 16),
							Link.ssLink.getSprite(35, 109, 16, 16), Link.ssLink.getSprite(52, 109, 16, 16) },

					{ Link.ssLink.getSprite(94, 109, 16, 16), Link.ssLink.getSprite(111, 109, 16, 16),
							Link.ssLink.getSprite(128, 109, 16, 16), Link.ssLink.getSprite(145, 109, 16, 16) },

					{ Link.ssLink.getSprite(187, 109, 16, 16), Link.ssLink.getSprite(204, 109, 16, 16),
							Link.ssLink.getSprite(221, 109, 16, 16), Link.ssLink.getSprite(238, 109, 16, 16) },

					{ Link.ssLink.getSprite(280, 109, 16, 16), Link.ssLink.getSprite(297, 109, 16, 16),
							Link.ssLink.getSprite(314, 109, 16, 16), Link.ssLink.getSprite(331, 109, 16, 16) } },

			arma_down[][] = {
					{ Link.ssLink.getSprite(18, 63, 16, 11), Link.ssLink.getSprite(35, 63, 16, 7),
							Link.ssLink.getSprite(52, 63, 16, 3) },

					{ Link.ssLink.getSprite(111, 63, 16, 11), Link.ssLink.getSprite(128, 63, 16, 7),
							Link.ssLink.getSprite(145, 63, 16, 3) },

					{ Link.ssLink.getSprite(204, 63, 16, 11), Link.ssLink.getSprite(221, 63, 16, 7),
							Link.ssLink.getSprite(238, 63, 16, 3) },

					{ Link.ssLink.getSprite(297, 63, 16, 11), Link.ssLink.getSprite(314, 63, 16, 7),
							Link.ssLink.getSprite(331, 63, 16, 3) } },

			corpo_down[][] = {
					{ Link.ssLink.getSprite(1, 47, 16, 16), Link.ssLink.getSprite(18, 47, 16, 16),
							Link.ssLink.getSprite(35, 47, 16, 16), Link.ssLink.getSprite(52, 47, 16, 16) },

					{ Link.ssLink.getSprite(94, 47, 16, 16), Link.ssLink.getSprite(111, 47, 16, 16),
							Link.ssLink.getSprite(128, 47, 16, 16), Link.ssLink.getSprite(145, 47, 16, 16) },

					{ Link.ssLink.getSprite(187, 47, 16, 16), Link.ssLink.getSprite(204, 47, 16, 16),
							Link.ssLink.getSprite(221, 47, 16, 16), Link.ssLink.getSprite(238, 47, 16, 16) },

					{ Link.ssLink.getSprite(280, 47, 16, 16), Link.ssLink.getSprite(297, 47, 16, 16),
							Link.ssLink.getSprite(314, 47, 16, 16), Link.ssLink.getSprite(331, 47, 16, 16) } },

			arma_H[][] = {
					{ Link.ssLink.getSprite(34, 77, 11, 16), Link.ssLink.getSprite(62, 77, 7, 16),
							Link.ssLink.getSprite(86, 77, 3, 16) },

					{ Link.ssLink.getSprite(127, 77, 11, 16), Link.ssLink.getSprite(155, 77, 7, 16),
							Link.ssLink.getSprite(178, 77, 3, 16) },

					{ Link.ssLink.getSprite(220, 77, 11, 16), Link.ssLink.getSprite(248, 77, 7, 16),
							Link.ssLink.getSprite(271, 77, 3, 16) },

					{ Link.ssLink.getSprite(313, 77, 11, 16), Link.ssLink.getSprite(341, 77, 7, 16),
							Link.ssLink.getSprite(365, 77, 3, 16) } },

			corpo_H[][] = {
					{ Link.ssLink.getSprite(1, 77, 16, 16), Link.ssLink.getSprite(18, 77, 16, 16),
							Link.ssLink.getSprite(46, 77, 16, 16), Link.ssLink.getSprite(70, 77, 16, 16) },

					{ Link.ssLink.getSprite(94, 77, 16, 16), Link.ssLink.getSprite(111, 77, 16, 16),
							Link.ssLink.getSprite(139, 77, 16, 16), Link.ssLink.getSprite(163, 77, 16, 16) },

					{ Link.ssLink.getSprite(187, 77, 16, 16), Link.ssLink.getSprite(204, 77, 16, 16),
							Link.ssLink.getSprite(232, 77, 16, 16), Link.ssLink.getSprite(256, 77, 16, 16) },

					{ Link.ssLink.getSprite(280, 77, 16, 16), Link.ssLink.getSprite(297, 77, 16, 16),
							Link.ssLink.getSprite(325, 77, 16, 16), Link.ssLink.getSprite(349, 77, 16, 16) } },

			escudo_down[][] = {
					{Link.ssLink.getSprite(1, 144, 16, 7), Link.ssLink.getSprite(18,144,16,3)},
					{Link.ssLink.getSprite(94,144,16,7), Link.ssLink.getSprite(111,144,16,3)},
					{Link.ssLink.getSprite(187,144,16,7), Link.ssLink.getSprite(204,144,16,3)},
					{Link.ssLink.getSprite(280,144,16,7), Link.ssLink.getSprite(297,144,16,3)}
			},

			escudo_H[][] = {
					{Link.ssLink.getSprite(51, 128, 7, 16), Link.ssLink.getSprite(75,128,3,16)},
					{Link.ssLink.getSprite(144,128,7,16), Link.ssLink.getSprite(168,128,3,16)},
					{Link.ssLink.getSprite(237,128,7,16), Link.ssLink.getSprite(261,128,3,16)},
					{Link.ssLink.getSprite(330,128,7,16), Link.ssLink.getSprite(354,128,3,16)}
			},

			escudoC_down[][] = {
					{Link.ssLink.getSprite(1, 128, 16, 16), Link.ssLink.getSprite(18,128,16,16)},
					{Link.ssLink.getSprite(94,128,16,16), Link.ssLink.getSprite(111,128,16,16)},
					{Link.ssLink.getSprite(187,128,16,16), Link.ssLink.getSprite(204,128,16,16)},
					{Link.ssLink.getSprite(280,128,16,16), Link.ssLink.getSprite(297,128,16,16)}
			},

			escudoC_H[][] = {
					{Link.ssLink.getSprite(35, 128, 16, 16), Link.ssLink.getSprite(59,128,16,16)},
					{Link.ssLink.getSprite(128,128,16,16), Link.ssLink.getSprite(152,128,16,16)},
					{Link.ssLink.getSprite(221,128,16,16), Link.ssLink.getSprite(245,128,16,16)},
					{Link.ssLink.getSprite(314,128,16,16), Link.ssLink.getSprite(338,128,16,16)}
			};

	public static final BufferedImage shield_down[] = { Link.ssLink.getSprite(289, 11, 16, 16), Link.ssLink.getSprite(306, 11, 16, 16) },
			shield_H[] = { Link.ssLink.getSprite(323, 11, 16, 16), Link.ssLink.getSprite(340, 11, 16, 16) },
			move_up[] = { Link.ssLink.getSprite(69, 11, 16, 16), Link.ssLink.getSprite(86, 11, 16, 16) },
			move_down[] = { Link.ssLink.getSprite(1, 11, 16, 16), Link.ssLink.getSprite(18, 11, 16, 16) },
			move_H[] = { Link.ssLink.getSprite(35, 11, 16, 16), Link.ssLink.getSprite(52, 11, 16, 16) },
			item[] = {Link.ssLink.getSprite(213, 11, 16, 16), Link.ssLink.getSprite(230,11,16,16)};
}
