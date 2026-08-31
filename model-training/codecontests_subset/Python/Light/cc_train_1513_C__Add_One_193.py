from sys import stdin
dp=[0]*(2*10**5+1)
for i in range(9):
    dp[i]=2
dp[9]=3
for i in range(10,2*10**5+1):
    dp[i]=(dp[i-9]+dp[i-10])%(10**9+7)
for _ in range(int(input())):
    n,m=map(int,stdin.readline().split())
    n=str(n)
    a=[0]*len(n)
    ans=0
    for i in n:
        temp=int(i)+m
        if temp<10:
            ans+=1
        else:
            ans+=dp[m+int(i)-10]%(10**9+7)
    print((ans)%(10**9+7))
