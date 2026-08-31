from sys import *
p = stdin.readline().strip()
n = int(stdin.readline())
f = False
f1 = False
for _ in range(n):
    x = stdin.readline().strip()
    if p == x or p == x[1]+x[0]:
        f = True
        f1 = True
    if p[0] == x[1]:
        f = True
    if p[1] == x[0]:
        f1 = True
    if f1 and f:
        print ("YES")
        break
if not (f1 and f):
    print ("NO")
