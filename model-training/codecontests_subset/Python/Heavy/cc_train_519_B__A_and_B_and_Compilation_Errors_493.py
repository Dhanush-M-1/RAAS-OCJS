n = int(input())

linha1 = [c for c in input().split()]

dic1 = {}
for c in linha1:
    if c in dic1:
        dic1[c] += 1
    else:
        dic1[c] = 1

linha2 = [c for c in input().split()]

dic2 = {}
for c in linha2:
    if c in dic2:
        dic2[c] += 1
    else:
        dic2[c] = 1

linha3 = [c for c in input().split()]

dic3 = {}
for c in linha3:
    if c in dic3:
        dic3[c] += 1
    else:
        dic3[c] = 1

chave1 = ""
chave2 = ""
for chave in linha1:
    if (not chave in dic2 or dic1[chave] > dic2[chave] and chave1 == ""):
        chave1 = chave
    else: # essa chave nao foi perdida de 1 para 2. agora vemos se a chave foi perdida de 2 para 1
        if (not chave in dic3 or dic2[chave] > dic3[chave]):
            chave2 = chave
    if (chave1 != "" and chave2 != ""):
        break

print(chave1)
print(chave2)

   	 		 		 			  	 					 	 		 	