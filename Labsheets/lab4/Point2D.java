import java.util.Scanner;

public class Point2D {
    static private int x;
    static private int y;

    public Point2D() {
    }

    public Point2D(int x, int y) {
        Point2D.x = x;
        Point2D.y = y;
    }

    @SuppressWarnings("static-access")
    public Point2D translatePoint(int dx, int dy, Point2D pt) {
        Point2D.x += dx;
        Point2D.y += dy;
        pt.x = Point2D.x;
        pt.y = Point2D.y;
        return pt;
    }

    public void printPoint() {
        System.out.println("(" + x + "," + y + ")");
    }

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner src = new Scanner(System.in);
        System.out.print("Enter initial x coordinate: ");
        int x = src.nextInt();
        System.out.print("Enter initial y coordinate: ");
        int y = src.nextInt();
        System.out.print("Enter dx: ");
        int dx = src.nextInt();
        System.out.print("Enter dy: ");
        int dy = src.nextInt();
        Point2D Ipt = new Point2D(x, y);
        System.out.print("Initial coordinates: ");
        Ipt.printPoint();
        Point2D Tpt = new Point2D().translatePoint(dx, dy, Ipt);
        System.out.print("Translated coordinates: ");
        Tpt.printPoint();
    }
}
