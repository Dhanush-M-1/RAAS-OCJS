import math
a, b, c = map(int, input().split())

delta = (b*b) - (4*a*c)
# print(delta)
if delta < 0:
    print("0")
# elif a+b+c == 0:
#     print("-1")
else:
    if a != 0:
        x1 = (-b + math.sqrt(delta))/(a*2)
        x2 = (-b - math.sqrt(delta))/(a*2)
        if delta == 0:
            print("1")
            print("%.5f" % x1)
        else:
            print("2")
            if x1 > x2:
                x1, x2 = x2, x1
            print("%.5f" % x1)
            print("%.5f" % x2)

    elif b != 0:
        x = -c/b
        print("1")
        print("%.5f" % x)
    elif c!=0:
        print("0")
    else:
        print("-1")
