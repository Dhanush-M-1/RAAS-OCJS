n,m=map(int,input().split())
bulbs=[False]*m
for i in range(n):
    l=[int(x) for x in input().split()]
    j=1
    while(j<=l[0]):
        if not bulbs[l[j]-1]:
            bulbs[l[j]-1]=True
        j+=1
for k in range(m):
    if(not bulbs[k]):
        print('NO')
        break
else:
    print('YES')