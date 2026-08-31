t = int(input())
for i in range(t):
    n = int(input())
    a = list(map(int,input().split()))
    minimo = 100000000000
    maximo = 0
    for i in range(len(a)):
        if (i>0 and a[i]==-1 and a[i-1] != -1):
            minimo=min(minimo,a[i-1])
            maximo=max(maximo,a[i-1])
        if (i<len(a)-1 and a[i]==-1 and a[i+1] != -1):
            minimo=min(minimo,a[i+1])
            maximo=max(maximo,a[i+1])

    if minimo==100000000000 and maximo == 0:
        res2=0
    else:
        res2=int((minimo+maximo)/2)
    a=[res2 if x==-1 else x for x in a]
    diff=0
    for i in range(len(a)-1):
        if abs(a[i]-a[i+1])>diff:
            diff=abs(a[i]-a[i+1])
    print(diff,end=" ")
    print(res2)
    