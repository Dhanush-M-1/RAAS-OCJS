n,m=map(int,input().split())
l=[]
for i in range(n):
    a=list(map(int,input().split()))
    for _ in a[1:]:
        l.append(_)
for j in range(m):
    if j+1 not in l:
        print('NO')
        break
else:
    print('YES')