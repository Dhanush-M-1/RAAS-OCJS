
import sys
input = sys.stdin.readline
t = int(input())

while t > 0:

    t -= 1

    n = int(input())
    p = []
    c = []

    for i in range(n):
        pi, ci = map(int, input().split())
        p.append(pi)
        c.append(ci)

    if p[0] < c[0]:
        print("NO")
        continue

    check = 1
    for i in range(1, n):
        if not(p[i] >= p[i - 1] and c[i - 1] <= c[i] <= p[i] and (p[i] - p[i - 1] >= c[i] - c[i-1])):
            check = 0
            break

    if check == 1:
        print("YES")
    else:
        print("NO")


