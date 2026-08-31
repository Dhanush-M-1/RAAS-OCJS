n, m = [int(x) for x in input().split()]
l = [0] * m
for i in range(n):
    li = [int(x) for x in input().split()]
    k = li[0]
    for j in range(k):
        l[li[j+1]-1] = 1
if l.count(0) == 0:
    print('YES')
else:
    print('NO')