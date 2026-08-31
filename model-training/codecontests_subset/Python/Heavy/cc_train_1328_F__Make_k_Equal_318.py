import math


def cnt(n, x):
    res = 0
    while n > x:
        n //= 2
        res += 1
    if n == x:
        return res
    return -1


def main():
    n, k = map(int, input().split())
    a = list(map(int, input().split()))
    b = set()
    b.add(0)
    for i in a:
        while i > 0:
            b.add(i)
            i //= 2
    ans = int(10e9)
    for x in b:
        s = []
        for i in a:
            c = cnt(i, x)
            if c >= 0:
                s.append(c)
        s.sort()
        if len(s) >= k:
            l = sum(s[:k])
            ans = min(ans, l)
    print(ans)

main()
