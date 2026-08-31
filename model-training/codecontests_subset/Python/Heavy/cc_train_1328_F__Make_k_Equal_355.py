import heapq
from collections import defaultdict
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10 ** 7)


def main():
    n, k = map(int, input().split())
    a = list(map(int, input().split()))

    d = [[-1 for i in range(2*(10**5)+1)] for j in range(n)]

    l = []
    for i in range(n):
        c = 0
        while True:
            l.append(a[i])
            d[i][a[i]] = c
            if a[i] == 0:
                break
            a[i] //= 2
            c += 1
    ans = float("inf")
    for v in set(l):
        tans = 0
        cnt = 0
        val = []
        heapq.heapify(val)
        for i in range(n):
            if d[i][v] != -1 and cnt != k:
                tans += d[i][v]
                heapq.heappush(val, -d[i][v])
                cnt += 1
            elif d[i][v] != -1 and cnt == k:
                z = -heapq.heappop(val)
                if d[i][v] < z:
                    tans -= z
                    tans += d[i][v]
                    heapq.heappush(val, -d[i][v])
                else:
                    heapq.heappush(val, -z)
        if cnt < k:
            continue

        ans = min(ans, tans)
    print(ans)


if __name__ == '__main__':
    main()
