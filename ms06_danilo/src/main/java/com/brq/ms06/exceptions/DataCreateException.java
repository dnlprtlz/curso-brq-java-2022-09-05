package com.brq.ms06.exceptions;

public class DataCreateException extends RuntimeException{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public  DataCreateException(String mensagem){
        super(mensagem);
    }

    public DataCreateException(String mensagem, Throwable causa){
        super(mensagem,causa);
    }
}