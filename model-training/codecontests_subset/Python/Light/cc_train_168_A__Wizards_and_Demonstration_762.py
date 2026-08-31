n, x, y = map(int, input().split())

w = x

y /= 100
ans = 0

while w/n < y:
    w += 1
    ans += 1
print(ans)
