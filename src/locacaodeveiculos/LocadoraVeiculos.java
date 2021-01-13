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
			System.out.println(" [1] Para cadastrar um ve�culo.");
			System.out.println(" [2] Para locar um ve�culo.");
			System.out.println(" [3] Para listar todos os ve�culos cadastrados.");
			System.out.println(" [4] Para listar todas as loca��es.");
			System.out.println(" [5] Para encerrar uma loca��o.");
			int opcao = scanner.nextInt();

			if (opcao == 1) {
				System.out.println("Digite o n�mero correspondente ao tipo de ve�culo: ");
				System.out.println("[1] Moto");
				System.out.println("[2] Carro");
				System.out.println("[3] Caminh�o");
				System.out.println("[4] Onibus");
				int opcaoVeiculo = scanner.nextInt();
				System.out.println("Digite a Placa: ");
				String placa = scanner.next();
				for (int i = 0; i < veiculos.size(); i++) {
					Veiculo veiculo = veiculos.get(i);
					if (placa.equals(veiculo.getPlaca())) {
						System.out.println("O ve�culo ja esta cadastrado.");
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
					System.out.println("Ve�culo cadastrado com sucesso!");
				} else if (opcaoVeiculo == 2) {
					System.out.println("O ve�culo possui quantas portas? ");
					int portas = scanner.nextInt();
					System.out.println("O ve�culo possui ar condicionado? ");
					String possuiAr = scanner.next();
					System.out.println("Qual o tipo de c�mbio do ve�culo? ");
					System.out.println("[1] Manual");
					System.out.println("[2] Autom�tico");
					int opcCambio = scanner.nextInt();
					String cambio = null;
					if (opcCambio == 1) {
						cambio = "Manual";
					} else if (opcCambio == 2) {
						cambio = "Autom�tico";
					}
					System.out.println("Qual o tipo de dire��o do ve�culo? ");
					System.out.println("[1] Mec�nica");
					System.out.println("[2] Hidr�ulica");
					System.out.println("[3] El�trica");
					int opcDirecao = scanner.nextInt();
					String direcao = null;
					if (opcDirecao == 1) {
						direcao = "Mec�nica";
					} else if (opcDirecao == 2) {
						direcao = "Hidr�ulica";
					} else if (opcDirecao == 3) {
						direcao = "El�trica";
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
					System.out.println("Ve�culo cadastrado com sucesso!");

				} else if (opcaoVeiculo == 3) {
					System.out.println("Qual a capacidade de toneladas do caminh�o? ");
					double toneladas = scanner.nextDouble();

					Caminhao caminhao = new Caminhao();
					caminhao.setPlaca(placa);
					caminhao.setAno(ano);
					caminhao.setMarca(marca);
					caminhao.setCor(cor);
					caminhao.setToneladas(toneladas);
					veiculos.add(caminhao);
					System.out.println("Ve�culo cadastrado com sucesso!");

				} else if (opcaoVeiculo == 4) {
					System.out.println("Qual a quantidades de assentos no �nibus? ");
					int assentos = scanner.nextInt();

					Onibus onibus = new Onibus();
					onibus.setPlaca(placa);
					onibus.setAno(ano);
					onibus.setMarca(marca);
					onibus.setCor(cor);
					onibus.setAssentos(assentos);
					veiculos.add(onibus);
					System.out.println("Ve�culo cadastrado com sucesso!");
				}

			} else if (opcao == 2) {
				System.out.println("Qual a placa do ve�culo que voc� deseja locar? ");
				String placa = scanner.next();
				boolean veiculoExiste = false;
				for (int i = 0; i < veiculos.size(); i++) {
					Veiculo veiculo = veiculos.get(i);
					if (placa.equals(veiculo.getPlaca())) {
						veiculoExiste = true;
					}
				}
				if (!veiculoExiste) {
					System.out.println("N�o existe ve�culo com esta placa.");
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
					System.out.println("O ve�culo n�o esta dispon�vel.");
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
					System.out.println("A categoria digitada n�o � compat�vel com o tipo de ve�culo.");
					continue;
				}
				System.out.println("Qual o seu n�mero do WhatsApp? ");
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
				System.out.println("Digite a placa do ve�culo");
				String placa = scanner.next();
				for (int i = 0; i < locacoes.size(); i++) {
					Locacao locacao = locacoes.get(i);
					Veiculo veiculo = locacao.getVeiculo();
					if (placa.equals(veiculo.getPlaca())){
						locacoes.remove(i);
						System.out.println("Loca��o encerrada.");
					}
				}
			}

		}

	}
}
