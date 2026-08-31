def add(x):
    global d, d2
    if x not in d: d[x] = 0
    d[x] += 1
    if d[x] == 2:
        d2[x] = a
    if d[x] == 3:
        del d2[x]

        
import sys
n = int(sys.stdin.readline())
d = {}
d2 = {}
for _ in range(n-1):
    a, b = map(int, sys.stdin.readline().split())
    add(a)
    add(b)


res = 'YES'
for k in d2:
    res = 'NO'
    break
print(res)
