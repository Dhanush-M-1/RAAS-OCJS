# cf 615 A 800
n, m = map(int, input().split())
bulbs = [False] * m
for _ in range(n):
    _, *u = map(int, input().split())
    for i in u:
        bulbs[i - 1] = True
ans = True
for j in bulbs:
    if not j:
        ans = False
        break
print("YES" if ans else "NO")

    
