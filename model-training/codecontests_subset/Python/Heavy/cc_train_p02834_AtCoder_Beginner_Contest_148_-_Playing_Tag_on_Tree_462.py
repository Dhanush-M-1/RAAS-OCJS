N,u,v = map(int,input().split())
l = []
from collections import defaultdict
from collections import deque
d = defaultdict(list)
for i in range(N-1):
    ta,tb = map(int,input().split())
    d[ta-1].append(tb-1)
    d[tb-1].append(ta-1)

def dfs(x):

    l = deque()
    l.append(x-1)
    dp = [-1] * N
    dp[x-1] = 0
    # print(l)
    while l:
        t = l.pop()
        for i in d[t]:
            # print(i)
            if dp[i] ==-1:
                dp[i] = dp[t]+1
                l.append(i)
        # print(l)
    return dp

distu = dfs(u)
distv = dfs(v)
M = 0
for i , j in zip(distu,distv):
    if i < j:
        M = max(M,j-1)
print(M)
