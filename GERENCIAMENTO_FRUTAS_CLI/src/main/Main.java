package main;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		 * Primeiramente são realizadas duas instâmcias,a primeira é uma
		 * instância de um "Scanner" para entrada de valores pelo terminal, e
		 * a segunda é a instância de um "ArrayList" para armazenar os nomes das
		 * frutas, e consequentemente manipular os dados armazenados.
		 */
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> frutas = new ArrayList<>();
		
		/*
		 * Para execução das funções que o programa irá executar, é criado
		 * um loop para que o usuário manipule os dados de forma infinita, até
		 * que ele opte por sair.
		 */
		while (true) {
			/*
			 * Para o usuário é exibido as opções disponíveis, para que ele escolha
			 * oque deseja realizar no sistema, para isso, o número digitado é
			 * armazenado dentro da variável "opcao" que é verificada dentro do 
			 * switch para realizar a ação escolhida.
			 */
			try {
				System.out.println("\nEscolha uma opção:");
				System.out.println("1. Adicionaruma fruta");
				System.out.println("2. Listar todas as frutas");
				System.out.println("3. Modificar uma fruta");
				System.out.println("4. Remover uma fruta");
				System.out.println("5. Sair");
				System.out.print("Opção: ");
				
				int opcao = scanner.nextInt();
				scanner.nextLine();
				
				switch (opcao) {
				/*
				 * Caso escolha o número 1, o programa solicita que o usuário escreva o nome
				 * da fruta que deseja adicionar, e com o auxilio do método "add" a fruta escrita
				 * é adicionada ao "ArrayList", por fim uma mensagem de confirmação é informada. 
				 */
				case 1:
					System.out.println("Digite o nome da fruta para adicionar: ");
					String novaFruta = scanner.nextLine();
					frutas.add(novaFruta);
					System.out.println(novaFruta + " foi adicionada.");
					break;
				/*
				 * Caso escolha o número 2, o programa irá listar todas as frutas armazenada dentro
				 * do "ArrayList", caso não haja nenhuma fruta armazenada, o código volta
				 * para o menu de opções.
				 */
				case 2:
					System.out.println("Frutas: " + frutas);
					break;
				/*
				 * Caso escolha o número 3, o código irá dar a opção de atualizar um dado armazenado
				 * no "ArrayList", para isso, será perguntado ao usuário qual o índice da fruta no array,
				 * isso quer dizer, em qual espaço do array ela está armazenada, após isso, uma condição
				 * "if" irá verificar se o número do índice existe dentro do array, caso a condição seja
				 * real, o programa irá pedir o novo nome de fruta que será armazenado, e através do "set"
				 * irá substituir a fruta que está armazenada pela nova fruta. Porém, caso o índice informado
				 * seja inválido, é informada uma mensagem de erro.
				 */
				case 3:
					System.out.println("Digite o índice da fruta que deseja modificar: ");
					int indiceModificar = scanner.nextInt();
					scanner.nextLine();
					if (indiceModificar >= 0 && indiceModificar < frutas.size()) {
						System.out.println("Digite o novo nome da fruta: ");
						String frutaModificada = scanner.nextLine();
						frutas.set(indiceModificar, frutaModificada);
						System.out.println("Fruta no índice " + indiceModificar + " foi modificada para " + frutaModificada);
					} else {
						System.out.println("Índice inválido.");
					}
					break;
				/*
				 * Caso escolha o número 4, o pragrama irá dar a opção de remover uma fruta armazenada.
				 * Para isso será armazenado o nome da fruta que deseja remover em uma variável, e dentro
				 * de uma condição "if" o nome informado será buscado dentro do "ArrayList" caso seja encontrado
				 * a fruta é removida, caso não seja é informado que a fruta não foi localizada.
				 */
				case 4:
					System.out.println("Digite o nome da fruta que deseja remover: ");
					String frutaRemover = scanner.nextLine();
					if (frutas.remove(frutaRemover)) {
						System.out.println(frutaRemover + " foi removida.");
					} else {
						System.out.println(frutaRemover + " não foi encontrada.");
					}
					break;
				/*
				 * Caso escolha o número 5, como última opção, o programa encerra e informa uma mensagem de saída,
				 * o "Scanner" é fechado.
 				 */
				case 5:
					System.out.println("Saindo...");
					scanner.close();
					return;
				/*
				 * Caso o número da opção informada seja inválido, o "default" é acionado e uma
				 * mensagem de erro é enviada. 
				 */
				default:
					System.out.println("Opção inválida. Tente novamente.");
				}
			/*
			 * Para garantir que alguma opção seja escolhida o bloco "catch" informa uma mensagem de erro
			 * e pede que pelo menos alguma das opções seja escolhida.
			 */
			} catch (InputMismatchException e) {
				System.out.println("Entrada inválida. Por favor, digite um número.");
				scanner.nextLine();
			}
		}
	}

}
