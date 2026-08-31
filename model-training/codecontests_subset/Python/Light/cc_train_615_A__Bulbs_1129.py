n,m=map(int,input().split())
s=set()
for i in range(n):
    ar=list(map(int,input().split()))
    for j in ar[1:]:
        s.add(j)
if len(s)==m:
    print('YES')
else: print('NO')
