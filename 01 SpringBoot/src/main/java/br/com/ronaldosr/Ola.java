package br.com.ronaldosr;

public class Ola {

	private final long id;
	private final String content;
	
	public long getId() {
		return id;
	}
	
	public String getContent() {
		return content;
	}
	
	public Ola(long id, String content) {
		this.id = id;
		this.content = content;
	}
}
