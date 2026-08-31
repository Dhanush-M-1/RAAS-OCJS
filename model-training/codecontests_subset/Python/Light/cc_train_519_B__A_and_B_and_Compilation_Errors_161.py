from itertools import filterfalse
garbage= int(input())
all_l = []
a = list(map(int, input().rstrip().split(" ")))
b = list(map(int, input().rstrip().split(" ")))
c = list(map(int, input().rstrip().split(" ")))
a.sort()
b.sort()
c.sort()
r = a[-1]
for i in range(len(b)):
    if a[i]!=b[i]:
        r = a[i]
        break
print(r)
r = b[-1]
for j in range(len(c)):
    if b[j]!=c[j]:
        r = b[j]
        break
print(r)