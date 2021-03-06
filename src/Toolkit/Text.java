package Toolkit;

import java.awt.*;

import edu.princeton.cs.introcs.StdDraw;

public class Text {

    /**
     * what the Toolkit.Text is actually going to say
     */
    private String text;

    /**
     * what the Font of the text is
     */
    private Font font;

    /**
     * what color the text will be
     */
    private Color textColor;

    //==================================================================================================================

    public Text(String text, int fontSize) {
        this.text = text;
        this.font = new Font(null, Font.BOLD, fontSize);
        this.textColor = StdDraw.BLACK;
    }

    public Text(String text, Font font) {
        this.text = text;
        this.font = font;
        this.textColor = StdDraw.BLACK;
    }

    public Text(String text, Color textColor, Font font) {
        this.text = text;
        this.font = font;
        this.textColor = textColor;
    }

    //==================================================================================================================

    public void draw(double xPos, double yPos) {
        StdDraw.setPenColor(textColor);
        StdDraw.setFont(font);
        StdDraw.text(xPos, yPos, text);
    }
}
