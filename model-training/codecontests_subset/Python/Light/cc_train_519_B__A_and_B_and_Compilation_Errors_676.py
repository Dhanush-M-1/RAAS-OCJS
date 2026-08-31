from collections import defaultdict
tamanho = input()

lista_original = defaultdict(int)
for w in input().split(): lista_original[w] += 1

primeira_alteracao = defaultdict(int)
for w in input().split(): primeira_alteracao[w] += 1

segunda_alteracao = defaultdict(int)
for w in input().split(): segunda_alteracao[w] += 1

set0 = set(lista_original.items())
set1 = set(primeira_alteracao.items())
set2 = set(segunda_alteracao.items())

print((set0 - set1).pop()[0])
print((set1 - set2).pop()[0])
 			 	 			       		   	  			  	