inf=10**10
par=[int(i) for i in str(input()).split()]
n,k,p=par[0],par[1],par[2]

person=[int(i) for i in str(input()).split()]
key=[int(i) for i in str(input()).split()]

person=sorted(person)
key=sorted(key)

dp=[[inf for i in range(k)] for j in range(n)]

for i in range(n):
    for j in range(k):
        if i==0:
            if j==0:
                dp[i][j]=min(dp[i][j],abs(person[i]-key[j])+abs(p-key[j]))
                continue
        if i>j:
            dp[i][j]=inf
            continue
        a=dp[i-1][j-1] if i>0 else -1
        dp[i][j]=min(dp[i][j-1],max(a,abs(person[i]-key[j])+abs(p-key[j])))

print(dp[n-1][k-1])
