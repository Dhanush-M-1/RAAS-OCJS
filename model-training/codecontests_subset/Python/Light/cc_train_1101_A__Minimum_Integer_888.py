n = int(input())
entradas = []
saida = []

for i in range(n):
  entradas.append(input())

for j in (entradas):
  entrada = j.split()
  achou = False
  k = 1
  while not achou:
    num = int(entrada[2])*k
    if(num < int(entrada[0]) or num > int (entrada[1])):
      achou = True
      saida.append(num)
    else:
      if num < int(entrada[0]):
        k += 1
      else:
        if num < int(entrada[1]):
          k += int(int(entrada[1])/int(entrada[2]))
        else:
          k+=1

for l in (saida):
  print (int(l))

	 		  		  			     		   	   		