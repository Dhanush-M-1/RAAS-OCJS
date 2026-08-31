n, m = map(int, input().split())
l = set()
for i in range(1, m + 1):
    l.add(i)
d = set()
for i in range(n):
    s = list(map(int, input().split()))
    del s[0]
    d.update(s)
if d == l:
    print('YES')
else:
    print('NO')