n = int(input())

p = []
for _ in range(n):
    x,h = map(int, input().split())
    p.append((x,h))

r = 0
l = -10**12
for i in range(len(p)-1):
    left = p[i][0] - p[i][1]
    right = p[i][0] + p[i][1]
    if left > l:
        l = p[i][0]
        r += 1
    elif right < p[i+1][0]:
        l = right
        r += 1
    else:
        l = p[i][0]

print(r+1)