import math

a, b, c = map(float, input().split())

d = b * b - 4. * a * c

if d < 0:
    print(0)
    exit()

if a == 0 and b == 0 and c == 0:
    print(-1)
    exit()

if a == 0 and b == 0:
    print(0)
    exit()

if a == 0:
    print(1)
    print("{0:.6f}".format(-c / b))
    exit()


x1 = (-b + math.sqrt(d)) / (2. * a)
x2 = (-b - math.sqrt(d)) / (2. * a)

if x1 == x2:
    print(1)
    print("{0:.6f}".format(x1))
    exit()

print(2)
if x1 < x2:
    print("{0:.6f}".format(x1))
    print("{0:.6f}".format(x2))
else:
    print("{0:.6f}".format(x2))
    print("{0:.6f}".format(x1))
