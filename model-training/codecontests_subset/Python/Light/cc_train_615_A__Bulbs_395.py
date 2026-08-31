n,m=map(int,input().split())
op=[]
for i in range(n):
    ip=list(map(int,input().split()))
    ip.remove(ip[0])
    for j in ip:
        if j not in op:
            op.append(j)
if len(op)==m:
    print('YES')
else:
    print('NO')
