package estoque;

/**
 * classe para armazenas os atributos e metodos do objeto carro
 * 
 * @author Elisson Barbieri Machado
 * @since 17 de fev. de 2021
 */
public class Carro {
	
	//metodo contrutor da classe
	public Carro() {
	}
	
	// declarando os atributos
	private Modelo modelo;
	
	
	//metodos para acessar os atributos
	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getVelocidadeMaxima() {
		return velocidadeMaxima;
	}

	public void setVelocidadeMaxima(int velocidadeMaxima) {
		this.velocidadeMaxima = velocidadeMaxima;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public boolean isPromocao() {
		return promocao;
	}

	public void setPromocao(boolean promocao) {
		this.promocao = promocao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getValorPromocao() {
		return valorPromocao;
	}

	public void setValorPromocao(Double valorPromocao) {
		this.valorPromocao = valorPromocao;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	

	private String placa;
	private int velocidadeMaxima;
	private String combustivel;
	private boolean disponivel;
	private boolean promocao;
	private Double valor;
	private double valorPromocao;
	private Double desconto;

}
