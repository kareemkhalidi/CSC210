
public class Triangle extends Shape{
	
	private double b;
	private double h;

	public Triangle(double b, double h) {
		
		this.b = b;
		this.h = h;
		
	}
	
	public double area() {
		
		return((b * h) / 2);
		
	}
	
}
