a, b = map(int, input().split() )
r, l = 0, 0
while a:
    r += a
    l += a
    a = l // b
    l %= b
print(r)

