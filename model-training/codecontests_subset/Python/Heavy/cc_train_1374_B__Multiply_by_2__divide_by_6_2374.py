
# Problem B: Multiply by 2, divide by 6

import sys

caseCount = int(next(sys.stdin))

def v(p, n):
    lo = 0
    hi = 30
    
    while hi > lo + 1:
        mid = (lo + hi) // 2
        if n % (p ** mid) == 0:
            lo = mid
        else:
            hi = mid - 1
            
    if n % (p ** hi) == 0:
        return hi
    return lo

def solve(n):
    threes = v(3, n)
    twos = v(2, n)
    
    if threes < twos:
        return -1
        
    if (3 ** threes) * (2 ** twos) != n:
        return -1
        
    return threes + (threes - twos)


ans = ""

for i in range(caseCount):
    n = int(next(sys.stdin))
    ans += str(solve(n)) + "\n"
    
print(ans)