import sys
input = sys.stdin.readline
def getInt(): return int(input())
def getVars(): return map(int, input().split())
def getList(): return list(map(int, input().split()))
def getStr(): return input().strip()
## -------------------------------

t = getInt()
for _ in range(t):
    n, m = getVars()
    s = getStr()
    p = getList()
    p.sort()
    res = {}
    res1 = {}
    for i in range(ord('a'), ord('z')+1):
        res[chr(i)] = 0
        res1[chr(i)] = 0
    for i in range(p[0]):
        res[s[i]] += 1
        res1[s[i]] += 1
    for i in range(1, m):
        for j in res:
            res[j] += res1[j]
        for j in range(p[i-1], p[i]):
            res[s[j]] += 1
            res1[s[j]] += 1
    for i in range(p[-1], n):
        res1[s[i]] += 1
    for i in res:
        res[i] += res1[i]
    print(*list(res.values()))

