t=int(input())
for _ in range(t):
    n=int(input())
    l=list(map(int,input().split()))
    f=0
    for x in range(n-2):
        
        if l[x]+l[x+1]<=l[n-1]:
            print(x+1,x+2,n)
            f=1
            break
    if(f==0):
        print(-1)

