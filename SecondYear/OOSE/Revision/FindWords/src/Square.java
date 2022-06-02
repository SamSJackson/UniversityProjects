
public class Square extends Rectangle {
	public void setWidth(double w) {
		super.setWidth(w);
		super.setHeight(w);
	}
	public void setHeight(double w) {
		super.setWidth(w);
		super.setHeight(w);
	}
}
