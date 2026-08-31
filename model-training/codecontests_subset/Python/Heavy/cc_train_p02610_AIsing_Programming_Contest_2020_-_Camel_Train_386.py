# E - Camel Train
import sys
from heapq import heappop, heappush

readline = sys.stdin.buffer.readline


def maximize_happiness() -> int:
    res = 0
    lefty, righty = [], []

    N = int(readline())
    for _ in range(N):
        k, l, r = map(int, readline().split())
        if k == N or l == r:
            res += l
        elif l > r:
            res += l
            lefty.append((k, l - r))
        else:
            res += r
            righty.append((N - k, r - l))

    for camels in [lefty, righty]:
        camels.sort()
        heap = []
        for k, diff in camels:
            heappush(heap, diff)
            if k < len(heap):
                res -= heappop(heap)

    return res


def main():
    T = int(readline())
    res = [maximize_happiness() for _ in range(T)]
    print("\n".join(map(str, res)))


if __name__ == "__main__":
    main()
