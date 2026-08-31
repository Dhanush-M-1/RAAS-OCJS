n,m=[int(x) for x in input().split()]
a=[]
k=[]
for i in range(n):
    t=[int(g) for g in input().split()]
    for l in range(1,len(t)):
        a.append(t[l])
c=set(a)
for w in range(m):
    k.append(w+1)
p=set(k)
if c==p:
    print('YES')
else:
    print('NO')