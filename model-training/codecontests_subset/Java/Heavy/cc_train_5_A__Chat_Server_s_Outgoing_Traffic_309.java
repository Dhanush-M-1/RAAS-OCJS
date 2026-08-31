import java.util.Scanner;

public class lista0 {

	public static void main(String[] args) {
		Scanner leia = new Scanner (System.in);
		String mensagem = "";
		String mensagemnova = "";
		int contador = 0;
		int resposta = 0;
		int respostafinal = 0; 
		Lista bancodenomes = new Lista ();
		while(leia.hasNext()){
			mensagem = leia.nextLine();
			if(mensagem.charAt(0)=='+'){
				for(int i =1; i<(mensagem.length());i++){
					mensagemnova = mensagemnova + mensagem.charAt(i);
				}
				bancodenomes.inserir(new Nome(mensagemnova));
				contador++;
				mensagemnova="";
			} else if (mensagem.charAt(0)=='-'){
					for(int i =1; i<(mensagem.length());i++){
						mensagemnova = mensagemnova + mensagem.charAt(i);
					}
				bancodenomes.remover(mensagemnova);
				contador--;
				mensagemnova="";
			} else {
				int x = 0;
				for(int j = 0;j<(mensagem.length());j++){
					if(mensagem.charAt(j)==':'){
						x = j+1;
						break;
					}
				}
				
				
				for(int i = x; x<(mensagem.length());x++){
					mensagemnova = mensagemnova + mensagem.charAt(x);
				}
				
				resposta = (mensagemnova.length())*contador;
				mensagemnova = "";
				
				
			}
			
			respostafinal = resposta + respostafinal;
			resposta=0;
			
		}
		
		System.out.println(respostafinal);

	}

}

class Lista {
	private Nome nome;
	private Lista proximo;
	//CONSTRUTOR
	public Lista () {
		this.nome = null;
		this.proximo = null;
	}
	//METODO
	public void inserir(Nome nome) {
		if (this.nome == null) {
			this.nome = nome;
			this.proximo = new Lista();
		} else {
			this.proximo.inserir(nome);
		}
	}
	//METODO
	public void remover(String nome) {
    	if (this.nome != null) {
    		boolean x = this.nome.pegar().equals(nome);
    		if (x == true) {
    			this.nome = this.proximo.nome;
    			this.proximo = this.proximo.proximo;
    		} else {
    			this.proximo.remover(nome);
    		}
    	} else {
    		System.out.printf("ERROR");
    	}
    }
	
}


class Nome {
	private String nome;
	//CONSTRUTOR
	public Nome (String nome) {
		this.nome = nome;
	}
	//METODO
	public String pegar(){
		return this.nome;
	}
}
// 1519953045388
