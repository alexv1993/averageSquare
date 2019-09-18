package ru.module.math.averageSquare;

import org.apache.commons.math3.ml.clustering.Cluster;

import java.util.ArrayList;
import java.util.List;

public class MethodFacade {

    /**
     * Алгоримт разбиения
     *
     * @param a    длина полигона
     * @param b    ширина полигона
     * @param n    число узлов кластере
     * @param minK минимальный размер средней площади
     */
    void alg(int a, int b, int n, int minK) {

        //удельная площадь
        int k = (a * b) / n;

        int ostatok = (a * b) - k * n;
        ClusterNode[] clusterNodes;

        //построчное сканирование полигона
        //точка, считыватель
        Point currentPoint = new Point(0, 0);

        //число площадей меньше числа узлов кластера
        if (a * b < n) {
            //здесь просто будет разбиение
            //каждому узлу назначается соответствующая точка

            clusterNodes = new ClusterNode[n];
            // @i - текущий узел кластера
            for (int i = 0; i < n; i++) {
                Rectangle rectangle = new Rectangle();
                rectangle.setBeginPoint(new Point(
                        currentPoint.getX(),
                        currentPoint.getY()));
                rectangle.setA(1);
                rectangle.setB(1);

                List<Rectangle> rectangles = new ArrayList<Rectangle>();
                rectangles.add(rectangle);

                //создаем экземпляр узла для хранения информации
                ClusterNode clusterNode = new ClusterNode();
                clusterNode.setRectangleList(rectangles);

                clusterNodes[i].setRectangleList(rectangles);

                if ((currentPoint.getX() + 1) == a) {
                    currentPoint.setX(0);
                    currentPoint.setY(currentPoint.getY() + 1);
                } else {
                    currentPoint.setX(currentPoint.getX() + 1);
                }
            }


        } else {
            clusterNodes = new ClusterNode[n];
            if (ostatok == 0) {
                //цикл по всем узлам кластера
                for (int i = 0; i < n; i++) {
                    //создаем узел кластера
                    ClusterNode clusterNode = new ClusterNode();
                    clusterNodes[i] = clusterNode;

                    List<Rectangle> rectangles = new ArrayList<Rectangle>();

                    //Привязываем полигоны у кзлам кластера
                    clusterNode.setRectangleList(rectangles);

                    //создаем первый полигон
                    Rectangle rectangle = new Rectangle();

                    rectangle.setBeginPoint(new Point(currentPoint.getX(),
                            currentPoint.getY())
                    );

                    rectangle.setA(0);
                    rectangle.setB(1);

                    rectangles.add(rectangle);

                    //есть значение удельной площадь
                    // т.к. построчное сканирование
                    //заполняем минимальными площадями узлы кластера
                    for (int j = 0; j < k; j++) {
                        //сдвигаемся вправо
                        rectangle.setA(rectangle.getA() + 1);
                        //проставляем координату по X
                        currentPoint.setX(currentPoint.getX() + 1);

                        //сканирование достигло правой границы
                        if (currentPoint.getX() == a) {
                            //вовзращаем координату в 0
                            currentPoint.setX(0);
                            //переход на следующую сканирующую строку
                            currentPoint.setY(currentPoint.getY() + 1);

                            //средняя площадь больше, чем длина
                            if (k > a) {
                                Rectangle rectangle1 = new Rectangle();
                                rectangle1.setA(0);
                                rectangle1.setB(1);

                                rectangle1.setBeginPoint(new Point(currentPoint.getX(),
                                                currentPoint.getY()));

                                rectangles.add(rectangle1);

                                rectangle = rectangle1;
                            } else if (i < (a - 1) && (k < a)) {
                                // в таком случае
                                Rectangle rectangle1 = new Rectangle();
                                rectangle1.setA(0);
                                rectangle1.setB(1);

                                rectangles.add(rectangle1);

                                rectangle1.setBeginPoint(new Point(currentPoint.getX(),
                                        currentPoint.getY()));

                                rectangle = rectangle1;
                            }
                        }
                    }
                }
            } else {

            }
        }

        System.out.println("Out");

    }
}

