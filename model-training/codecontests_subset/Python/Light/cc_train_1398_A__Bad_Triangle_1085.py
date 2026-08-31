t=int(input())
for _ in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    a.sort()
    s=a[0]+a[1]
    flag=0
    for i in range(2,n):
        if a[i]>=s:
            flag=1
            break
    if flag:
        print(1,2,i+1)
    else:
        print(-1)