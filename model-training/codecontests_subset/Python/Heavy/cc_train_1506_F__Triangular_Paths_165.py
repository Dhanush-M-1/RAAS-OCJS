import heapq
import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    r = list(map(int, input().split()))
    c = list(map(int, input().split()))
    h = []
    for i in range(n):
        heapq.heappush(h, (r[i], c[i]))
    nowx, nowy = 1, 1
    ans = 0
    while h:
        x, y = heapq.heappop(h)
        if nowx - nowy == x - y:
            if not (x - y) % 2:
                ans += x - nowx
        elif nowx - nowy < x - y:
            ans += (x - y) // 2 - (nowx - nowy) // 2
        nowx, nowy = x, y
    print(ans)