package locacaodeveiculos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LocadoraVeiculos {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		List<Veiculo> veiculos = new ArrayList();
		List<Locacao> locacoes = new ArrayList();
		while (true) {

			System.out.println("---------------- MENU ----------------");
			System.out.println(" [1] Para cadastrar um veículo.");
			System.out.println(" [2] Para locar um veículo.");
			System.out.println(" [3] Para listar todos os veículos cadastrados.");
			System.out.println(" [4] Para listar todas as locações.");
			System.out.println(" [5] Para encerrar uma locação.");
			int opcao = scanner.nextInt();

			if (opcao == 1) {
				System.out.println("Digite o número correspondente ao tipo de veículo: ");
				System.out.println("[1] Moto");
				System.out.println("[2] Carro");
				System.out.println("[3] Caminhão");
				System.out.println("[4] Onibus");
				int opcaoVeiculo = scanner.nextInt();
				System.out.println("Digite a Placa: ");
				String placa = scanner.next();
				for (int i = 0; i < veiculos.size(); i++) {
					Veiculo veiculo = veiculos.get(i);
					if (placa.equals(veiculo.getPlaca())) {
						System.out.println("O veículo ja esta cadastrado.");
						return;
					}
				}
				System.out.println("Digite o Ano: ");
				int ano = scanner.nextInt();
				System.out.println("Digite a Marca: ");
				String marca = scanner.next();
				System.out.println("Digite a Cor: ");
				String cor = scanner.next();
				if (opcaoVeiculo == 1) {
					System.out.println("Digite a quantidade de cilindradas: ");
					int cilindradas = scanner.nextInt();
					Moto moto = new Moto();
					moto.setPlaca(placa);
					moto.setAno(ano);
					moto.setMarca(marca);
					moto.setCor(cor);
					moto.setCilindradas(cilindradas);
					veiculos.add(moto);
					System.out.println("Veículo cadastrado com sucesso!");
				} else if (opcaoVeiculo == 2) {
					System.out.println("O veículo possui quantas portas? ");
					int portas = scanner.nextInt();
					System.out.println("O veículo possui ar condicionado? ");
					String possuiAr = scanner.next();
					System.out.println("Qual o tipo de câmbio do veículo? ");
					System.out.println("[1] Manual");
					System.out.println("[2] Automático");
					int opcCambio = scanner.nextInt();
					String cambio = null;
					if (opcCambio == 1) {
						cambio = "Manual";
					} else if (opcCambio == 2) {
						cambio = "Automático";
					}
					System.out.println("Qual o tipo de direção do veículo? ");
					System.out.println("[1] Mecânica");
					System.out.println("[2] Hidráulica");
					System.out.println("[3] Elétrica");
					int opcDirecao = scanner.nextInt();
					String direcao = null;
					if (opcDirecao == 1) {
						direcao = "Mecânica";
					} else if (opcDirecao == 2) {
						direcao = "Hidráulica";
					} else if (opcDirecao == 3) {
						direcao = "Elétrica";
					}
					Carro carro = new Carro();
					carro.setPlaca(placa);
					carro.setAno(ano);
					carro.setMarca(marca);
					carro.setCor(cor);
					carro.setPortas(portas);
					carro.setPossuiAr(possuiAr);
					carro.setCambio(cambio);
					carro.setDirecao(direcao);
					veiculos.add(carro);
					System.out.println("Veículo cadastrado com sucesso!");

				} else if (opcaoVeiculo == 3) {
					System.out.println("Qual a capacidade de toneladas do caminhão? ");
					double toneladas = scanner.nextDouble();

					Caminhao caminhao = new Caminhao();
					caminhao.setPlaca(placa);
					caminhao.setAno(ano);
					caminhao.setMarca(marca);
					caminhao.setCor(cor);
					caminhao.setToneladas(toneladas);
					veiculos.add(caminhao);
					System.out.println("Veículo cadastrado com sucesso!");

				} else if (opcaoVeiculo == 4) {
					System.out.println("Qual a quantidades de assentos no ônibus? ");
					int assentos = scanner.nextInt();

					Onibus onibus = new Onibus();
					onibus.setPlaca(placa);
					onibus.setAno(ano);
					onibus.setMarca(marca);
					onibus.setCor(cor);
					onibus.setAssentos(assentos);
					veiculos.add(onibus);
					System.out.println("Veículo cadastrado com sucesso!");
				}

			} else if (opcao == 2) {
				System.out.println("Qual a placa do veículo que você deseja locar? ");
				String placa = scanner.next();
				boolean veiculoExiste = false;
				for (int i = 0; i < veiculos.size(); i++) {
					Veiculo veiculo = veiculos.get(i);
					if (placa.equals(veiculo.getPlaca())) {
						veiculoExiste = true;
					}
				}
				if (!veiculoExiste) {
					System.out.println("Não existe veículo com esta placa.");
					continue;
				}
				boolean veiculoDisponivel = true;
				for (int i = 0; i < locacoes.size(); i++) {
					Locacao locacao = locacoes.get(i);
					Veiculo veiculo = locacao.getVeiculo();
					if (placa.equals(veiculo.getPlaca())) {
						veiculoDisponivel = false;
					}
				}
				if (!veiculoDisponivel) {
					System.out.println("O veículo não esta disponível.");
					continue;
				}

				System.out.println("Qual a categoria da sua CNH? ");
				char categoriaCnh = scanner.next().toUpperCase().charAt(0);
				boolean podeAlugar = false;
				Veiculo veiculo = null;
				for (int i = 0; i < veiculos.size(); i++) {
					veiculo = veiculos.get(i);
					if (placa.equals(veiculo.getPlaca())) {
						if (veiculo instanceof Moto && categoriaCnh == 'A') {
							podeAlugar = true;
						} else if (veiculo instanceof Carro
								&& (categoriaCnh == 'B' || categoriaCnh == 'C' || categoriaCnh == 'D')) {
							podeAlugar = true;
						} else if (veiculo instanceof Caminhao && (categoriaCnh == 'C' || categoriaCnh == 'D')) {
							podeAlugar = true;
						} else if (veiculo instanceof Onibus && categoriaCnh == 'D') {
							podeAlugar = true;
						}
					}
				}
				if (!podeAlugar) {
					System.out.println("A categoria digitada não é compatível com o tipo de veículo.");
					continue;
				}
				System.out.println("Qual o seu número do WhatsApp? ");
				int numWpp = scanner.nextInt();
				Locatario locatario = new Locatario();
				locatario.setCategoriaCnh(categoriaCnh);
				locatario.setNumWpp(numWpp);
				Locacao locacao = new Locacao();
				locacao.setLocatario(locatario);
				locacao.setVeiculo(veiculo);
				locacoes.add(locacao);

			} else if (opcao == 3) {
				System.out.println(veiculos);
			} else if (opcao == 4) {
				System.out.println(locacoes);
			} else if (opcao == 5) {
				System.out.println("Digite a placa do veículo");
				String placa = scanner.next();
				for (int i = 0; i < locacoes.size(); i++) {
					Locacao locacao = locacoes.get(i);
					Veiculo veiculo = locacao.getVeiculo();
					if (placa.equals(veiculo.getPlaca())){
						locacoes.remove(i);
						System.out.println("Locação encerrada.");
					}
				}
			}

		}

	}
}
