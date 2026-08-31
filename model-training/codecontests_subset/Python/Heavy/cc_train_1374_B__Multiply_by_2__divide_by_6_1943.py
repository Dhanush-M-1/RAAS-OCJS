#import math
#from functools import lru_cache
#import heapq
#from collections import defaultdict
#from collections import Counter
#from collections import deque
#from sys import stdout
#from sys import setrecursionlimit
#setrecursionlimit(10**7)
from sys import stdin
input = stdin.readline

INF = 10**9 + 7
MAX = 10**7 + 7
MOD = 10**9 + 7

for Ti in range(int(input().strip())):
    n = int(input().strip())
    tc = 0
    thc = 0
    while(n%2 == 0):
        n//=2
        tc += 1
    while(n%3==0):
        n//=3
        thc += 1
    if(tc<=thc and n==1):
        ans = 0
        ans += (thc - tc)
        ans += (thc)
        print(ans)
    else:
        print('-1')
            
