package br.com.massenan.gestaodecontratos.domain;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum ContratoTipoEnum {

	IMOBILIARIO("Contrato Imobiliário", 0), CONTABILIDADE("Contrato para Contador", 1), TRABALHO("Contrato de Trabalho", 2);

	private final String tipo;
	private final int id;

	private ContratoTipoEnum(String tipo, int id) {
		this.tipo = tipo;
		this.id = id;
	}

	public static ContratoTipoEnum fromText(String text) {

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
