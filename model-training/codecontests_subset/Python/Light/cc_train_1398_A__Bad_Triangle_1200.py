t=int(input())
for _ in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    if a[0]+a[1]<=a[-1]:
        print(1,2,(a.index(a[-1])+1))
    else:
        print(-1)