from heapq import heappush, heappop
import sys
input = sys.stdin.readline

def calc(camels, N):
    camels.sort(key=lambda x: x[0])
    heap = []
    for i, x in camels:
        heappush(heap, x)
        if len(heap) > i:
            heappop(heap)
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
    ans += calc(first, N) + calc(second, N)
    print(ans)