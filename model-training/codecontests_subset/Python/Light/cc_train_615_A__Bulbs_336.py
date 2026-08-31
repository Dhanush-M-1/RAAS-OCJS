n,m=[int(x) for x in input().split()]
s=[]
for i in range(n):
    t=[int(x) for x in input().split()]
    for i in range(1,len(t)):
        s.append(t[i])
w=set(s)
if len(w)==m:
    print('YES')
else:
    print('NO')