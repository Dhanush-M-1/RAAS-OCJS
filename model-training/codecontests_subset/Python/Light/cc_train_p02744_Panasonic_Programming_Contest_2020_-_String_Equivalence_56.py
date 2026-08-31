n=int(input())-1
l=[[] for _ in range(10)]
l[0].append('a')
for i in range(n):
  for w in l[i]:
    s = sorted(set(w))
    for c in s:
      l[i+1].append(w+c)
    l[i+1].append(w+chr(ord(s[-1])+1))  
print(*l[n],sep='\n')