a,b = [int(x) for x in input().split()]
l = []
s = []
p = []
for i in range(a):
    t = [int(x) for x in input().split()]
    del t[0]
    l += t
s = list(set(l))
print()
for j in range(1,b+1):
    p.append(j)
if s != p:
    print('NO')
else:
    print('YES')
