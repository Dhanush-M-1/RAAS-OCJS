n, m = map(int, input().split())
s = set()
for i in range(n):
    x = list(map(int, input().split()))[1:]
    for c in x:
        s.add(c)
f = True
for i in range(1, m + 1):
    if i not in s:
        f = False
if f:
    print('YES')
else:
    print('NO')
