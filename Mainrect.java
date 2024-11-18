public class Mainrect {
    public static void main(String[] args) {
        // Create an instance of Rectangle
        Rectangle rectangle = new Rectangle(10, 20);

        // Display the initial dimensions
        rectangle.display();

        // Resize the rectangle
        rectangle.resizeWidth(15);
        rectangle.resizeHeight(25);

        // Display the resized dimensions
        rectangle.display();
    }
}