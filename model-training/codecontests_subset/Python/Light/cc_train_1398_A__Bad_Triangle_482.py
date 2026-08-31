t = int(input())
for i in range(t):
    n = int(input())
    a = [int(x) for x in input().split()]
    if a[0]+a[1] > a[n-1]:
        print(-1)
    else:
        print(1,2,n)