import math
a,b,c = map(int,input().split())

if a == 0:
    if b == 0:
        if c == 0:
            print("-1")
        else:
            print("0")
    else:
        print("1")
        print("%.7f" %(-c/b))
else:
    r = b*b - 4*a*c
    if r < 0:
        print("0")
    elif r == 0:
        print("1")
        print("%.7f" %(-b/(2*a)))
    else:
        print("2")
        if a > 0:
            print("%.7f" %((-b - math.sqrt(r))/(2*a)))
            print("%.7f" %((-b + math.sqrt(r))/(2*a)))
        elif a < 0:
            print("%.7f" %((-b + math.sqrt(r))/(2*a)))
            print("%.7f" %((-b - math.sqrt(r))/(2*a)))