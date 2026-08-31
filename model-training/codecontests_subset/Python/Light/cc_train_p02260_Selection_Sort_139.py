# -*- coding:utf8 -*-

n = int(input())
l = list(map(int, input().split()))
c = 0
for i in range(n):
    minj = i + l[i:].index(min(l[i:]))
    if minj != i:
        l[i], l[minj] = l[minj], l[i]
        c += 1
print(' '.join(map(str, l)))
print(c)
