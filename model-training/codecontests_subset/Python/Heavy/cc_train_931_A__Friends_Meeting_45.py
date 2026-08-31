class encontro_dos_parcas:
    def __init__(self):
        self.resposta = ''
        self.entrada_1 = 0
        self.entrada_2 = 0

    def leitura(self):
        self.entrada_1 = int(input())
        self.entrada_2 = int(input())

    def solucao(self):
        distancia = abs(self.entrada_1 - self.entrada_2)
        if distancia % 2:
            amigo_1 = distancia // 2
            amigo_2 = distancia // 2 + 1
        else:
            amigo_1 = distancia // 2
            amigo_2 = distancia // 2
        cansaco_geral = sum([x + 1 for x in range(amigo_1)])
        cansaco_geral += sum([x + 1 for x in range(amigo_2)])
        self.resposta = str(cansaco_geral)

    def resultado(self):
        return self.resposta


if __name__ == "__main__":
    questao = encontro_dos_parcas()
    questao.leitura()
    questao.solucao()
    print(questao.resultado())
 			 		     	   	 		       	  	