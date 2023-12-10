package aulaas;
import java.util.Scanner;
import java.util.Stack;
public class Expressoesmatematicas {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Digite uma expressão matemática:");
	        String expressao = scanner.nextLine();

	        if (verificaParametrizacao(expressao)) {
	            System.out.println("A expressão está corretamente parametrizada.");
	        } else {
	            System.out.println("A expressão não está corretamente parametrizada.");
	        }

	        scanner.close();
	    }

	    private static boolean verificaParametrizacao(String expressao) {
	        Pilha<Character> pilha = new Pilha<>();

	        for (char caractere : expressao.toCharArray()) {
	            if (caractere == '(' || caractere == '[' || caractere == '{') {
	                pilha.push(caractere);
	            } else if (caractere == ')' || caractere == ']' || caractere == '}') {
	                if (pilha.isEmpty() || !parametrosCorrespondentes(pilha.pop(), caractere)) {
	                    return false;
	                }
	            }
	        }

	        return pilha.isEmpty(); // A pilha deve estar vazia se a expressão for válida
	    }

	    private static boolean parametrosCorrespondentes(char aberto, char fechado) {
	        return (aberto == '(' && fechado == ')') ||
	               (aberto == '[' && fechado == ']') ||
	               (aberto == '{' && fechado == '}');
	    }
	}


