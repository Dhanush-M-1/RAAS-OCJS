import sys
from array import array  # noqa: F401
from typing import List, Tuple, TypeVar, Generic, Sequence, Union  # noqa: F401


def input():
    return sys.stdin.buffer.readline().decode('utf-8')


def main():
    from itertools import accumulate
    from collections import Counter
    n, k = map(int, input().split())
    a = sorted(map(int, input().split()))
    if Counter(a).most_common(1)[0][1] >= k:
        print(0)
        exit()
    acc = [0] + list(accumulate(a))

    ans = 10**18
    for i in range(n):
        if i >= k - 1:
            ans = min(ans, (a[i] - 1) * i - acc[i] + k - 1)
        if n - i - 1 >= k - 1:
            ans = min(ans, (acc[-1] - acc[i + 1]) - (a[i] + 1) * (n - i - 1) + k - 1)

        ans = min(
            ans,
            (a[i] - 1) * i - acc[i] + (acc[-1] - acc[i + 1]) - (a[i] + 1) * (n - i - 1) + k - 1
        )

    print(ans)


if __name__ == '__main__':
    main()
