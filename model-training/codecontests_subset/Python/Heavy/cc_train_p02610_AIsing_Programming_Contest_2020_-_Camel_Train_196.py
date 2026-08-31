from sys import stdin
from sys import setrecursionlimit
from collections import Counter, deque, defaultdict
from heapq import heapify, heappush, heappop
from math import floor, ceil
from bisect import bisect_left
from itertools import combinations
setrecursionlimit(100000)

INF = int(1e10)
MOD = int(1e9 + 7)

def main():
    from builtins import int, map
    N = int(input())
    total = 0
    L, R = [], []
    for _ in range(N):
        k, l, r = map(int, input().split())
        if l >= r:
            # kより前に入れたい
            L.append((k, l, r))
            total += l
        else:
            # kより後ろに入れたい
            R.append((N - k, r, l))
            total += r

    # Lにとって前から，Rにとって後ろから
    L.sort()
    R.sort()

    queue = []
    for i in range(len(L)):
        k, ai, bi = L[i]
        heappush(queue, ai - bi)
        # 前から入れていき，効果が薄いもの(ai - bi)は消す
        while len(queue) > k:
            value = heappop(queue)
            total -= value
            
    queue = []
    for i in range(len(R)):
        k, ai, bi = R[i]
        heappush(queue, ai - bi)
        # 後ろから入れていき，効果が薄いもの(ai - bi)は消す
        while len(queue) > k:
            value = heappop(queue)
            total -= value

    print(total)


if __name__ == '__main__':
    t = int(input())
    while t > 0:
        t -= 1
        main()