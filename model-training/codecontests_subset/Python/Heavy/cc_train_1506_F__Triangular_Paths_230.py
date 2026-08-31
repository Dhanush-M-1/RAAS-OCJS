import sys
# sys.stdin = open('input.txt','r')
input = sys.stdin.readline

def calcDist(r1, c1, r2, c2):
    if r1 - c1 == r2 - c2:
        return r2 - r1 if (r1 + c1) % 2 == 0 else 0
    r2 -= r1 - 1
    c2 -= c1 - 1
    return (r2 - c2) // 2 if (r1 + c1) % 2 == 0 else (r2 - c2 + 1) // 2

for _ in range(int(input())):
    n = int(input())
    r = list(map(int, input().split()))
    c = list(map(int, input().split()))
    p = [(x, y) for x, y in zip(r, c)]
    p.sort()
    ans = 0
    lastX, lastY = 1, 1
    for x, y in p:
        ans += calcDist(lastX, lastY, x, y)
        lastX, lastY = x, y
    print(ans)