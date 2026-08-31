mod=10**9 + 7
def factorial(n):
    dp=[1 for x in range(n)]
    for i in range(2,n):
        dp[i]=((i%mod)*(dp[i-1]%mod))%mod
    return dp
def circular(n):
    if n==3:
        return 2
    multiplier=1
    sum=0
    i=0
    fact=factorial(n)
    while True:
        x=n-2-i
        y=fact[n-1-i]%mod
        i+=1
        z=((x%mod)*(y%mod)*(multiplier%mod))%mod
        multiplier=(multiplier*2)%mod
        sum=(sum%mod+(z%mod))%mod
        if x==1:
            break
    return sum
t=int(input())
print(circular(t))