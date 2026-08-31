b=[]
n,m=map(int,input().split())
for i in range(n):
    a=[int(i) for i in input().split()]
    for i in range(1,len(a)):
        if a[i] not in b:
            b.append(a[i])
if len(b)==m:
    print('YES')
else:
    print('NO')