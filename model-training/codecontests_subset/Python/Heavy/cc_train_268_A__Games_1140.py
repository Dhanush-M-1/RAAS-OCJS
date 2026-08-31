def getInts():
    return [int(s) for s in input().split()]

def getInt():
    return int(input())

def getStrs():
    return [s for s in input().split()]

def getStr():
    return input()

def listStr():
    return list(input())

import collections as c

def solve():
    N = getInt()
    home = c.defaultdict(int)
    away = c.defaultdict(int)
    for n in range(N):
        A, B = getInts()
        home[A] += 1
        away[B] += 1
    ans = 0
    for h in home:
        ans += home[h]*away[h]
    return ans
    
    
ans = solve()
print(ans)