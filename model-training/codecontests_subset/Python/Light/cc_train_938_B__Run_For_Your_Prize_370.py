import sys

n = int(input())
a = list(input().split(' '))
a = list(int(x) for x in a)
res = 0
a.sort()
l  = list(x for x in range(n))
r = list(x for x in range(n))
res = sys.maxsize
for i in range(n-1):
    res = min(res, max(a[i]-1, int(1e6) - a[i+1]))
res = min(res, a[n-1]-1)
res = min(res, int(1e6) - a[0])
print(res)
