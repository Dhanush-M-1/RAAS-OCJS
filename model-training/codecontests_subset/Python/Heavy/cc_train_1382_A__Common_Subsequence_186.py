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
    a = getList()
    b = getList()
    a.sort()
    b.sort()
    aKey = 0
    bKey = 0
    res = False
    res1 = 0
    while (aKey < n and bKey < m):
        if a[aKey] == b[bKey]:
            res = True
            res1 = a[aKey]
            break
        if a[aKey] < b[bKey]:
            aKey += 1
        else:
            bKey += 1
    if res:
        print('YES')
        print(1, res1)
    else:
        print('NO')
                
            
        
    
    
    
    
