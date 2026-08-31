n,m=[int(x) for x in input().split()]
tmp=set([i for i in range(1,m+1)])
for i in range(n):
    tmp-=set([int(x) for x in input().split()][1:])
if tmp==set():print("YES")
else:print('NO')
