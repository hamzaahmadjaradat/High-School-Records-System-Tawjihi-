package application;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class Main extends Application {
	Window primaryStage;

	TawjihiDS LiterarySTD = new TawjihiDS();
	TawjihiDS scintificSTD = new TawjihiDS();
	Button load = new Button("Load");
	Group root = new Group();
	Scene scene = new Scene(root, 650, 480);
	Image img = new Image("C:\\Users\\hp\\OneDrive\\سطح المكتب\\ستيكرز\\frame.jpg");
	ImageView im = new ImageView(img);
	Scene sceneGetall;
	TawjihiDS studentScintific = new TawjihiDS();
	TawjihiDS studentLiterary = new TawjihiDS();
	static TawjihiDS studentMain = new TawjihiDS();

	public void start(Stage primaryStage) throws FileNotFoundException {
		root.getChildren().add(im);
		readingFile();

		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public void readingFile() throws FileNotFoundException {
		Label fileLabel = new Label("Choose the file please");
		fileLabel.setFont(Font.font("verdana", FontWeight.BLACK, FontPosture.REGULAR, 20));
		HBox file = new HBox(fileLabel, load);
		file.setAlignment(Pos.TOP_CENTER);
		file.setLayoutX(160);
		file.setSpacing(10);
		root.getChildren().add(file);

		load.setOnAction(e -> {
			FileChooser fileChooser = new FileChooser();
			File selectedFile = fileChooser.showOpenDialog(primaryStage);
			try {
				run(selectedFile);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			Button literary = new Button("literary");
			Button scintafic = new Button("scintafic");
			HBox branch = new HBox(literary, scintafic);
			branch.setLayoutX(250);
			branch.setLayoutY(70);
			branch.setSpacing(30);

			root.getChildren().add(branch);

			literary.setOnAction(e1 -> {
				studentMain = studentLiterary;
			});
			scintafic.setOnAction(e1 -> {
				studentMain = studentScintific;
			});
			insert();
			delete();
			search();
			update();
			getALL();
			print();
			printAVLHeight();

		});

	}

	public void print() {
		Label labelPrint = new Label("print doubly list and the two tree");
		Button btnPrint = new Button("press");
		GridPane pane = new GridPane();
		labelPrint.setTextFill(Color.DARKGREEN);
		labelPrint.setFont(Font.font("verdana", FontWeight.BLACK, FontPosture.REGULAR, 20));
		pane.add(labelPrint, 0, 1);
		pane.add(btnPrint, 1, 1);
		pane.setLayoutX(0);
		pane.setLayoutY(308);
		pane.setHgap(38);
		root.getChildren().add(pane);
		btnPrint.setOnAction((ActionEvent e) -> {
			Group root = new Group();
			Scene scene = new Scene(root, 400, 300);
			Image img = new Image("C:\\Users\\hp\\OneDrive\\سطح المكتب\\ستيكرز\\frame.jpg");
			ImageView im = new ImageView(img);
			root.getChildren().add(im);
			GridPane pane2 = new GridPane();
			Button btnLinkedList = new Button("Doubly LinkedList");
			ComboBox<String> LinkedList = new ComboBox<String>();
			Button btnAVL1 = new Button("AVL1");
			ComboBox<String> labelAVL1 = new ComboBox<String>();
			Button btnAVL2 = new Button("AVL2");
			ComboBox<String> labelAVL2 = new ComboBox<String>();
			LinkedList.setPrefSize(200, 1);
			labelAVL1.setPrefSize(200, 1);
			labelAVL2.setPrefSize(200, 1);
			pane2.add(btnLinkedList, 0, 0);
			pane2.add(btnAVL1, 0, 1);
			pane2.add(btnAVL2, 0, 2);
			pane2.setHgap(50);
			pane2.setVgap(30);
			root.getChildren().add(pane2);
			LinkedList.getItems().clear();

			LinkedList.getItems().addAll(studentMain.printDoubly());
			LinkedList.setPromptText("the items in doublyLinkedList");

			btnLinkedList.setOnAction((ActionEvent e1) -> {
				pane2.add(LinkedList, 1, 0);

			});
			labelAVL1.getItems().clear();
			labelAVL1.getItems().addAll(studentMain.printTree1());
			labelAVL1.setPromptText("the items in avl1");

			btnAVL1.setOnAction((ActionEvent e1) -> {
				pane2.add(labelAVL1, 1, 1);

			});
			labelAVL2.getItems().clear();
			labelAVL2.getItems().addAll(studentMain.printTree2());
			labelAVL2.setPromptText("the items in avl2");

			btnAVL2.setOnAction((ActionEvent e1) -> {
				pane2.add(labelAVL2, 1, 2);

			});

			Stage newWindow = new Stage();
			newWindow.setScene(scene);
			newWindow.initModality(Modality.WINDOW_MODAL);
			newWindow.initOwner(primaryStage);
			newWindow.show();

		});

	}

	public void printAVLHeight() {

		Label labelPrint = new Label("print the AVL tree Height");
		Button btnPrint = new Button("press");
		GridPane pane = new GridPane();
		labelPrint.setTextFill(Color.DARKGREEN);
		labelPrint.setFont(Font.font("verdana", FontWeight.BLACK, FontPosture.REGULAR, 20));
		pane.add(labelPrint, 0, 1);
		pane.add(btnPrint, 1, 1);
		pane.setLayoutX(0);
		pane.setLayoutY(335);
		pane.setHgap(129);
		root.getChildren().add(pane);
		btnPrint.setOnAction((ActionEvent e) -> {
			Group root = new Group();
			Scene scene = new Scene(root, 300, 300);
			Image img = new Image("C:\\Users\\hp\\OneDrive\\سطح المكتب\\ستيكرز\\frame.jpg");
			ImageView im = new ImageView(img);
			root.getChildren().add(im);
			Button btn1 = new Button("AVL-id");
			Button btn2 = new Button("AVL-Grade");
			GridPane pane2 = new GridPane();
			pane2.add(btn1, 0, 0);
			pane2.add(btn2, 0, 1);
			pane2.setVgap(20);
			root.getChildren().add(pane2);
			pane2.setHgap(50);

			btn1.setOnAction((ActionEvent e1) -> {
				int x = studentMain.list.seatTree.heightRoot();
				Label label = new Label("" + x);
				label.setFont(Font.font("brown", FontWeight.BOLD, FontPosture.REGULAR, 20));
				pane2.add(label, 1, 0);

			});
			btn2.setOnAction((ActionEvent e1) -> {
				int x = studentMain.list.gradeTree.heightRoot();
				Label label = new Label("" + x);
				label.setFont(Font.font("verdana", FontWeight.BLACK, FontPosture.REGULAR, 20));
				pane2.add(label, 1, 1);
			});

			Stage newWindow = new Stage();
			newWindow.setScene(scene);
			newWindow.initModality(Modality.WINDOW_MODAL);
			newWindow.initOwner(primaryStage);
			newWindow.show();

		});
	}

	public void insert() {
		Label labelInsert = new Label("insert a new Tawjihi record");
		Button btnInsert = new Button("press");
		labelInsert.setTextFill(Color.DARKGREEN);
		labelInsert.setFont(Font.font("verdana", FontWeight.BLACK, FontPosture.REGULAR, 20));
		Button btnInsert2 = new Button("enter");
		Label labelseat = new Label(" seat number ");
		Label labelAverage = new Label("average ");
		TextField textSeat = new TextField();
		TextField textAverage = new TextField();
		GridPane pane2 = new GridPane();
		pane2.add(labelInsert, 0, 1);
		pane2.add(btnInsert, 1, 1);
		pane2.setLayoutX(0);
		pane2.setLayoutY(160);
		pane2.setHgap(100);

		root.getChildren().add(pane2);

		btnInsert.setOnAction((ActionEvent e) -> {
			Group root = new Group();
			Scene scene = new Scene(root, 300, 300);
			Image img = new Image("C:\\Users\\hp\\OneDrive\\سطح المكتب\\ستيكرز\\frame.jpg");
			ImageView im = new ImageView(img);
			root.getChildren().add(im);
			GridPane pane = new GridPane();
			pane.add(labelseat, 0, 1);
			pane.add(labelAverage, 0, 3);
			pane.add(textSeat, 1, 1);
			pane.add(textAverage, 1, 3);
			pane.add(btnInsert2, 0, 4);
			pane.setPadding(new Insets(50));
			pane.setLayoutX(-20);
			pane.setLayoutY(100);
			pane.setAlignment(Pos.TOP_CENTER);

			root.getChildren().add(pane);
			btnInsert2.setOnAction((ActionEvent e1) -> {
				int id = (int) Integer.parseInt(textSeat.getText());
				double grade = (double) Double.parseDouble("" + textAverage.getText());
				Student std = new Student(id, studentMain.getBranch(), grade);
				Label label2 = new Label("it has been added");
				if (studentMain.list.search3(id) == null) {
					Alert x = new Alert(AlertType.NONE);
					x.setAlertType(AlertType.CONFIRMATION);
					x.setHeaderText(" this id exists try with another one");
					label2.setText("");
					x.show();

				} else if (studentMain.list.gradeCheacker(grade) == null) {
					Alert x = new Alert(AlertType.NONE);
					x.setAlertType(AlertType.CONFIRMATION);
					x.setHeaderText(" this grade is not accepted");
					x.show();
					label2.setText("");

				}

				else {
					studentMain.list.add(std);
					textAverage.clear();
					textSeat.clear();

				}
				pane.add(label2, 0, 6);

			});

			Stage newWindow = new Stage();
			newWindow.setScene(scene);
			newWindow.initModality(Modality.WINDOW_MODAL);
			newWindow.initOwner(primaryStage);
			newWindow.show();

		});

	}

	public void delete() {
		Label labelDelete = new Label("delete a Tawjihi record");
		Button btnDelete = new Button("press");
		labelDelete.setTextFill(Color.DARKGREEN);
		labelDelete.setFont(Font.font("verdana", FontWeight.BLACK, FontPosture.REGULAR, 20));
		GridPane pane = new GridPane();
		pane.add(labelDelete, 0, 1);
		pane.add(btnDelete, 1, 1);
		pane.setLayoutX(0);
		pane.setLayoutY(190);
		pane.setHgap(150);
		root.getChildren().add(pane);
		btnDelete.setOnAction((ActionEvent e) -> {
			Group root = new Group();
			Scene scene = new Scene(root, 300, 300);
			Image img = new Image("C:\\Users\\hp\\OneDrive\\سطح المكتب\\ستيكرز\\frame.jpg");
			ImageView im = new ImageView(img);
			root.getChildren().add(im);

			Label label = new Label("enter the id of the student");
			TextField text = new TextField();
			Button btn = new Button("press");
			GridPane pane2 = new GridPane();

			pane2.add(label, 0, 0);
			pane2.add(text, 0, 1);
			pane2.add(btn, 0, 2);
			pane2.setAlignment(Pos.TOP_CENTER);
			pane2.setLayoutX(75);

			root.getChildren().add(pane2);

			btn.setOnAction((ActionEvent e1) -> {
				int id = Integer.parseInt("" + text.getText());
				String str = studentMain.list.deleteNode(id);
				if (str == null) {
					Label label2 = new Label("the record is not excited");
					pane2.add(label2, 0, 3);
					return;

				}
				Label label2 = new Label("done");
				pane2.add(label2, 0, 3);
				text.clear();

			});
			Stage newWindow = new Stage();
			newWindow.setScene(scene);
			newWindow.initModality(Modality.WINDOW_MODAL);
			newWindow.initOwner(primaryStage);
			newWindow.show();

		});

	}

	public void search() {
		Label labelSearch = new Label("search for a Tawjihi record");
		Button btnSearch = new Button("press");
		labelSearch.setTextFill(Color.DARKGREEN);

		labelSearch.setFont(Font.font("verdana", FontWeight.BLACK, FontPosture.REGULAR, 20));
		GridPane pane = new GridPane();
		pane.add(labelSearch, 0, 1);
		pane.add(btnSearch, 1, 1);
		pane.setLayoutX(0);
		pane.setLayoutY(220);
		pane.setHgap(106);
		root.getChildren().add(pane);
		btnSearch.setOnAction((ActionEvent e) -> {
			Group root = new Group();
			Scene scene = new Scene(root, 500, 500);
			Image img = new Image("C:\\Users\\hp\\OneDrive\\سطح المكتب\\ستيكرز\\frame.jpg");
			ImageView im = new ImageView(img);
			root.getChildren().add(im);
			Label labelsearch = new Label("enter the seat number");
			Button resultSearch = new Button("press");
			TextField textSearch = new TextField();
			GridPane pane2 = new GridPane();
			pane2.add(labelsearch, 0, 1);
			pane2.add(textSearch, 0, 2);
			pane2.add(resultSearch, 0, 3);

			pane2.setLayoutX(0);
			pane2.setLayoutY(110);
			pane2.setHgap(106);
			pane2.setAlignment(Pos.TOP_CENTER);
			pane2.setLayoutX(75);
			pane2.setLayoutY(0);
			root.getChildren().add(pane2);

			resultSearch.setOnAction((ActionEvent e1) -> {
				int x = Integer.parseInt(textSearch.getText());
				ArrayList<Student> list = studentMain.find(x);
				if (list.get(0) == null) {
					Label label = new Label("the student is not exited ");
					pane2.add(label, 0, 4);
					return;

				}
				String record = "" + list.get(0).toString();
				Label labelsearch2 = new Label("the student is " + record);
				pane2.add(labelsearch2, 0, 4);

				Button prev = new Button("previous record ");
				Button nextbtn = new Button("next record");

				GridPane box = new GridPane();
				box.add(nextbtn, 0, 1);

				GridPane box2 = new GridPane();
				box2.add(prev, 0, 1);

				VBox box3 = new VBox(box, box2);
				box3.setAlignment(Pos.CENTER_LEFT);
				box3.setLayoutY(150);
				box3.setSpacing(120);
				root.getChildren().add(box3);
				String previous = list.get(2).toString();
				prev.setOnAction((ActionEvent e2) -> {
					Label labelPrev = new Label("the previous record is : " + previous);

					box2.add(labelPrev, 0, 2);

				});
				String next = list.get(1).toString();
				nextbtn.setOnAction((ActionEvent e2) -> {
					Label label = new Label(" " + next);
					box.add(label, 0, 2);

				});
				list.clear();
				textSearch.clear();

			});

			Stage newWindow = new Stage();
			newWindow.setScene(scene);
			newWindow.initModality(Modality.WINDOW_MODAL);
			newWindow.initOwner(primaryStage);
			newWindow.show();

		});

	}

	public void getALL() {
		Label labelGetAll = new Label("get the student of a certin grade");
		Button btnGetAll = new Button("press");
		labelGetAll.setTextFill(Color.DARKGREEN);
		Button resultGetAll = new Button("press");

		labelGetAll.setFont(Font.font("verdana", FontWeight.BLACK, FontPosture.REGULAR, 20));
		GridPane pane = new GridPane();
		pane.add(labelGetAll, 0, 1);
		pane.add(btnGetAll, 1, 1);
		pane.setLayoutX(0);
		pane.setLayoutY(250);
		pane.setHgap(44);
		root.getChildren().add(pane);
		btnGetAll.setOnAction((ActionEvent e) -> {
			Group root = new Group();
			Scene scene = new Scene(root, 600, 300);
			Image img = new Image("C:\\Users\\hp\\OneDrive\\سطح المكتب\\ستيكرز\\frame.jpg");
			ImageView im = new ImageView(img);
			root.getChildren().add(im);
			Label labelGetAll2 = new Label("enter the Grade");
			TextField textGetAll = new TextField();
			GridPane pane2 = new GridPane();
			pane2.add(labelGetAll2, 0, 1);
			pane2.add(textGetAll, 0, 2);
			pane2.add(resultGetAll, 0, 3);
			pane2.setLayoutX(0);
			pane2.setLayoutY(110);
			pane2.setHgap(106);
			pane2.setAlignment(Pos.TOP_CENTER);
			pane2.setLayoutX(75);
			pane2.setLayoutY(0);
			root.getChildren().add(pane2);
			resultGetAll.setOnAction((ActionEvent e1) -> {
				double grade = Double.parseDouble(textGetAll.getText());
				String str = "" + studentMain.list.gradeTree.printGrade(grade);
				if (str.equals("")) {
					Label label = new Label("there is no record has this grade");
					pane2.add(label, 0, 5);
					return;

				}
				Label label = new Label("" + str);
				pane2.add(label, 0, 5);
				textGetAll.clear();

			});

			Stage newWindow = new Stage();
			newWindow.setTitle("Second Stage");
			newWindow.setScene(scene);
			newWindow.initModality(Modality.WINDOW_MODAL);
			newWindow.initOwner(primaryStage);
			newWindow.show();

		});

	}

	public void update() {
		Label LabelUpdate = new Label("update a student information");
		Button btnUpdate = new Button("press");
		LabelUpdate.setTextFill(Color.DARKGREEN);
		LabelUpdate.setFont(Font.font("verdana", FontWeight.BLACK, FontPosture.REGULAR, 20));
		GridPane pane = new GridPane();
		pane.add(LabelUpdate, 0, 1);
		pane.add(btnUpdate, 1, 1);
		pane.setLayoutX(0);
		pane.setLayoutY(280);
		pane.setHgap(80);
		root.getChildren().add(pane);
		btnUpdate.setOnAction((ActionEvent e) -> {
			Group root = new Group();
			Scene scene = new Scene(root, 400, 400);
			Image img = new Image("C:\\Users\\hp\\OneDrive\\سطح المكتب\\ستيكرز\\frame.jpg");
			ImageView im = new ImageView(img);
			root.getChildren().add(im);
			Label label = new Label("enter the id of the student");
			TextField text = new TextField();
			Button btn = new Button("press");
			GridPane pane2 = new GridPane();
			pane2.add(label, 0, 1);
			pane2.add(text, 0, 2);
			pane2.add(btn, 0, 3);
			pane2.setLayoutX(0);
			pane2.setLayoutY(110);
			pane2.setHgap(200);

			root.getChildren().add(pane2);

			Button btnUpdate2 = new Button("enter");
			Label labelBranch = new Label(" branch ");
			Label labelAverage = new Label("average ");
			TextField textBranch = new TextField();
			TextField textAverage = new TextField();
			btn.setOnAction((ActionEvent e1) -> {
				int y = Integer.parseInt(text.getText());
				if (studentMain.list.search3(y) != null) {
					
					Alert x = new Alert(AlertType.NONE);
					x.setAlertType(AlertType.CONFIRMATION);
					x.setHeaderText(" this id doesnt exist try with another one");
					x.show();
					return;

				}
				GridPane pane3 = new GridPane();
				pane3.add(labelBranch, 0, 1);
				pane3.add(labelAverage, 0, 2);
				pane3.add(textBranch, 1, 1);
				pane3.add(textAverage, 1, 2);
				pane3.add(btnUpdate2, 0, 3);
				pane3.setPadding(new Insets(50));
				pane3.setLayoutX(-40);
				pane3.setLayoutY(200);
				pane3.setAlignment(Pos.CENTER_LEFT);
				text.clear();
				btnUpdate2.setOnAction((ActionEvent e2) -> {
					double x = Double.parseDouble(textAverage.getText());
					Student std = new Student(y, textBranch.getText(), x);
					studentMain.update(std);
					Label label2 = new Label("done");
					pane3.add(label2, 0, 5);
					textBranch.clear();
					textAverage.clear();

				});
				root.getChildren().add(pane3);

			});

			Stage newWindow = new Stage();
			newWindow.setScene(scene);
			newWindow.initModality(Modality.WINDOW_MODAL);
			newWindow.initOwner(primaryStage);
			newWindow.show();
		});

	}

	public void run(File file) throws FileNotFoundException {

		try (Scanner in = new Scanner(file)) {
			while (in.hasNextLine()) {
				Student object;
				String line = in.nextLine();
				String[] array = new String[2];
				array = line.trim().split(",");
				object = new Student(Integer.parseInt(array[0]), array[1], Double.parseDouble(array[2]));
				if (object.branch.trim().equals("Literary")) {
					studentLiterary.insert(object);

				} else {
					studentScintific.insert(object);
				}
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

	}

	public static void main(String args[]) {
		launch(args);
	}
}