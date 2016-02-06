/**
 * Created by akic on 5.2.2016.
 */
public class Char {

    public String name;
    public int type, x, y, w, h;

    public Char(String name, int type, int x, int y, int w, int h) {
        this.name = name;
        this.type = type;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public int getCX() {
        return this.x + this.w/2;
    }
    public int getCY() {
        return this.y - this.h/2;
    }
}
