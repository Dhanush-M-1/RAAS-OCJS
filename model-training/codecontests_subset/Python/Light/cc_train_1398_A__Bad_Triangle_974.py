mod = 10**9 + 7
def solve():
    n = int(input())
    a = list(map(int, input().split()))
    if a[0] + a[1] <= a[n - 1]:
        print(1, 2, n)
    else:
        print(-1)
t = 1
t = int(input())
for _ in range(t):
    solve()