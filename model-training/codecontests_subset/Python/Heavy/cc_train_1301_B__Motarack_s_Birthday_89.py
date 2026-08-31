INF = int(1e9)
t = int(input())


for _ in range(t):
    n = int(input())
    a = list(map(int,input().split(" ")))

    lb = INF    
    ub = 0
    wid = 0
    for i in range(n-1):
        if a[i]==-1 and a[i+1]==-1: continue
        if a[i]==-1:
            lb = min(lb,a[i+1])
            ub = max(ub,a[i+1])
        elif a[i+1]==-1:
            lb = min(lb,a[i])
            ub = max(ub,a[i])
        else:
            wid = max(wid,abs(a[i+1]-a[i]))

    wid = max(wid,(ub-lb+1)//2)
    k = (lb+ub)//2

    print(wid,k)
    
