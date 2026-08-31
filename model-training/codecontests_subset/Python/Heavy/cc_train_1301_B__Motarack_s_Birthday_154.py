def calc(u):
    global n, a
    ans = 0
    for i in range(n - 1):
        x = a[i]
        y = a[i + 1]
        if x == -1:
            x = u
        if y == -1:
            y = u
        ans = max(ans, abs(x - y))
    return ans
def check(u):
    return calc(u + 1) - calc(u)
def solve():
    global n, a
    n = int(input())
    a = list(map(int, input().split()))
    l, r = 0, 10 ** 9 + 1
    if check(l) >= 0:
        print(calc(0), 0)
        return
    while r - l > 1:
        mid = (l + r) // 2
        if check(l) * check(mid) > 0:
            l = mid
        else:
            r = mid
    print(*min(((calc(i), i) for i in range(max(0, l - 2), min(10 ** 9, l + 2)))))
t = int(input())
for _ in range(t):
    solve()