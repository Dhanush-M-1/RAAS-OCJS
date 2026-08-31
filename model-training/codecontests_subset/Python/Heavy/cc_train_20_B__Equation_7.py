import math

a, b, c = input().split()
a = int(a)
b = int(b)
c = int(c)
if a == 0:
    if b == 0:
        if c == 0:
            print(-1)
        else:
            print(0)
    else:
        if c == 0:
            print(1, 0.0, sep="\n")
        else:
            print(1, -c / b, sep="\n")
else:
    if c == 0:
        if b == 0:
            print(1, 0.0, sep="\n")
        else:
            print(2, min(0.0, -b / a), max(0.0, -b / a), sep="\n")
    else:
        if b == 0:
            if c / a > 0:
                print(0)
            else:
                print(2, min(-math.sqrt(-c / a), math.sqrt(-c / a)), max(-math.sqrt(-c / a), math.sqrt(-c / a)),
                      sep="\n")
        else:
            if b ** 2 < 4 * a * c:
                print(0)
            elif b ** 2 == 4 * a * c:
                print(1, -b / (2 * a), sep="\n")
            else:
                print(2, min((-b - math.sqrt(b ** 2 - 4 * a * c)) / (2 * a),
                             (-b + math.sqrt(b ** 2 - 4 * a * c)) / (2 * a)),
                      max((-b - math.sqrt(b ** 2 - 4 * a * c)) / (2 * a),
                          (-b + math.sqrt(b ** 2 - 4 * a * c)) / (2 * a)), sep="\n")