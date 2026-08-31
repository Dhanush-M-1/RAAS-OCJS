n=input()
k=int(input())
m=len(n)
DP=[[[0]*(k+1) for _ in range(2)] for _ in range(m+1)]

DP[0][0][0]=1

for i in range(1,m+1):
    N=int(n[i-1])
    for j in range(k+1):
        DP[i][1][j] +=DP[i-1][1][j]
        if N!=0:DP[i][1][j] +=DP[i-1][0][j]
        else:DP[i][0][j] +=DP[i-1][0][j]
        if j!=0:
            DP[i][1][j] +=9*DP[i-1][1][j-1]
            if N!=0:
                DP[i][0][j] +=DP[i-1][0][j-1]
                DP[i][1][j] +=(N-1)*DP[i-1][0][j-1]

print(DP[m][0][k]+DP[m][1][k])