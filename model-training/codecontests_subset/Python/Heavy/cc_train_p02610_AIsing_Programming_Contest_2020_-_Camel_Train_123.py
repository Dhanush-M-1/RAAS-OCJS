import sys
from heapq import *
input = sys.stdin.readline

def get_happiness(camels):
    camels.sort(reverse=True)
    N = len(camels)
    ret = 0

    hq = []
    for i in range(1, N + 1):
        while camels and camels[-1][0] == i:
            _, diff = camels.pop()
            heappush(hq, diff)
        while len(hq) > i:
            heappop(hq)

    while camels:
        _, diff = camels.pop()
        ret += diff

    ret += sum(hq)

    return ret


def solution():
    N = int(input())
    left_camels = []
    right_camels = []
    left_sum = 0
    right_sum = 0
    for i in range(N):
        K, L, R = map(int, input().split())
        if L >= R:
            left_sum += R
            left_camels.append((K, L - R))
        else:
            right_sum += L
            if K == N: continue
            right_camels.append((N - K, R - L))
    answer = 0
    answer += left_sum + get_happiness(left_camels)
    answer += right_sum + get_happiness(right_camels)
    print(answer)

if __name__ == "__main__":
    T = int(input())
    for _ in range(T):
        solution()