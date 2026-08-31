n,m=map(int,input().split())
bull=[False]*m
for i in range(n):
    botton=list(map(int,input().split()))[1:]
    for p in botton:
        bull[p-1]=True
if False in bull:
    print('NO')
else:
    print('YES')