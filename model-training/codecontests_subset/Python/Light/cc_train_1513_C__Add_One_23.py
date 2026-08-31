from sys import stdin
input=stdin.readline

mod=10**9+7
def add(a,b):return ((a%mod) + (b%mod))%mod


dp=[1]*(2*(10**5) + 10)

for i in range(10,2* (10**5) + 10):
    dp[i]=add(dp[i-9],dp[i-10])


def answer():
    ans=0
    for i in str(n):
        
        ans=add(ans,dp[m+int(i)])
        
    return ans

for T in range(int(input())):
    n,m=map(int,input().strip().split())

    print(answer())

    
    
