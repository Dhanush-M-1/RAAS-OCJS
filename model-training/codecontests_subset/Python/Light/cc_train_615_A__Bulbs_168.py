n, m = [int(i) for i in input().split()]
a = [0]*m
for i in range(n):
    b = [int(i) for i in input().split()]
    for j in range(1, len(b)):
        a[b[j] - 1] = 1
if sum(a) == m: print('YES')
else: print('NO')