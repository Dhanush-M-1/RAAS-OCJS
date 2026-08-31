def comparadorDePalavras(palavra1, palavra2):
    if(palavra1 == palavra2):
        return True
    if(len(palavra1) != len(palavra2)):
      return False
    if(len(palavra1) % 2 == 1):
        return False
    metade = len(palavra1)//2
 
    palavra1_1 = palavra1[:metade]
   
    palavra2_1 = palavra2[:metade]
    palavra1_2 = palavra1[metade:]
    palavra2_2 = palavra2[metade:]
 
    return (comparadorDePalavras(palavra1_1, palavra2_2) and comparadorDePalavras(palavra1_2, palavra2_1)) or (comparadorDePalavras(palavra1_1, palavra2_1) and comparadorDePalavras(palavra1_2, palavra2_2))
 
 
palavra1 = input()
palavra2 = input()
 
if (comparadorDePalavras(palavra1, palavra2)):
    print('YES') 
else:
    print('NO')