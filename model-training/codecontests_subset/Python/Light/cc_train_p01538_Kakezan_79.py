Q = int(input())
for i in range(Q):
    n = int(input())
    ans = 0
    while n >= 10:
        s = str(n)
        a = 0
        for i in range(len(s) - 1):
            a = max(a, int(s[:i + 1]) * int(s[i + 1:]))
        n = a
        ans += 1
    print(ans)
