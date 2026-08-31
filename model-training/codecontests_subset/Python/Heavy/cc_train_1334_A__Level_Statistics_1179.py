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
    p1 = -1
    c1 = -1
    res = 'YES'
    for i in range(n):
        p, c = getVars()
        if not(p >= c and p >= p1 and c >= c1 and p - p1 >= c-c1):
            res = 'NO'
        p1, c1 = p, c
    print(res)

        
            
