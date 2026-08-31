a=[int(i) for i in input().split(' ')]
g=[]
while a[0]>0:
    a[0]-=1
    b=[int(i) for i in input().split(' ')]
    g+=[i for j,i in zip(range(len(b)),b) if j>0]
s=set(g)
if len(s)==a[1]:
    print('YES')
else:
    print('NO')