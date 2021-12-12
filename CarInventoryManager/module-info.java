module CarInventoryManager {
	requires javafx.controls;
	requires javafx.base;
	requires com.opencsv;
	requires javafx.graphics;
	
	opens application to javafx.graphics, javafx.fxml, javafx.base;
}
