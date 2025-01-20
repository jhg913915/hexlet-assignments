package exercise;

// BEGIN
public class Cottage implements Home {
    double area;
    int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    public String toString() {
        return this.floorCount + " этажный коттедж площадью " + this.getArea() + " метров";
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Home another) {
        if (another.getArea() > this.getArea()) {
            return 1;
        } else if (another.getArea() == this.getArea()) {
            return 0;
        }
        return -1;
    }
}
// END
