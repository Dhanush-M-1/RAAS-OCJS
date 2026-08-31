n,m=map(int, input().split())
yij=[]
for i in range(n):
    bulbs=input().split()
    yij+=(bulbs[1:])
if len(set(yij))==m:
    print('YES')
else:
    print('NO')