n=int(input())
l=[["a"],["aa","ab"],[],[],[],[],[],[],[],[]]
for i in range(2,10):
  for j in l[i-1]:
    syurui=len(set(list(j)))
    for h in range(syurui+1):
      l[i].append(j+chr(97+h))
for i in l[n-1]:print(i)