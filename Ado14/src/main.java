import java.util.Scanner;

public class main {
	public static char matriz[][] = new char[3][3];

	public static void main(String[] args) {
		int numeroDeJogadas = 0;
		char resultado = ' ';
		inicializaMatriz();
		do {
			imprimeMatriz();
			jogadaDoUsuario(1, 'X');
			numeroDeJogadas++;
			resultado = verificaVencedor();
			
			imprimeMatriz();
			jogadaDoUsuario(2, 'O');
			numeroDeJogadas++;
			resultado = verificaVencedor();
		} while ((resultado == ' ') && (numeroDeJogadas != 9));
		imprimeMatriz();
		
	}

	public static void inicializaMatriz() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				matriz[i][j] = ' ';
	}

	public static void imprimeMatriz() {
		for (int i = 0; i < 3; i++) {
			System.out.printf(" %c | %c | %c ", matriz[i][0], matriz[i][1], matriz[i][2]);
			if (i != 2)
				System.out.printf("\n---|---|---\n");
		}
		System.out.printf("\n");
	}

	public static void jogadaDoUsuario(int usuario, char simbolo) {

		Scanner sc = new Scanner(System.in);

		int posicao = 0;
		usuario = 0;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (usuario % 2 == 0) {
					simbolo = 'X';
					System.out.println("Escolha uma posição dentre as disponiveis: ");
					posicao = sc.nextInt();

					if (posicao == 1 && matriz[0][0] == ' ') {
						matriz[0][0] = simbolo;
						imprimeMatriz();
					} else if (posicao == 2 && matriz[0][1] == ' ') {
						matriz[0][1] = simbolo;
						imprimeMatriz();
					} else if (posicao == 3 && matriz[0][2] == ' ') {
						matriz[0][2] = simbolo;
						imprimeMatriz();
					} else if (posicao == 4 && matriz[1][0] == ' ') {
						matriz[1][0] = simbolo;
						imprimeMatriz();
					} else if (posicao == 5 && matriz[1][1] == ' ') {
						matriz[1][1] = simbolo;
						imprimeMatriz();

					} else if (posicao == 6 && matriz[1][2] == ' ') {
						matriz[1][2] = simbolo;
						imprimeMatriz();

					} else if (posicao == 7 && matriz[2][0] == ' ') {
						matriz[2][0] = simbolo;
						imprimeMatriz();

					} else if (posicao == 8 && matriz[2][1] == ' ') {
						matriz[2][1] = simbolo;
						imprimeMatriz();

					} else if (posicao == 9 && matriz[2][2] == ' ') {
						matriz[2][2] = simbolo;
						imprimeMatriz();
					} else {
						System.out.println("Posição invalida");
						usuario -= 1;
					}

					usuario++;
				} else if (usuario % 2 != 0) {
					simbolo = 'O';
					System.out.println("Escolha uma posição dentre as disponiveis: ");
					posicao = sc.nextInt();

					if (posicao == 1 && matriz[0][0] == ' ') {
						matriz[0][0] = simbolo;
						imprimeMatriz();
					} else if (posicao == 2 && matriz[0][1] == ' ') {
						matriz[0][1] = simbolo;
						imprimeMatriz();
					} else if (posicao == 3 && matriz[0][2] == ' ') {
						matriz[0][2] = simbolo;
						imprimeMatriz();
					} else if (posicao == 4 && matriz[1][0] == ' ') {
						matriz[1][0] = simbolo;
						imprimeMatriz();
					} else if (posicao == 5 && matriz[1][1] == ' ') {
						matriz[1][1] = simbolo;
						imprimeMatriz();

					} else if (posicao == 6 && matriz[1][2] == ' ') {
						matriz[1][2] = simbolo;
						imprimeMatriz();

					} else if (posicao == 7 && matriz[2][0] == ' ') {
						matriz[2][0] = simbolo;
						imprimeMatriz();

					} else if (posicao == 8 && matriz[2][1] == ' ') {
						matriz[2][1] = simbolo;
						imprimeMatriz();

					} else if (posicao == 9 && matriz[2][2] == ' ') {
						matriz[2][2] = simbolo;
						imprimeMatriz();
					} else {
						System.out.println("Posição invalida");
						usuario -= 1;
					}

					usuario++;
				}

				if (verificaVencedor() == 'X') {
					System.out.println("Parabéns jogador numero 1");
					System.exit(i);
				} else if (verificaVencedor() == 'O') {
					System.out.println("Parabéns jogador numero 2");
					System.exit(i);
				}else if(verificaVencedor()== 'A' && i == 2 && j ==2) {
					System.out.println("o Jogo Empatou");
					System.exit(i);
				}
			}
		}

	}

	public static char verificaVencedor() {
// Verifica as linhas
		for (int i = 0; i < 3; i++)
			if (matriz[i][0] == matriz[i][1] && matriz[i][0] == matriz[i][2])
				return matriz[i][0];
// Verifica as colunas
		for (int i = 0; i < 3; i++)
			if (matriz[0][i] == matriz[1][i] && matriz[0][i] == matriz[2][i])
				return matriz[0][i];
//Verifica diagonais
		if (matriz[0][0] == matriz[1][1] && matriz[1][1] == matriz[2][2])
			return matriz[0][0];
		if (matriz[2][0] == matriz[1][1] && matriz[1][1] == matriz[0][2])
			return matriz[0][2];
//Se não encontrou vencedor, retorna "espaço"
		return 'A';
	}
}