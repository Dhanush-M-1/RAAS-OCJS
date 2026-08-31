n,m=list(map(int,input().split()))
c=[]
for i in range(n):
    a=list(map(int,input().split()))
    del(a[0])
    c=c+a
aa=[i+1 for i in range(m)]
bb=list(set(c))
bb.sort()
if bb==aa:
    print('YES')
else:
    print('NO')