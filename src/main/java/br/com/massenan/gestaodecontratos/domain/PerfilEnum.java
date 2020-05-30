package br.com.massenan.gestaodecontratos.domain;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum PerfilEnum {
	
	GESTOR_ADM("Gestor Administrador", 0), GESTOR("Gestor", 1);

	private final String tipo;
	private final int id;

	private PerfilEnum(String tipo, int id) {
		this.tipo = tipo;
		this.id = id;
	}

	public static PerfilEnum fromText(String text) {

		try {
			return Arrays.stream(values()).filter(bl -> bl.getTipo().equalsIgnoreCase(text)).findFirst().get();

		} catch (NoSuchElementException ex) {
			return null;
		}

	}

	public String getTipo() {
		return tipo;
	}

	public int getId() {
		return id;
	}
}
