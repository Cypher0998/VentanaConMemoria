package dad.ventanaConMemoria.app;

import dad.ventanaConMemoria.controller.Controller;
import dad.ventanaConMemoria.controller.CrearConfig;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	private Controller controlador;
	private CrearConfig configuracion = new CrearConfig();
	
	@Override
	public void init() throws Exception {
		configuracion.cargarFichero();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		controlador = new Controller();
		
		controlador.getModel().rojoProperty().bindBidirectional(configuracion.redProperty());
		controlador.getModel().verdeProperty().bindBidirectional(configuracion.greenProperty());
		controlador.getModel().azulProperty().bindBidirectional(configuracion.blueProperty());

		primaryStage.setX(configuracion.getLocationX());
		primaryStage.setY(configuracion.getLocationY());
		
		configuracion.locationXProperty().bind(primaryStage.xProperty());
		configuracion.locationYProperty().bind(primaryStage.yProperty());

		Scene scene = new Scene(controlador.getView(), configuracion.getWidth(), configuracion.getHeight());
		
		configuracion.heightProperty().bind(scene.heightProperty());
		configuracion.widthProperty().bind(scene.widthProperty());
		
		primaryStage.setTitle("Ventana con memoria");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	@Override
	public void stop() throws Exception {
		configuracion.guardarFichero();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
