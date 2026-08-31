T=int(input())
for t in range(T):
    n=int(input())
    l=[int(k) for k in input().split()]
    i=0
    j=1
    k=2
    f=0
    for m in range(2,n):
        if(l[i]+l[j]<=l[m]):
            k=m
            f=1
            break
    if(f==1):
        print(i+1,j+1,k+1)
    else:
        print(-1)