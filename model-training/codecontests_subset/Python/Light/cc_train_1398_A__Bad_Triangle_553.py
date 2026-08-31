import sys

t = int(input())

for _ in range(t):
    n = int(input())
    li = list(map(int, input().split()))[:n]
    if li[0] + li[1] > li[n - 1]:
        print(-1)
    else:
        print(1, 2, n)
