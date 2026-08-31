t=int(input())
for i in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    k=a[0]
    m1=0
    
    for j in a:
        if j>=a[0]+a[1]:
            print(1,2,a.index(j)+1)
            break
    else:
        print(-1)
        