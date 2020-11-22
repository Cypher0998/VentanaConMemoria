package dad.ventanaConMemoria.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.scene.paint.Color;
import javafx.beans.binding.Bindings;

public class Model {

	private DoubleProperty rojo;
	private DoubleProperty verde;	
	private DoubleProperty azul;
	private ReadOnlyObjectWrapper<Color> color;
	
	public Model(){
		rojo = new SimpleDoubleProperty();
		verde = new SimpleDoubleProperty();
		azul = new SimpleDoubleProperty();
		color = new ReadOnlyObjectWrapper<Color>();
	color.bind(Bindings.createObjectBinding(() -> {
		return new Color(getRojo() / 256.0, getVerde() / 256.0, getAzul() / 256.0, 1f);
	}, rojo, verde, azul));
	}
	
	public final DoubleProperty rojoProperty() {
		return this.rojo;
	}
	
	public final double getRojo() {
		return this.rojoProperty().get();
	}
	
	public final void setRojo(final double rojo) {
		this.rojoProperty().set(rojo);
	}
	
	public final DoubleProperty verdeProperty() {
		return this.verde;
	}
	
	public final double getVerde() {
		return this.verdeProperty().get();
	}
	
	public final void setVerde(final double verde) {
		this.verdeProperty().set(verde);
	}
	
	public final DoubleProperty azulProperty() {
		return this.azul;
	}
	
	public final double getAzul() {
		return this.azulProperty().get();
	}
	
	public final void setAzul(final double azul) {
		this.azulProperty().set(azul);
	}
	
	public final javafx.beans.property.ReadOnlyObjectProperty<javafx.scene.paint.Color> colorProperty() {
		return this.color.getReadOnlyProperty();
	}

	public final Color getColor() {
		return this.colorProperty().get();
	}
	
	
}