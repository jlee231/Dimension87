package View;

import model.Model;

public interface Dimension87_ViewInterface<T> {
	public void setImageAt(int row, int col, T img);
	public T getImageAt(int row, int col);
	public int getX(double x);
	public int getY(double y);
	public void setModel(Model model);
}
