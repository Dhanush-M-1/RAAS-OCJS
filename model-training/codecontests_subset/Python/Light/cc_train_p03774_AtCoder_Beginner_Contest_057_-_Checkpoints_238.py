n, m = map(int, input().split())
s = [list(map(int, input().split())) for _ in range(n)]
p = [list(map(int, input().split())) for _ in range(m)]

for i in range(n):
    l = [0]*m
    for j in range(m):
        l[j] = abs(s[i][0] - p[j][0]) + abs(s[i][1] - p[j][1])
    print((l.index(min(l)) +1))