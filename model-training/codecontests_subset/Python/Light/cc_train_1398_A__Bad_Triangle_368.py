t = int(input())
for _ in range(t):
    n = int(input())
    a = list(map(int,input().split()))
    a.sort()
    if a[0]+a[1] > a[n-1] :
        print(-1)
    else:
        print(1,2,n)
    


