import sys
from heapq import heappush, heappop

readline = sys.stdin.readline


def solve():
    N = int(readline())

    left = [[] for _ in range(N)]
    right = [[] for _ in range(N)]
    ans = 0
    for _ in range(N):
        K, L, R = map(int, readline().split())
        if L > R:
            ans += R
            left[K - 1].append(L - R)
        else:
            ans += L
            if 0 <= N - K - 1:
                right[N - K - 1].append(R - L)

    for vec in (left, right):
        hq = []
        n = len(vec)

        for i in range(n):
            for p in vec[i]:
                heappush(hq, p)
            while len(hq) > i + 1:
                heappop(hq)

        for i in range(n, N):
            for p in vec[i]:
                heappush(hq, p)
            while len(hq) > n:
                heappop(hq)

        ans += sum(hq)

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
