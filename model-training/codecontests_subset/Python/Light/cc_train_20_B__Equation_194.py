a, b, c = [int(i) for i in input().split()]
d = b**2 - 4 * a * c
if a == 0 and b == 0 and c == 0:
    print(-1)
elif a == 0 and b == 0:
    print(0)
elif a == 0:
    print(1)
    print(-c/b)
elif d < 0:
    print(0)
elif d == 0:
    print(1)
    print(-b / (2 * a))
else:
    print(2)
    b = b / a
    d = d / (a**2)
    print((-b - d**0.5)/2)
    print((-b + d**0.5)/2)