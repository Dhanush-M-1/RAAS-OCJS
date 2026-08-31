from collections import defaultdict
from heapq import heapify, heappush, heappop
import sys
input = sys.stdin.readline

T = int(input())
anss = []
for _ in range(T):
    N = int(input())
    Ls = defaultdict(list)
    Rs = defaultdict(list)
    ans = 0
    for i in range(N):
        K, L, R = map(int, input().split())
        if L > R:
            Ls[K].append(L-R)
            ans += R
        elif L < R:
            Rs[N-K].append(R-L)
            ans += L
        else:
            ans += L

    def f(Ls):
        PQL = []
        for j in range(1, N+1):
            for L in Ls[j]:
                heappush(PQL, L)
            while len(PQL) > j:
                heappop(PQL)
        return sum(PQL)

    ans += f(Ls)
    ans += f(Rs)

    anss.append(ans)

print('\n'.join(map(str, anss)))
