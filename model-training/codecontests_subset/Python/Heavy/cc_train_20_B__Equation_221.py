from math import *
from decimal import *
getcontext().prec = 10
a, b, c = input().strip().split()
a, b, c = [int(a), int(b), int(c)]
d = b**2 - 4*a*c

if a == 0 and b == 0 and c == 0:
    print(-1)
elif a == 0 and b == 0:
    print(0)
elif d < 0:
    print(0)
else:
    if a != 0:
        res1 = (-b + sqrt(d))/(2*a)
        res2 = (-b - sqrt(d))/(2*a)
        if res1 == res2:
            print(1)
            print('%.10f' %(res1))
        else:
            if res1 < res2:
                print(2)
                print('%.10f' % (res1))
                print('%.10f' % (res2))
            else:
                print(2)
                print('%.10f' % (res2))
                print('%.10f' % (res1))
    else:
        res1 = -c/b
        print(1)
        print('%.10f' %(res1))