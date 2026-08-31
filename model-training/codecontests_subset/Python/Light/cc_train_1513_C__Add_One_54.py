from sys import stdin,stdout
z=10**9+7
dp={}
for i in range(200009):
    if i<9:
        dp[i]=2
    elif i==9:
        dp[i]=3
    else:
        dp[i]=(dp[i-9]+dp[i-10])%z
for _ in range(int(input())):
    n,m=stdin.readline().split()
    n=int(n);m=int(m)
    ans=0
    while n>0:
        i=n%10
        if (m+i)<10:
            ans+=1
        else:
            ans+=((dp[m+i-10])%z)
        ans=ans%z
        n//=10
    stdout.write(str(ans)+'\n')