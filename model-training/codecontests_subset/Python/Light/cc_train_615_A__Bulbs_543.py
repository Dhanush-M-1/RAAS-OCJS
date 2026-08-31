n,p=map(int,input().split())
bulb=[0]*p
for i in range(n):
    a=list(map(int,input().split()))

    for k in range(1,a[0]+1):
        bulb[a[k]-1]=1

if sum(bulb)==p:
    print('YES')
else:
    print('NO')