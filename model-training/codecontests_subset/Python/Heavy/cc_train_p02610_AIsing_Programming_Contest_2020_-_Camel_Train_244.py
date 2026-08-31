#!/usr/bin/env python3
import sys
from heapq import heappush, heappop, heapify
from collections import deque
from collections import namedtuple
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
    camel = namedtuple("camel", "value, kth")
    ans = 0
    for k, l, r in ZIP(N):
        if l >= r:
            left_camel.append(camel(l-r, k))
            ans += r
        else:
            right_camel.append(camel(r-l, N-k))
            ans += l
    left_camel.sort(key=lambda x: x.kth)
    right_camel.sort(key=lambda x: x.kth)
    left_camel = deque(left_camel)
    right_camel = deque(right_camel)
    for camels in [left_camel, right_camel]:
        S = []
        while camels and camels[0].kth == 0:
            camels.popleft()
        for j in range(1, N+1):
            while camels and camels[0].kth == j:
                heappush(S, camels.popleft())
            while len(S) > j:
                heappop(S)
        while S:
            ans += heappop(S).value
    print(ans)


if __name__ == '__main__':
    main()
