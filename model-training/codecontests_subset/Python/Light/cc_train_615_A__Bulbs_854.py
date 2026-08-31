n,m=map(int,input().split())
s=set()
for i in range(n):
    x,*l=map(int,input().split())
    l=set(l)
    s|=l
if len(s)==m: print('YES')
else: print('NO')