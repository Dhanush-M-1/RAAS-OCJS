from collections import Counter, defaultdict, deque
import itertools
import string


if __name__ == '__main__':
    n = int(input())
    m = list(map(int, input().split()))

    a = []
    b = []
    for mi in m:
        if mi % 2 == 0:
            a.append(mi)
        else:
            b.append(mi)

    a.sort(reverse=True)
    b.sort(reverse=True)

    min_len = min(len(a), len(b))
    max_len = max(len(a), len(b))
    ans = 0
    for i in range(min_len + 1, max_len):
        if i < len(a):
            ans += a[i]
        if i < len(b):
            ans += b[i]

    print(ans)    