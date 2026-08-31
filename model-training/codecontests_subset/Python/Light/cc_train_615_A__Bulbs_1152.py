a=[int(x) for x in input().split()]
l=[]
c=0
for i in range (a[0]):
    b=[int(y)for y in input().split()]
    del b[0]
    l=l+b
for j in range(a[1]):
    if j+1 in l:
       c=c+1
if c==a[1]:
    print('YES')
else:
    print('NO')
