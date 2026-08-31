from collections import deque
from heapq import heappush, heappushpop
import sys
input = sys.stdin.readline

def calc(camels):
    camels = deque(sorted(camels, key=lambda x: x[0]))
    N = len(camels)
    heap = []
    while camels and camels[0][0] == 0:
        camels.popleft()
    for i in range(1, N+1):
        while camels and camels[0][0] == i:
            _, x = camels.popleft()
            if len(heap) < i:
                heappush(heap, x)
            elif heap[0] < x:
                heappushpop(heap, x)
    for _, x in camels:
        if len(heap) < N:
            heappush(heap, x)
        elif heap[0] < x:
            heappushpop(heap, x)
    return sum(heap)

T = int(input())
for _ in range(T):
    N = int(input())
    s = 0
    ans = 0
    first = []
    second = []
    for i in range(N):
        K, L, R = map(int, input().split())
        if L >= R:
            first.append((K, L - R))
            ans += R
        else:
            second.append((N - K, R - L))
            ans += L
    ans += calc(first) + calc(second)
    print(ans)