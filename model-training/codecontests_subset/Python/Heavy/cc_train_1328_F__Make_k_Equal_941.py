import sys, math
input = sys.stdin.readline
 
def getInt(): return int(input())
def getVars(): return map(int, input().split())
def getList(): return list(map(int, input().split()))
def getStr(): return input().strip()
## -------------------------------

n, k = getVars()
a = getList()
d = {}
for x in a:
    x2 = x
    num = 0
    while x2 > 0:
        if x2 not in d:
            d[x2] = []
        d[x2].append(num)
        x2 //= 2
        num += 1
minS = -1
##print(d)
for key in d:
    if len(d[key]) >= k:
        dKey = d[key].copy()
        dKey.sort()
        s = sum(dKey[:k])
        if minS == -1:
            minS = s
        else:
            minS = min(minS, s)
print(minS)
