import sys,os,io
input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

maxn = 2*10**5 + 15
dp = [0]*(maxn)
dp[0]=1
mod = 10**9 + 7
for i in range (maxn-13):
    dp[i]%=mod
    if i>=10:
        dp[i+9] += dp[i]
    dp[i+10] += dp[i]
for i in range (1,maxn):
    dp[i]+=dp[i-1]
# print(dp[:30])
for _ in range (int(input())):
    n,m = [int(i) for i in input().split()]
    a = [int(i) for i in str(n)]
    cnt = 0
    ans = 0
    for i in range (len(a)):
        ans += dp[m+a[i]]
        ans %= mod
    print(ans)