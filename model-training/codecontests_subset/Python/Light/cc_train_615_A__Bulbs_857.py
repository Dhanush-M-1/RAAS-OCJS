n,m=map(int,input().split())
l=[]
for i in range(n):
    a=list(map(int,input().split()))
    l.extend(a[1:])
    
if(set(l)==set(range(1,m+1))):
    print('YES')
else:
    print('NO')