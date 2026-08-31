n, m = map(int, input().split())
l = [0] * m
for i in range(n):
    x, *y = map(int, input().split())
    for h in y:
        l[h - 1] = 1
if 0 in l:
    print('NO')
else:
    print('YES')
