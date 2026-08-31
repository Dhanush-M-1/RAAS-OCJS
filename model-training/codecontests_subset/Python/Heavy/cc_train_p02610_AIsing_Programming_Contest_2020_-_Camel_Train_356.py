import sys
from heapq import heappush, heappop, heappushpop

read = sys.stdin.buffer.read
readline = sys.stdin.buffer.readline
readlines = sys.stdin.buffer.readlines

def main(N, K, L, R):
    left = [[] for _ in range(N)]
    right = [[] for _ in range(N)]
    score = 0
    for k, l, r in zip(K, L, R):
        k -= 1
        if l < r:
            score += l
            right[k].append(r - l)
        else:
            score += r
            left[k].append(l - r)
    q = []
    for n, xs in enumerate(left, 1):
        for x in xs:
            if len(q) < n:
                heappush(q, x)
            else:
                heappushpop(q, x)
    score += sum(q)
    q = []
    for n, xs in enumerate(right[::-1][1:], 1):
        for x in xs:
            if len(q) < n:
                heappush(q, x)
            else:
                heappushpop(q, x)
    score += sum(q)
    return score

T = int(readline())
for _ in range(T):
    N = int(readline())
    K, L, R = [], [], []
    for _ in range(N):
        k, l, r = map(int, readline().split())
        K.append(k)
        L.append(l)
        R.append(r)
    print(main(N, K, L, R))
