class Rectangle implements Resizable {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void resizeWidth(int newWidth) {
        width = newWidth;
        System.out.println("Rectangle width resized to: " + width);
    }

    @Override
    public void resizeHeight(int newHeight) {
        height = newHeight;
        System.out.println("Rectangle height resized to: " + height);
    }

    public void display() {
        System.out.println("Rectangle width: " + width);
        System.out.println("Rectangle height: " + height);
    }
}