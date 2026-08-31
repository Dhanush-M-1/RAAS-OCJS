t = int(input())
while t>0:
    t-=1
    n = int(input())
    a = list(map(int, input().split()))
    if a[0]+a[1]<=(a[n-1]):
        print(1,2, n )
    else:
        print(-1)