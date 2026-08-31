n,m=[int(x) for x in input().split()]
o=set()
p=set()
for i in range(1,m+1):
    o.add(i)
for i in range(n):
    lis=[int(x) for x in input().split()]
    lis1=lis[1::1]
    p.update(lis1)
if o==p:
    print('YES')
else:
    print('NO')
