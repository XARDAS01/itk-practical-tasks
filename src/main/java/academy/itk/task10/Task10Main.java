package academy.itk.task10;

import academy.itk.model.Circle;
import academy.itk.model.Rectangle;
import academy.itk.model.Triangle;

public class Task10Main {

    public static void main(String[] args) {
        System.out.println(new Circle(16).shapeDemonstration());
        System.out.println(new Rectangle(10, 20).shapeDemonstration());
        System.out.println(new Triangle(15, 20, 20).shapeDemonstration());
    }
}
