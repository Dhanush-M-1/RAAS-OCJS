import math
#import numpy as np
import itertools
import queue
import bisect
from collections import deque,defaultdict
import heapq as hpq
from sys import stdin,setrecursionlimit
#from scipy.sparse.csgraph import dijkstra
#from scipy.sparse import csr_matrix
ipt = stdin.readline
setrecursionlimit(10**7)

def main():
    t = int(ipt())
    for _ in range(t):
        n = int(ipt())
        camp = [[] for i in range(n+1)]
        camm = [[] for i in range(n+1)]
        ans = 0
        pn = 0
        for i in range(n):
            k,l,r = map(int,ipt().split())
            ans += min(r,l)
            if l >= r:
                camp[k].append(l-r)
                pn += 1
            else:
                camm[k].append(r-l)

        hq = []
        for i in range(1,n+1):
            for j in camp[i]:
                hpq.heappush(hq,j)
            t = len(hq)-i
            for j in range(t):
                hpq.heappop(hq)
        for i in hq:
            ans += i
            
        hq = []
        for i in range(n):
            for j in camm[n-i]:
                hpq.heappush(hq,j)
            t = len(hq)-i
            for j in range(t):
                hpq.heappop(hq)
        for i in hq:
            ans += i

        print(ans)



    return None

if __name__ == '__main__':
    main()
