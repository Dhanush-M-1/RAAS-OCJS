x=input()
L=len(x)
N=[]
for l in range(L):
  N.append(int(x[l]))
N.insert(0,0) 
K=int(input())
dp0=[]
dp1=[]
for l in range(L+1):
  dp0.append([0]*(K+1))
  dp1.append([0]*(K+1))
dp1[0][0]=1
for l in range(1,L+1):
  dp0[l][0]=1
for i in range (1,L+1):
  for j in range(1,K+1):
    if N[i]==0:
      dp0[i][j]=dp0[i-1][j]+9*dp0[i-1][j-1]
      dp1[i][j]=dp1[i-1][j]
    else:
      dp0[i][j]=dp0[i-1][j]+9*dp0[i-1][j-1]+(N[i]-1)*dp1[i-1][j-1]+dp1[i-1][j]
      dp1[i][j]=dp1[i-1][j-1]
print(dp0[L][K]+dp1[L][K])      