n,m = map(int,input().split())
STATE = [0]*(m+1)
for i in range (n):
    S = [int (x) for x in input().split()]
    for j in range(1,S[0]+1):
        STATE[S[j]]=1
sb = 0 
for i in range (1,m+1):
    if STATE[i]==0:
        sb=1
if (sb==0):
    print('YES')
else:
    print('NO')