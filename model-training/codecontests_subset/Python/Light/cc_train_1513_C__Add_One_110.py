import sys,functools,collections,bisect,math,heapq
input = sys.stdin.readline
#print = sys.stdout.write  
mod = 10**9 + 7
sys.setrecursionlimit(300000)

N = 200001
dp = [0]*N
for i in range(9):
    dp[i] = 2
dp[9] = 3
for i in range(10,N):
    dp[i] = dp[i-9]+dp[i-10]
    dp[i] %= mod 

t = int(input())    
for _ in range(t):
    s,m = input().strip().split()
    m = int(m)
    s = list(map(int,list(s)))
    ans = 0
    for i in s:
        if m-10+i >= 0:
            ans += dp[m-10+i]
        else:
            ans += 1
    ans %= mod
    print(ans)