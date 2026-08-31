import sys


q = int(sys.stdin.readline().strip())
for i in range (0, q):
    x = list(map(int, sys.stdin.readline().strip().split()))
    if x[2] < x[0] or x[0] > x[1]:
        print(x[2])
    else:
        print((x[1] // x[2]) * x[2] + x[2])


