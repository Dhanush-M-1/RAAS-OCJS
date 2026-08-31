#!/usr/bin/env python3
import sys
from heapq import heappush, heappop, heapify
from collections import deque
sys.setrecursionlimit(10**8)
def input(): return sys.stdin.readline().strip()
def INT(): return int(input())
def MAP(): return map(int, input().split())
def LIST(): return list(map(int, input().split()))
def ZIP(n): return [LIST() for _ in range(n)]
def NSTR(n): return [input() for _ in range(n)]


INF = float("inf")
MOD = 10**9 + 7


def main():
    T = INT()
    for t in range(T):
        solve()
    return

def solve():
    # 解説PDFの指針
    N = INT()
    left_camel = []
    right_camel = []
    ans = 0
    for k, l, r in ZIP(N):
        if l >= r:
            left_camel.append((l-r, k))
            ans += r
        else:
            right_camel.append((r-l, N-k))
            ans += l
    left_camel.sort(key=lambda x: x[1])
    right_camel.sort(key=lambda x: x[1])
    left_camel = deque(left_camel)
    right_camel = deque(right_camel)
    # print(left_camel, right_camel)
    for camels in [left_camel, right_camel]:
        S = []
        while len(camels) > 0 and camels[0][1] == 0:
            camels.popleft()
        for j in range(1, N+1):
            while len(camels) > 0 and camels[0][1] == j:
                heappush(S, camels.popleft())
            while len(S) > j:
                heappop(S)
        while S:
            ans += heappop(S)[0]
    print(ans)


if __name__ == '__main__':
    main()
