n, m = map(int, input().split())
S = [list(map(int, input().split())) for _ in range(n)]
C = [list(map(int, input().split())) for _ in range(m)]

for s in S:
    x, ans = 10**9, 0
    for i, c in enumerate(C):
        y = abs(s[0]-c[0]) + abs(s[1]-c[1])
        if y < x:
            x, ans = y, i+1
    print(ans)
