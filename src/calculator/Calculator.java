package calculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Calculator extends Application{
	
	private GridPane grid;
	
	private double cellWidth;
	private double cellHeight;
	
	private float firstNumber;
	private float secondNumber;
	boolean first = false;
	
	private Text result;
	
	private int operation;
	private float resultNumber;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Calculator");
		
		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(5);
		grid.setVgap(5);
		grid.setPadding(new Insets(5, 5, 5, 5));
		grid.setPrefSize(70, 50);
		
		cellWidth = grid.getPrefWidth();
		cellHeight = grid.getPrefHeight();
		
		HBox hbox = new HBox();
		result = new Text("0");
		result.setFont(Font.font(30));
		hbox.getChildren().add(result);
		hbox.setAlignment(Pos.CENTER_RIGHT);
		grid.add(hbox, 0, 0, 4, 2);
		
		MyButton btnCE = new MyButton("CE", cellWidth, cellHeight);
		grid.add(btnCE, 0, 2);
		
		MyButton btnC = new MyButton("C", cellWidth, cellHeight);
		grid.add(btnC, 1, 2);
		
		MyButton btnDel = new MyButton("DEL", cellWidth, cellHeight);
		grid.add(btnDel, 2, 2);
		
		MyButton btnDiv = new MyButton("/", cellWidth, cellHeight);
		grid.add(btnDiv, 3, 2);
		
		MyButton btn7 = new MyButton("7", cellWidth, cellHeight);
		grid.add(btn7, 0, 3);
		
		MyButton btn8 = new MyButton("8", cellWidth, cellHeight);
		grid.add(btn8, 1, 3);
		
		MyButton btn9 = new MyButton("9", cellWidth, cellHeight);
		grid.add(btn9, 2, 3);
		
		MyButton btnMul = new MyButton("X", cellWidth, cellHeight);
		grid.add(btnMul, 3, 3);
		
		MyButton btn4 = new MyButton("4", cellWidth, cellHeight);
		grid.add(btn4, 0, 4);
		
		MyButton btn5 = new MyButton("5", cellWidth, cellHeight);
		grid.add(btn5, 1, 4);
		
		MyButton btn6 = new MyButton("6", cellWidth, cellHeight);
		grid.add(btn6, 2, 4);
		
		MyButton btnMin = new MyButton("-", cellWidth, cellHeight);
		grid.add(btnMin, 3, 4);
		
		MyButton btn1 = new MyButton("1", cellWidth, cellHeight);
		grid.add(btn1, 0, 5);
		
		MyButton btn2 = new MyButton("2", cellWidth, cellHeight);
		grid.add(btn2, 1, 5);
		
		MyButton btn3 = new MyButton("3", cellWidth, cellHeight);
		grid.add(btn3, 2, 5);
		
		MyButton btnPlus = new MyButton("+", cellWidth, cellHeight);
		grid.add(btnPlus, 3, 5);
		
		MyButton btn0 = new MyButton("0", cellWidth, cellHeight);
		grid.add(btn0, 1, 6);
		
		MyButton btnPoint = new MyButton(",", cellWidth, cellHeight);
		grid.add(btnPoint, 2, 6);
		
		MyButton btnEqual = new MyButton("=", cellWidth, cellHeight);
		grid.add(btnEqual, 3, 6);
		
		btn0.setOnAction(new MyHandler(0));
		btn1.setOnAction(new MyHandler(1));
		btn2.setOnAction(new MyHandler(2));
		btn3.setOnAction(new MyHandler(3));
		btn4.setOnAction(new MyHandler(4));
		btn5.setOnAction(new MyHandler(5));
		btn6.setOnAction(new MyHandler(6));
		btn7.setOnAction(new MyHandler(7));
		btn8.setOnAction(new MyHandler(8));
		btn9.setOnAction(new MyHandler(9));
		
		btnC.setOnAction(new EventHandler <ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				firstNumber = 0;
				secondNumber = 0;
				result.setText("0");
				first = false;
			}
			
		});
		
		btnPlus.setOnAction(new EventHandler <ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				first = true;
				operation = 1;
				String currentText = result.getText();
				result.setText(currentText + "+");				
			}
			
		});
		
		btnMin.setOnAction(new EventHandler <ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				first = true;
				operation = 2;
				String currentText = result.getText();
				result.setText(currentText + "-");
			}
			
		});
		
		btnMul.setOnAction(new EventHandler <ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				first = true;
				operation = 3;
				String currentText = result.getText();
				result.setText(currentText + "X");
			}
			
		});
		
		btnDiv.setOnAction(new EventHandler <ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				first = true;
				operation = 4;
				String currentText = result.getText();
				result.setText(currentText + "/");
			}
			
		});
		
		btnEqual.setOnAction(new EventHandler <ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if(operation == 1) {
					resultNumber = firstNumber + secondNumber;
					result.setText(String.valueOf((int)resultNumber));
				} else if (operation == 2) {
					resultNumber = firstNumber - secondNumber;
					result.setText(String.valueOf((int)resultNumber));
				} else if (operation == 3) {
					resultNumber = firstNumber * secondNumber;
					result.setText(String.valueOf((int)resultNumber));
				} else if (operation == 4) {
					resultNumber = firstNumber / secondNumber;
					result.setText(String.valueOf(resultNumber));
				}
				first = false;
				firstNumber = secondNumber = 0;
				
			}
			
		});
		
		Scene scene = new Scene(grid);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public class MyHandler implements EventHandler <ActionEvent> {
		
		private float number;
		
		public MyHandler(float number) {
			this.number = number;
		}
		
		@Override
		public void handle(ActionEvent event) {
			if(firstNumber == 0) {
				result.setText(String.valueOf((int)number));
			} else {
				String currentText = result.getText();
				result.setText(currentText + String.valueOf((int)number));
			}
			if(!first) {
				firstNumber = number;
			} else {
				secondNumber = number;
			}
		}
		
	}
	

}
