from collections import defaultdict
from sys import stdin

input = stdin.readline

if __name__ == '__main__':
    n, k = map(int, input().split())
    arr = list(map(int, input().split()))

    dct = defaultdict(lambda: [])

    for x in arr:
        i = 0
        while x > 0:
            dct[x].append(i)
            x //= 2
            i += 1

    ndct = {}

    for key, v in dct.items():
        if len(v) >= k:
            v.sort()
            ndct[key] = sum(v[:k])

    print(min(v for _, v in ndct.items()))