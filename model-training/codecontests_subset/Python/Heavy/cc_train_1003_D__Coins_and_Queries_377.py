import io
import os
from collections import defaultdict
from sys import stdin
input = stdin.readline


def main():
    n, q = map(int, input().split())
    a = list(map(int, input().split()))
    d = defaultdict(int)
    for val in a:
        d[val] += 1
    coins = [(val, cnt) for val, cnt in d.items()]
    coins.sort(reverse=True)

    for _ in range(q):
        left = int(input())
        ans = 0
        for val, cnt in coins:
            take = min(cnt, left // val)
            ans += take
            left -= take * val
        print(str(ans) if left == 0 else str(-1))


if __name__ == '__main__':
    main()
