from math import sqrt
abc = input().split()
a = int(abc[0])
b = int(abc[1])
c = int(abc[2])
if a == 0:
    if b == 0:
        if c == 0:
            print("-1")
        else:
            print("0")
    else:
        print("1")
        print(-c/b)
else:
    if b**2-4*a*c < 0:
        print("0")
    elif b**2-4*a*c == 0:
        print("1")
        print(-b/2/a)
    else:
        print("2")
        p1 = min((-b+sqrt(b**2-4*a*c))/2/a,(-b-sqrt(b**2-4*a*c))/2/a)
        p2 = max((-b+sqrt(b**2-4*a*c))/2/a,(-b-sqrt(b**2-4*a*c))/2/a)
        print("{:.6f}".format(p1))
        print("{:.6f}".format(p2))