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
    p = nl()
    m = [-1, -1, -1]
    for i in range(n-1):
        if m[0] < 0 and p[i] > p[i+1]:
            m[0] = i
        elif m[0] >= 0 and m[1] < 0 and p[i] > p[i+1] and i - m[0] > m[0] + 1:
            m[1] = i
        elif m[1] >= 0 and m[2] < 0 and p[i] > p[i+1] and i - m[1] > m[0] + 1:
            m[2] = i
        elif m[2] >= 0 and p[i] > p[i+1] and i < n//2:
            m[2] = i
    if m[2] < 0 or m[2] >= n//2:
        print(0, 0, 0)
    else:
        print(m[0] + 1, m[1] - m[0], m[2] - m[1])
    return

# solve()

T = ni()
for _ in range(T):
    solve()
