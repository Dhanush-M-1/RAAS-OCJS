a, b, c = map(int, input().split())

d = b**2 - 4*a*c
if a == b == 0 == c: 
    print(-1)
elif d < 0 or a == b == 0:
    print(0)
elif d == 0:
    print(1)
    print( "{0:5f}".format(round(-b/(2*a), 5)))
elif a == 0:
    print(1)
    x = round(-c/b, 5)
    print( "{0:5f}".format(x))
else:
    print(2)
    x =  "{0:5f}".format(round((-b + d**0.5)/(2*a), 5))
    y = "{0:5f}".format(round((-b - d**0.5)/(2*a), 5))
    x, y = sorted([x, y])
    if x != y:
        print(x, y, sep = "\n")
    else:
        print(x)
