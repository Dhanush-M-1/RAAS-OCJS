N=input()
K=int(input())
m=len(N)
 
dp0=[[0]*(m+1) for _ in range(m+1)]
dp1=[[0]*(m+1) for _ in range(m+1)]
dp1[0][0]=1
for i in range(1,m+1):
    dp0[i][0]=1
    
for i in range(m):
    for j in range(m):
        if N[i]=='0':
            dp0[i+1][j+1]=dp0[i][j]*9 + dp0[i][j+1]
            dp1[i+1][j+1]=dp1[i][j+1]
        else:
            dp0[i+1][j+1]=dp0[i][j]*9 + dp0[i][j+1]+dp1[i][j]*(int(N[i])-1)+dp1[i][j+1]
            dp1[i+1][j+1]=dp1[i][j]
if m<K:
  print(0)
else:
  print(dp0[-1][K]+dp1[-1][K])