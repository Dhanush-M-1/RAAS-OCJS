k = int(input())
s = input()
letras = []
contador = []

for i in range(len(s)):
    if s[i] not in letras:
        letras.append(s[i])
        contador.append(0)
        for j in range(len(s)):
            if (s[j] == s[i]):
                contador[letras.index(s[i])] += 1

kstring = True
for num in contador:
    if num%k != 0:
        kstring = False
        break

if kstring == True:
    for i in range(k):
        for j in range(len(letras)):
            print(letras[j]*(contador[j]//k),end = "")
    print("")
else:
    print(-1)
