n,m=map(int,input().split())
t=[True]*m
for i in range(n):
    a=list(map(int,input().split()))
    for j in a[1:]:
        t[j-1]=False
for i in t:
    if i:
        print('NO')
        break
else:
    print('YES')
