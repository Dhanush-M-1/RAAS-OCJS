t=int(input())
for _ in range(0,t):
    n=int(input())
    a=list(map(int,input().split()))
    p=0
    for i in range(len(a)-1,1,-1):
        if a[0]+a[1]<=a[i]:
            p=1
            break
    if p==1:
        print(1,2,(i+1))
    else:
        print(-1)
