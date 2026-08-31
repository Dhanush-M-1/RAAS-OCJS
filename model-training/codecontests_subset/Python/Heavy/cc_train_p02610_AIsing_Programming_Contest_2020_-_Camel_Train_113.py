import sys
from heapq import heappush, heappop

readline = sys.stdin.readline


def solve():
    N = int(readline())

    left = []
    right = []
    ans = 0
    for _ in range(N):
        K, L, R = map(int, readline().split())
        if L > R:
            ans += R
            left.append((K - 1, R - L))
        else:
            ans += L
            right.append((N - K - 1, L - R))

    for vec in (left, right):
        vec.sort()
        hq = []
        for idx in range(len(vec) - 1, -1, -1):
            while vec and idx <= vec[-1][0]:
                heappush(hq, vec.pop()[1])
            if hq:
                ans -= heappop(hq)

    return ans


def main():
    T = int(readline())

    ans = [0] * T
    for i in range(T):
        ans[i] = solve()

    print('\n'.join(map(str, ans)))
    return


if __name__ == '__main__':
    main()
