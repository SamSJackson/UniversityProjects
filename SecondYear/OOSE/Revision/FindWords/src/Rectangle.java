
public class Rectangle {
	private double width, height;
	
	public double area() {
		return width * height;
	}
	public void setWidth(double w) {
		width = w;
	}
	public void setHeight(double h) {
		height = h;
	}
	public double getWidth() {
		return width;
	}
	public double getHeight() {
		return height;
	}
	@Override
	public String toString() {
		return width + " " + height;
	}
}
