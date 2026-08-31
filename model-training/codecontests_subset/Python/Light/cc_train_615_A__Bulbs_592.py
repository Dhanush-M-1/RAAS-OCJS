n, m = list(map(int, input().split()))
b = set()
for i in range(n):
    _, *k = list(map(int, input().split()))
    for k2 in k:
        b.add(k2)
if len(b) == m:
    print('YES')
else:
    print('NO')