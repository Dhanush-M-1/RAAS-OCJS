n = int(input())

if(n == 1):
  print(1)
else:
  #AS DUAS ARVORES DA PONTA SEMPRE PODEM SER DERRUBADAS
  derrubadas = 2
  arvores = []
  for i in range(n):
    x, altura = input().split()
    x = int(x)
    altura = int(altura)

    arvores.append((x, altura))

  p1 = arvores[0][0]
  for i in range(1, n - 1, 1):
    atual = arvores[i]
    # VAMOS TENTAR DERRUBAR PARA A ESQUERDA
    if (atual[0] - atual[1]) > p1:
      #POSSO DERRUBAR PARA A ESQUERDA
      derrubadas += 1
      p1 = atual[0]
    else:
      proximo = arvores[i + 1]
      #VAMOS TENTAR DERRUBAR PARA A DIREITA
      if (atual[0] + atual[1]) < proximo[0]:
        #POSSO DERRUBAR PARA A DIREITA
        derrubadas += 1
        p1 = atual[0] + atual[1]
      else:
        p1 = atual[0]

  print(derrubadas)