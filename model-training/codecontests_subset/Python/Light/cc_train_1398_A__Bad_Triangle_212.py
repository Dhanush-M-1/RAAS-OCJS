t = int(input())


def solve(n, a):
    if a[0] + a[1] <= a[-1]:
        print(1, 2, n)
        return
    else:
        print(-1)
        return


for _ in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    solve(n, a)
