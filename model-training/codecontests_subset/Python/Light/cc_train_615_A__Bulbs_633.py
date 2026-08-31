n, m = map(int, input().split())
s = set()
for i in range(n):
    w = [int(x) for x in input().split()][1:]
    for j in w:
        s.add(j)
if len(s) < m:
    print('NO')
else:
    print('YES')