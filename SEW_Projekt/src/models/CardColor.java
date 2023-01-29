package models;

import java.awt.*;

public final class CardColor {
    private static final int[] colors = {
    		 0x728FCE, 0xE5E4E2, 0x413839, 0x1569C7, 0x50EBEC,
    		 0x254117, 0x3A5F0B, 0x006A4E
            
    };

    public static Color getColorCard(int index) {
        return new Color(colors[index]);
    }
}
