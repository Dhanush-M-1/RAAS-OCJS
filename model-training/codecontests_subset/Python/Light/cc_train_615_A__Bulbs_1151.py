y=input().split()
m=int(y[0])
n=int(y[1])
S=[0 for i in range(n+1)]
M=[list(map(int,input().split())) for i in range(m)]
for i in range(m) :
    for j in range(1,M[i][0]+1) :
        S[M[i][j]]=S[M[i][j]]+1
k=S.count(0)
if k>1 :
    print('NO')
else :
    print('YES')
