import sys
input = sys.stdin.readline
t = int(input())
for _ in range(t):
    n = int(input())
    a = [int(_) for _ in input().split()]
    if a[0] + a[1] <= a[n-1]:
        print(1, 2, n)
    else:
        print(-1)
