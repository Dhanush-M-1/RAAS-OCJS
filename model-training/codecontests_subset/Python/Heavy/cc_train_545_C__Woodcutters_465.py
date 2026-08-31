n = int(input())
 
if(n == 1):
  print(1)
else:
  derrubadas = 2
  arvores = []
  for i in range(n):
    x, altura = [ int(x) for x in input().split() ]
    arvores.append((x, altura))
 
  p1 = arvores[0][0]
  for i in range(1, n - 1):
    atual = arvores[i]
    if (atual[0] - atual[1]) > p1:
      derrubadas += 1
      p1 = atual[0]
    else:
      proximo = arvores[i + 1]
      if (atual[0] + atual[1]) < proximo[0]:
        derrubadas += 1
        p1 = atual[0] + atual[1]
      else:
        p1 = atual[0]
 
  print(derrubadas)
		 	  	      	 	 	    			 				