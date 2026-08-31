import sys
input = sys.stdin.readline
def getInt(): return int(input())
def getVars(): return map(int, input().split())
def getList(): return list(map(int, input().split()))
def getStr(): return input().strip()
## -------------------------------
t = getInt()
for _ in range(t):
    n = getInt()
    a = getList()
    res = 'Yes'
    begin= -1
    for i in range(n):
        if a[i] < i:
            begin = i
            break
##    print(begin)
    if begin > -1:
        for i in range(begin, n):
            a[i] = min(a[i], a[i-1]-1)
            if a[i] < 0:
                res = 'No'
                break
##    print(a)
    print(res)
