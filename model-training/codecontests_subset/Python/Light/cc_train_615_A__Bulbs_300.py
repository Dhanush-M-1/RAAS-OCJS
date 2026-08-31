n,m=map(int,input().split())
s=set()
for t in range(n):
    l=list(map(int,input().split()))
    l=set(l[1:])
    s=s|l
if len(s)==m:
    print('YES')
else:
    print('NO')
