#写経
#https://atcoder.jp/contests/aising2020/submissions/15195468
from heapq import heappop, heappush
import sys
input = sys.stdin.readline

def resolve():
    T = int(input())
    for _ in range(T):
        N = int(input())
        ans = 0
        camels0 = [[] for _ in range (N)]
        camels1 = [[] for _ in range (N)]
        for _ in range(N):
            K,L,R = map(int, input().split())
            if L>R:
                camels0[K-1].append(L-R)
            elif L<R and K<N:
                camels1[N-K-1].append(R-L)
            ans += min(L,R)
        
        H = []
        for i in range(N):
            for j in camels0[i]:
                heappush(H,j)
            while len(H) > i+1:
                heappop(H)
        ans += sum(H)
        H = []
        for i in range(N):
            for j in camels1[i]:
                heappush(H,j)
            while len(H) > i+1:
                heappop(H)
        ans += sum(H)
        print(ans)
resolve()