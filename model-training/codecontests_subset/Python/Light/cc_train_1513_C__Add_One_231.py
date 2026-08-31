from sys import stdin, stdout 
s = "0"
curr = 1
count = 0
check = 0
dp = [1]
for i in range(100):
    fin = ""
    for i in s:
        num = int(i)
        num += 1
        num = str(num)
        fin = fin+num
    dp.append(len(fin))
    s = (fin)
tog = 101
mod = 10**9 + 7
for i in range(2*(10**5)):
    num = (dp[tog-1] + dp[tog-9]-dp[tog-11]) % mod
    dp.append(num)
    tog += 1

t=t=int(stdin.readline())
for test in range(t):
    n,m=map(int,stdin.readline().split())
    ans=0
    while(n>0):
        temp=n%10
        ans = (ans+ dp[temp+m])%mod
        n=n//10
    stdout.write(str(ans)+'\n') 

