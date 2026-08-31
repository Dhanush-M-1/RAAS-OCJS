n,m=[int(x) for x in input().split(' ')]
l=set()
z=[]
for _ in range(n):
    l=[int(x) for x in input().split(' ')]
    n1,l1=l[0],l[1:]
    for x in l1:
        z.append(x)
a=set(z)
if len(a)==m:
    print('YES')
else:
    print('NO')
