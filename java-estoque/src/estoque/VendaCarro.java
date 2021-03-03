package estoque;

import javax.swing.JOptionPane;

/**
 * classe para efetuar o processamento de consulta e nclusão de estoque
 * 
 * @author Elisson Barbieri Machado
 * @since 17 de fev. de 2021
 */
public class VendaCarro {

	// vetor para armazenar os carros cadastrados
	private Carro estoque[];

	// variavel auxiliar para definir o tamanho do estoque
	private int tamanho = 0;

	// metodo construtor da classe
	public VendaCarro() {
		processar();
	}

	// metodo pincipal do programa
	public void processar() {

		// capturando do usuario o tamanho do estoque
		tamanho = Integer.parseInt(JOptionPane.showInputDialog("informe o tamanho do estoque"));

		// definindo o tamanho do estoque de carros
		estoque = new Carro[tamanho];

		// processamento de looping do programa
		while (true) {
			escolhaUsuario();

		}
	}

	// metodo para capturara do usuario a opção
	public void escolhaUsuario() {
		String menu = "informe a opção desejada\n" + "OPÇÃO 1: Cadastrar carro\n" + "OPÇÃO 2: Listar estoque\n"
				+ "OPÇÃO 3: Consultar carro\n" + "OPÇÃO 4: pesquisar por modelo	\n"
				+ "OPÇÃO 5: Pesquisar por combustvel\n" + "OPÇÃO 6: Listar carros em promoção\n"
				+ "OPÇÃO 7: Sair do sistema";
		int escolha = Integer.parseInt(JOptionPane.showInputDialog(menu));
		escolhaProcessamento(escolha);
	}

	// metodo para seleção das opções do programa
	public void escolhaProcessamento(int opcao) {
		switch (opcao) {
		case 1:
			cadastrarCarro();
			break;

		case 2:
			listarEstoque();
			break;

		case 3:
			consultarCarro();
			break;

		case 4:
			pesquisarPorModelo();
			break;

		case 5:
			pesquisarPorCombustivel();
			break;

		case 6:
			listarCarroEmPromocao();
			break;

		case 7:
			sairDoSistema();
			break;
		default:
			JOptionPane.showInternalMessageDialog(null, "Opção inválida!", "cadastro de estoque", 0);// erro
			break;
		}
	}

	// metodo para cadastrar um novo carro no estoque
	public void cadastrarCarro() {
		// variavel auxiliar para verificar se gravou
		boolean gravado = false;

		// laço para verificar espaço em estoque
		for (int i = 0; i < estoque.length; i++) {
			if (estoque[i] == null) {
				estoque[i] = criarCarro();
				gravado = true;
				break;
			}
		}

		// exibindo o resultado para o usuario
		if (gravado) {
			JOptionPane.showMessageDialog(null, "Veiculo gravado com sucesso", "Cadastro de estoque", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Estoque cheio", "Cadastro de sestoque", 2);

		}
	}

	// método para devolver um carro para cadastro de estoque
	public Carro criarCarro() {
		Marca marca = new Marca();
		Modelo modelo = new Modelo();
		Carro carro = new Carro();

		// recebendo do usuario o nome da marca do carro
		marca.setNome(JOptionPane.showInputDialog("Informe o nome da marca"));

		// recebendo do usuario o nome da marca do carro
		modelo.setNome(JOptionPane.showInputDialog("Informe o nome do modelo"));

		// atribuindo a marca ao modelo
		modelo.setMarca(marca);

		// recebendo os dados do carro
		carro.setPlaca(JOptionPane.showInputDialog("Informe a placa"));
		carro.setVelocidadeMaxima(Integer.parseInt(JOptionPane.showInputDialog("Informe velocidade máxima")));
		carro.setCombustivel(JOptionPane.showInputDialog("Informe o combustível"));

		int disponivel = Integer.parseInt(JOptionPane.showInputDialog("1 - Disponivel \n2 - Não disponivel"));

		if (disponivel == 1) {
			carro.setDisponivel(true);
		} else {
			carro.setDisponivel(false);
		}

		int promocao = Integer.parseInt(JOptionPane.showInputDialog("1 - Em promoção \n2 - Não está em promoção"));

		if (promocao == 1) {
			carro.setPromocao(true);
		} else {
			carro.setPromocao(false);
		}
		carro.setValor(Double.parseDouble(JOptionPane.showInputDialog("Informe o valor ")));
		carro.setValorPromocao(Double.parseDouble(JOptionPane.showInputDialog("Informe o valor em promoção")));
		carro.setDesconto(Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do desconto")));

		// atribuindo o valor ao carro
		carro.setModelo(modelo);

		return carro;
	}

	// método para listar o estoque total
	public void listarEstoque() {
		// variavel euxiliar para exibir estoque para o usuario
		String mensagem = "";

		// varrendo o estoque para ver se existe carro cadastrado
		for (int i = 0; i < estoque.length; i++) {
			if (estoque[i] != null) {
				mensagem += (i + 1) + " - " + estoque[i].getModelo().getNome() + "\n";
			}
		} // fim do for

		// exibindo o estoque ao usuario
		JOptionPane.showMessageDialog(null, mensagem, "cadastro de estoque", 1);
	}

	// método para consulta carro
	public void consultarCarro() {
		// variavel euxiliar para exibir mensagem para o usuario
		String mensagem = "informe o codigo do veiculo a ser consultado\n\n";

		// varrendo o estoque para verificar os carros cadastrados
		for (int i = 0; i < estoque.length; i++) {
			if (estoque[i] != null) {
				mensagem += "codigo " + (i + 1) + " - " + estoque[i].getModelo().getNome() + "\n";
			}
		}

		// capturando o modelo a ser consultado
		int codigo = Integer.parseInt(JOptionPane.showInputDialog(mensagem));

		// inicializando a variavel auxiliar para exibir mensagem
		mensagem = "";
		mensagem += "Modelo.....:  " + estoque[codigo - 1].getModelo().getNome() + "\n";
		mensagem += "Marca......:  " + estoque[codigo - 1].getModelo().getMarca().getNome() + "\n";
		mensagem += "Placa......:  " + estoque[codigo - 1].getPlaca() + "\n";
		mensagem += "Combustivel:  " + estoque[codigo - 1].getCombustivel() + "\n";
		mensagem += "Vel máxima.:  " + estoque[codigo - 1].getVelocidadeMaxima() + "\n";

		// VERIFICA se esta disponivel
		if (estoque[codigo - 1].isDisponivel()) {
			mensagem += "Disponivel.: SIM\n";
		} else {
			mensagem += "Disponivel.: NÃO\n";
		}

		// VERIFICA se esta em promoção
		if (estoque[codigo - 1].isDisponivel()) {
			mensagem += "promoção...: SIM\n";
			mensagem += "Valor......: " + estoque[codigo - 1].getValorPromocao() + "\n";
		} else {
			mensagem += "promoção...: NÃO\n";
			mensagem += "Valor......: " + estoque[codigo - 1].getValor() + "\n";
		}

		// exibindo o resultado da consulta para o usuario
		JOptionPane.showMessageDialog(null, mensagem, "cadastro de estoque", 1);

	}

	// método para retornar todos os carros por modelo escolhido
	public void pesquisarPorModelo() {

		// recebendo do usuario qual modelo a ser pesquisado
		String modelo = JOptionPane.showInputDialog("informe o modelo a ser pesquisado");

		// variavel auxiliar para exibir o resultado apresentado
		String mensagem = "pesquisa por modelo\n\n";

		// variavel auxiliar para verificar se existe o modelo cadastrado
		boolean existe = false;

		for (int i = 0; i < estoque.length; i++) {
			if (estoque[i] != null && estoque[i].getModelo().getNome().equals(modelo)) {
				mensagem += mensagem(estoque[i]);
				existe = true;
			}

		}

		// exibindo o resultado da pesquisa
		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, "cadastro de estoque", 1);
		} else {
			JOptionPane.showMessageDialog(null, "nao existem carros cadastrados", "cadastro de estoque", 2);
		}

	}// fim do metodo

	// método para retornar os carros por modelo escolhido
	public void pesquisarPorCombustivel() {
		// recebendo do usuario qual combustivel a ser pesquisado
		String combustivel = JOptionPane.showInputDialog("informe o combustivel a ser pesquisado");

		// variavel auxiliar para exibir o resultado apresentado
		String mensagem = "pesquisa por combustivel\n\n";

		// variavel auxiliar para verificar se existe o combustivel cadastrado
		boolean existe = false;

		// varrendo o vetor e verificando o carro cadastrado
		for (int i = 0; i < estoque.length; i++) {
			if (estoque[i] != null && estoque[i].getCombustivel().equals(combustivel)) {
				mensagem += mensagem(estoque[i]);
				existe = true;
			}
		}

		// exibindo o resultado da pesquisa
		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, "cadastro de estoque", 1);
		} else {
			JOptionPane.showMessageDialog(null, "nao existem carros cadastrados", "cadastro de estoque", 2);
		}

	}

	// método para retornar todos os carros em promoção
	public void listarCarroEmPromocao() {
		// recebendo do usuario qual modelo a ser pesquisado
		String promocao = JOptionPane.showInputDialog("Informe a promoção para pesquisa");
		boolean aux = false;
		if (promocao.equals("SIM")) {
			aux = true;
		}

		// variavel auxiliar para exibir a mensagem do resultado pesquisado
		String mensagem = "Pesquisa por promoção:\n\n";

		// variavel auxiliar para verificar se existe o modelo cadastrado
		boolean existe = false;

		// varrendo o vetor e verificando o carro cadastrado
		for (int i = 0; i < estoque.length; i++) {
			if (estoque[i] != null && estoque[i].isPromocao() == aux) {
				mensagem += mensagem(estoque[i]);
				existe = true;
			}
		} // fim do for

		// exibindo o resultado da pesquisa para o usuario
		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, "Cadastro de Estoque", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Não existe o modelo cadastrado", "Cadastro de Estoque", 2);
		}
	}

	// metodo para montar mensagem para o usuario
	public String mensagem(Carro carro) {
		// variavel auxiliar para retornar a mensagem formatada
		String msg = "/n";

		// formatando a mensagem
		msg += "Modelo.....:  " + carro.getModelo().getNome() + "\n";
		msg += "Marca......:  " + carro.getModelo().getMarca().getNome() + "\n";
		msg += "Placa......:  " + carro.getPlaca() + "\n";
		msg += "Combustivel:  " + carro.getCombustivel() + "\n";
		msg += "Vel máxima.:  " + carro.getVelocidadeMaxima() + "\n";

		// retornando a varivel formatada
		return msg;
	}

	// método para sair do sistema
	public void sairDoSistema() {
		System.exit(0);
	}
}
