import sys

T = int(sys.stdin.readline().strip())
for t in range (0, T):
    n = int(sys.stdin.readline().strip())
    a = list(map(int, sys.stdin.readline().strip().split()))
    b = [[a[i], i+1] for i in range (0, n)]
    if b[0][0] + b[1][0] <= b[-1][0]:
        print(b[0][1], b[1][1], b[-1][1])
    else:
        print(-1)