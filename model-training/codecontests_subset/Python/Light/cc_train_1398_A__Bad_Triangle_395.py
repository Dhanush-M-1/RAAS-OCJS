import sys
readline = sys.stdin.buffer.readline
readlines = sys.stdin.buffer.readlines
ns = lambda: readline().rstrip()
ni = lambda: int(readline().rstrip())
nm = lambda: map(int, readline().split())
nl = lambda: list(map(int, readline().split()))
T = ni()
for _ in range(T):
    n = ni()
    a = nl()
    if a[0] + a[1] <= a[n-1]:
        print(1,2,n)
    else:
        print(-1)