t = int(input())
for _ in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    ans = -1
    if a[0]+a[1] <= a[n-1]:
        ans = '1 2 ' + str(n)
    print(ans)