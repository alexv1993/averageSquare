package ru.module.math.averageSquare;

import java.util.List;

public class ClusterNode {
    //список прямоугольников для работы
    private List<Rectangle> rectangleList;

    public ClusterNode() {
    }

    public List<Rectangle> getRectangleList() {
        return rectangleList;
    }

    public void setRectangleList(List<Rectangle> rectangleList) {
        this.rectangleList = rectangleList;
    }
}
