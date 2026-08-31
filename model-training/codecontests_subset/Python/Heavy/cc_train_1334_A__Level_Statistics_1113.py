import sys

readline = sys.stdin.readline
readlines = sys.stdin.readlines
ns = lambda: readline().rstrip()
ni = lambda: int(readline().rstrip())
nm = lambda: map(int, readline().split())
nl = lambda: list(map(int, readline().split()))
prn = lambda x: print(*x, sep='\n')

def solve():
    n = ni()
    f = 0
    a = c = 0
    for _ in range(n):
        na, nc =  nm()
        if a > na or c > nc or na - a < nc - c:
            f = 1
        a, c = na, nc
    print('NO' if f else 'YES')
    return


# solve()

T = ni()
for _ in range(T):
    solve()
