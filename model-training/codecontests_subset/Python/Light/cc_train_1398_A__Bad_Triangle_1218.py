from sys import stdin
input = stdin.buffer.readline
inf = 1000000001
for _ in range(int(input())):
    n = int(input())
    *a, = map(int, input().split())
    a = sorted([(a[i], i + 1) for i in range(n)])
    if a[-1][0] >= a[0][0] + a[1][0]:
        print(*sorted([a[0][1], a[1][1], a[-1][1]]))
    else:
        print(-1)
