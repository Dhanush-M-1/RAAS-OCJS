def mdc(a, b):
    while b > 0:
        a, b = b, a % b
    return a

n = int(input())
lista_espadas = [int(c) for c in input().split()]

maior_valor = max(lista_espadas)

lista_roubadas = []
total_roubadas = 0

for espada in lista_espadas:
    lista_roubadas.append(maior_valor - espada)
    total_roubadas += maior_valor - espada

mdc_espadas = lista_roubadas[0]
for espada_roubada in lista_roubadas[1:]:
    mdc_espadas = mdc(mdc_espadas, espada_roubada)

print(total_roubadas // mdc_espadas, mdc_espadas)
										 	  	 			     			 		