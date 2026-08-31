def solve(n, a):
    mn = float('INF')
    mx = -float('INF')
    a = [0] + a + [0]
    for i, v in enumerate(a):
        if v == -1 or i == 0 or i == len(a) - 1 or a[i - 1] != -1 and a[i + 1] != -1:
            continue
        mn = min(mn, v)
        mx = max(mx, v)
    if mn == float('INF'):
        print(0, 0)
        return
    ans = (mn + mx) // 2
    f = lambda x, y: y if x == -1 else x
    a = [f(x, ans) for x in a]
    mx = -float('INF')
    for i, v in enumerate(a):
        if i == 0 or i >= len(a) - 2:
            continue
        mx = max(mx, abs(a[i] - a[i+1]))
    print(mx, ans)


def main():
    tc = int(input())
    for _ in range(tc):
        n = int(input())
        a = [int(x) for x in input().split()]
        solve(n, a)


if __name__ == "__main__":
    main()

