def divide_letras(palavra):
    tamanhoPalavra = len(palavra)

    if (tamanhoPalavra % 2 == 1):
        return palavra

    tamanhoPalavra = tamanhoPalavra // 2    
    esquerda = divide_letras(palavra[:tamanhoPalavra])
    direita = divide_letras(palavra[tamanhoPalavra:])
    
    if (direita > esquerda):
      return (direita + esquerda) 
    else:    
      return (esquerda + direita)
 


def stringsEquivalentes(palavraA, palavraB):
  if(divide_letras(palavraA) == divide_letras(palavraB)): 
      print('YES')
  else:
      print('NO')

palavraA = input()
palavraB = input()

stringsEquivalentes(palavraA, palavraB)