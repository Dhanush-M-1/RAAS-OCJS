n = int(input())

a = []

for i in range(n):
    x, y = map(int, input().split())
    a.append((x, y))

last = (-10)**11

ans = 1

for i in range(n-1):
    x, y = a[i]
    now = x-y
    if now > last:
        last = x
        ans += 1
        continue

    now = x+y
    xx, yy = a[i+1]
    if now < xx:
        last = now
        ans += 1
        continue
    
    last = x

print(ans)
