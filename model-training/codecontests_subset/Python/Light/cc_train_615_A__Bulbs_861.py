a,b=map(int,input().split())
d=[i for i in range(1,b+1)]
for k in range(a):
    c=list(map(int,input().split()))
    for i in range(1,len(c)):
        d[c[i]-1]=0
if sum(d)==0:
    print('YES')
else:
    print('NO')