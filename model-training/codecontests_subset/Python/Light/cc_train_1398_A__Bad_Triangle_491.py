import sys
max_int = 1000000001  # 10^9+1
min_int = -max_int

t = int(input())
for _t in range(t):
    n = int(sys.stdin.readline())
    a = list(map(int, sys.stdin.readline().split()))
    if a[0] + a[1] <= a[-1]:
        print(1, 2, n)
    else:
        print(-1)

