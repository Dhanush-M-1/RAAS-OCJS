n, m = (int(x) for x in input().split())
s = set()
for i in range(n):
    [s.add(x) for i, x in enumerate(input().split()) if i != 0]
if len(s) == m:
    print('YES')
else:
    print('NO')
