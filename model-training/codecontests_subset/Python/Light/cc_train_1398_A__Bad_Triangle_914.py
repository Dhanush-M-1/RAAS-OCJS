
for _ in range(int(input())):
    n=int(input())
    a=list(map(int,input().split()))
    sum=a[0]+a[1]
    t=-2
    for i in range(2,n):
        if a[i]>=sum:
            t=i
            break
    if t>0:
        print(1,2,t+1)
    else:
        print(-1)
