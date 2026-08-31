n, m = map(int, input().split())
s = set()
for i in range(n):
    z, *a = map(int, input().split())
    s.update(a)

if len(s) == m:
    print('YES')
else:
    print('NO')