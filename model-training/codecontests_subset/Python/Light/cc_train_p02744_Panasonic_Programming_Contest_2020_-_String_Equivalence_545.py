n=int(input())
l=[["a"]]+[[] for i in range(9)]
for i in range(9):
  for j in l[i]:
    k=len(set(list(j)))
    for h in range(k+1):
      l[i+1].append(j+chr(97+h))
for i in l[n-1]:print(i)
