#! usr/bin/env python
# -*- coding: utf-8 -*-

import bisect


def main():
    n, s = map(int, input().split())
    a = list(map(int, input().split()))

    a.sort()
    if a[n//2] == s:
        print(0)
    elif a[n//2] > s:
        idx, ans = bisect.bisect_left(a, s), 0
        for i in range(idx, n//2+1):
            ans += a[i] - s
        print(ans)
    else:
        idx, ans = bisect.bisect_left(a, s), 0
        for i in range(n//2, idx):
            ans += s - a[i]
        print(ans)


if __name__ == '__main__':
    main()
