import math

a, b, c = map(int, input().split())
if a == 0:
    if b == 0 and c == 0:
        print(-1)
    elif b == 0 and c != 0:
        print(0)
    else:
        x = -c/b
        print(1)
        print('{:.10f}'.format(x))
else:
    delta = pow(b, 2) - (4 * a * c)
    if delta < 0:
        print(0)
    elif delta == 0:
        x = -b / (2 * a)
        print(1)
        print('{:.10f}'.format(x))
    else:
        x1 = (-b - math.sqrt(delta)) / (2 * a)
        x2 = (-b + math.sqrt(delta)) / (2 * a)
        print(2)
        if x1 > x2:
            print('{:.10f}'.format(x2))
            print('{:.10f}'.format(x1))
        else:
            print('{:.10f}'.format(x1))
            print('{:.10f}'.format(x2))