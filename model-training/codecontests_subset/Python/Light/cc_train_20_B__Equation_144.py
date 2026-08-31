from decimal import *
from math import sqrt
a, b, c = map(Decimal, input().split())
if a != 0:
    if b**2 - 4*a*c < 0:
        print(0)
    else:
        arr = [(-b + Decimal(sqrt(b**2 - 4*a*c)))/(2*a), (-b-Decimal(sqrt(b**2 - 4*a*c)))/(2*a)]
        if max(arr) == min(arr):
            print(1, arr[0])
        else:
            print(len(arr), *sorted(arr))
elif a == 0 and b != 0:
    print(1, -c/b)
elif a == b == c == 0:
    print(-1)
else:
    print(0)
