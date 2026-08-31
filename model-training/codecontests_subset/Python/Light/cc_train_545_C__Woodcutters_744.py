n = int(input())
xs = []
hs = []
for _ in range(n):
    x, h = map(int, input().split())
    xs.append(x)
    hs.append(h)

r = 1 if n == 1 else 2

for i in range(1, n-1):
    x, h = xs[i], hs[i]
    if x-h > xs[i-1]:
        r += 1
        # print("left")
    elif x+h < xs[i+1]:
        r += 1
        xs[i] += h
        # print("right")

print(r)