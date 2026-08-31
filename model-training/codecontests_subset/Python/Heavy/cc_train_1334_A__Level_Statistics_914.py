import sys


input = lambda: sys.stdin.readline().rstrip()


def zap():
    n = int(input())
    lp, lc = map(int, input().split())
    ans = "YES"
    if lc > lp:
        ans = "NO"
    if n == 1:
        return ans
    for i in range(n - 1):
        p, c = map(int, input().split())
        if c - lc > p - lp or (lc > c) or (lp > p):
            ans = "NO"
        lc = c
        lp = p
    if c - lc > p - lp or (lc > c) or (lp > p):
        ans = "NO"
    return ans


for i in range(int(input())):
    print(zap())
