m, n = map(int, input().split())
x = []
for i in range(m):
    x += list(map(int, input().split()))[1:]
print('YES' if len(set(x)) == n else 'NO')
