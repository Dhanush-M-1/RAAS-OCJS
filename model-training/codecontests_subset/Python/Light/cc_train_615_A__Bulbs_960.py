n, m = map(int, input().split())
s = set()
for i in range(n):
    o = list(map(int, input().split()))
    o = o[1:]
    for j in o:
        s.add(j)
p = set(range(1, m + 1))
ans = len(p - s)
if ans == 0:
    print('YES')
else:
    print('NO')