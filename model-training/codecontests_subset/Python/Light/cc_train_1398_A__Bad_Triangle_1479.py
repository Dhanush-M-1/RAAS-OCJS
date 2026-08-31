for _ in range(int(input())):
    n=int(input())
    a=list(map(int,input().split()))
    c=0
    if a[0]+a[1]<=a[-1]:
        print(1,2,n)
        c=1
    if c==0:
        print(-1)