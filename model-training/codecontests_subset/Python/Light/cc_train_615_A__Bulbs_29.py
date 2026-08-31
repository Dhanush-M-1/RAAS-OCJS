__author__ = 'Admin'
n, m = map(int, input().split())
b = []
a = [[int(j) for j in input().split()]for i in range(n)]
for i in range(m):
    b.append(i + 1)
for i in range(n):
    for j in range(1, len(a[i])):
        for k in range(len(b)):
            if a[i][j] == b[k]:
                b.pop(b.index(b[k]))
                break
        if len(b) == 0:
            break
if len(b) == 0:
    print('YES')
else:
    print('NO')