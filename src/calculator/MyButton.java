package calculator;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class MyButton extends Button{
	
	public MyButton(String arg, double width, double height) {
		super(arg);
		this.setFont(new Font(20));
		this.setMinSize(width, height);
	}
	

}
