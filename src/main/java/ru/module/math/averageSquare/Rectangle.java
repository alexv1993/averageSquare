package ru.module.math.averageSquare;


/**
 * Прямоугольник в пространстве
 */
public class Rectangle {

    //начальная координата в декартовой системе координат
    private Point beginPoint;
    //длина прямоугольника
    private int a;
    //ширина прямоугольника
    private int b;

    public Rectangle() {
    }

    public Rectangle(Point beginPoint, int a, int b) {
        this.beginPoint = beginPoint;
        this.a = a;
        this.b = b;
    }


    public Point getBeginPoint() {
        return beginPoint;
    }

    public void setBeginPoint(Point beginPoint) {
        this.beginPoint = beginPoint;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
