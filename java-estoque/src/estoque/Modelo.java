package estoque;

/**
 * classe para armazenas os atributos e metodos do objeto modelo
 * 
 * @author Elisson Barbieri Machado
 * @since 17 de fev. de 2021
 */
public class Modelo {

	// metodo contrutor da classe
	public Modelo() {

	}

	// declarando os atributos
	private String nome;
	private Marca marca;

	// getter e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

}
