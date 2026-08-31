def solve(a, n):
    for i in range(n - 2):
        j = i + 1
        k = n - 1
        if a[i] + a[j] <= a[k]:
            print(f"{i+1} {j+1} {k+1}")
            return
    print(-1)

t = int(input())
for _ in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    solve(a, n)            
