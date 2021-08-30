import java.util.Arrays;

public class Triangle {


    public static void main(String[] args) {

        areaOfATriangle(3,4,5);

    }

    public static void areaOfATriangle (int a, int b, int c ) {

        int perimeter = (a + b + c)/2;

        double  area = perimeter * (perimeter - a) * (perimeter - b) * (perimeter - c);

        double totalArea = Math.sqrt(area);

        System.out.println(" Площадь треугольника: " + totalArea);

    }

}
