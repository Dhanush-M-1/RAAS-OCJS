num_de_elem, divisor = map(int, input().split())

sequencia1 = list(map(int, input().split()))
sequencia2 = list(map(int, input().split()))
sequencia2.sort()

aux1 = []
for i in range(num_de_elem):
  aux1.append((sequencia2[0] - sequencia1[i]) % divisor)

aux1 = list(set(aux1))
aux2 = []
while aux2 != sequencia2:
  for indice in aux1:
    aux2 = []
    for j in range(num_de_elem):
      aux2.append((sequencia1[j]+indice) % divisor)
    aux2.sort()
    if aux2 == sequencia2:
      break

print(indice)
	 			  					 	 	  			  						 	