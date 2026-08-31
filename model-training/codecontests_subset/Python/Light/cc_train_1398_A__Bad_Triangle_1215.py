t = int(input())
for _ in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    for i in range(1, n - 1):
        if a[n-1] >= a[0] + a[i]:
            print(1, i+1, n)
            break
    else:
        print(-1)