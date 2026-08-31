#!/usr/bin/env python

import sys
input = sys.stdin.buffer.readline
from collections import deque
from heapq import heappush, heappop, heapify
sys.setrecursionlimit(10**6)

def main():
    T = int(input())
    for ti in range(T):
        ans = 0
        N = int(input())
        L,R = [],[]
        for _ in range(N):
            k,l,r = map(int,input().split())
            ans += min(l,r)
            if l > r:
                L.append((l-r,k))
            elif l < r:
                if N-k > 0:
                    R.append((r-l,N-k))
        L.sort(key=lambda x: x[1])
        R.sort(key=lambda x: x[1])
        LC = deque(L)
        RC = deque(R)

        H = []
        for i in range(1,N+1):
            while LC and LC[0][1] == i:
                heappush(H, LC.popleft())
            while len(H) > i:
                heappop(H)
        while H:
            ans += heappop(H)[0]

        H = []
        for i in range(1,N+1):
            while RC and RC[0][1] == i:
                heappush(H, RC.popleft())
            while len(H) > i:
                heappop(H)
        while H:
            ans += heappop(H)[0]
        
        print(ans)
        
if __name__ == "__main__":
    main()