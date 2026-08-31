from sys import stdin,stdout
from itertools import accumulate
nmbr = lambda: int(input())
lst = lambda: list(map(int, input().split()))
PI=float('inf')
for _ in range(1):#nmbr()):
    na,nb,o=lst()
    a=sorted(lst())
    b=sorted(lst())
    dp=[[PI for _ in range(nb+1)] for _ in range(na+1)]
    # print(a)
    # print(b)
    for i in range(nb+1):
        dp[0][i]=0
    for i in range(1,na+1):
        for j in range(1,nb+1):
            dp[i][j] = min(dp[i][j-1], max(dp[i-1][j-1] ,abs(a[i-1]-b[j-1])+abs(o-b[j-1])))
    # print(*dp,sep='\n')
    print(dp[na][nb])