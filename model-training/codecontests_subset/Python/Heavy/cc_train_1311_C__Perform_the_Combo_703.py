from collections import Counter
from sys import stdin
N = int(stdin.readline().rstrip())
for i in range(N):
    n,m = [int(x) for x in stdin.readline().rstrip().split()]
    s = (stdin.readline().rstrip())
    p = [int(x) for x in stdin.readline().rstrip().split()]
    
    cumsum = [0] * (n+1)
    cumsum[n] += 1
    for j in p:
        cumsum[j] += 1
     
    for k in range(n-1,0,-1):
        cumsum[k] += cumsum[k+1]
    ans = [0] * 26
    
    for ind,l in enumerate(s):
        ans[ord(l)-ord('a')] += cumsum[ind+1]

    for m in ans:
        print(m,end=' ')
    print('')