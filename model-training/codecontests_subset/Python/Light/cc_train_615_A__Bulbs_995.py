m, n = map(int, input().split())
d = [False] * n
for i in range(m):
    for j in map(int, input().split()[1:]):
        d[j - 1] = True
print('YES' if all(d) else 'NO')