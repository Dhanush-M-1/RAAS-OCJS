# MC521 - Desafios de Programacao I - 1s2021
# Contest: 09/04/2021
# Problema F: Stones

# le o numero de casos testes
t = int(input())

# leitura dos casos testes
for _ in range(t):
  # o maior numero de pedras possivel com Alive
  res = 0

  # leitura da quantidade de pedras de cada pilha
  a, b, c = map(int, input().split())

  # calcula a quantidade de pedras a serem tomadas
  # numero maximo de repeticoes da operacao 2 (b e c) 
  op2 = min(c//2, b)
  # numero maximo de repeticoes da operacao 1 (a e b) + op2
  op = min((b-op2)//2, a) + op2
  
  # calcula a quantidade de pedras considerando o numero de operacoes realizadas
  res += op*3

  # imprime o resultado
  print(res)
     				 	   				 				    		