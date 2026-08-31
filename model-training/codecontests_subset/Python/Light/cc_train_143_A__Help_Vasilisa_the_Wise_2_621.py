r1, r2 = map(int, input().split())
c1, c2 = map(int, input().split())
d1, d2 = map(int, input().split())

w = (d1 - r1 + c2) // 2
z = r2 - w
x = d1 - w
y = c2 - w

for i in [w, z, x, y]:
    if i < 1 or i > 9:
        print(-1)
        exit()

if w == z or x == y or x == w or y == z or y == w or x == z :
    print(-1)
    exit()
elif x != r1 - y  or z != c1 - x or y != d2 - z:
    print(-1)
    exit()
print(x, y)
print(z, w)
