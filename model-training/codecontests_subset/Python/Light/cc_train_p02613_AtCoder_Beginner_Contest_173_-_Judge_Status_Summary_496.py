N=int(input())
from collections import Counter
S=[input() for i in range(N)]
c=Counter(S)
for s in ('AC','WA','TLE','RE'):
    print(s,'x',c[s])