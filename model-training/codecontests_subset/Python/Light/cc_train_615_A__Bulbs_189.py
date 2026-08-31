n,m=map(int,input().split())
l1=[]
for i in range(n):
    x=input().split()
    for t in x[1:]:
        if t not in l1:
            l1.append(t)
if len(l1)==m:
    print('YES')
else:
    print('NO')