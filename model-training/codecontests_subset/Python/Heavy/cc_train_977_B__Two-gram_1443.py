tam = int(input())
string = input()
matriz = []
tam = tam-1
for i in range(tam):
  matriz.append( [0] * 2 )
tam_m = 1

for x in range(tam):
  gram = string[x] + string[x+1]
  achou = 1
  for y in range(tam_m):
    if(achou):
      if(matriz[y][0] == 0):
        matriz[y][0] = gram
        matriz[y][1] = 1
        tam_m = tam_m + 1
      elif(gram == matriz[y][0]):
        matriz[y][1] = matriz[y][1]+1
        achou = 0
qmax = 0
for z in range(tam_m-1):
  if(matriz[z][1] > qmax):
    qmax = matriz[z][1]
    maxgram = matriz[z][0]
print(maxgram)
	 						     		 			   				  			