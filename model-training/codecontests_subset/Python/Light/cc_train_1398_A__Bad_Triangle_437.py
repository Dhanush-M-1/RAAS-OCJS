def solve():
    n = int(input())
    a = list(map(int, input().split()))

    if a[0] + a[1] <= a[-1]:
        print(1, 2, n)
        return
    print(-1)

for i in range(int(input())):
    solve()