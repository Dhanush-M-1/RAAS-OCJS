from decimal import *
a, b, c = map(int,input().split())
if a != 0:
    if b**2 - 4*a*c < 0:
        print(0)
    else:
        arr = [(-b + (b**2 - 4*a*c)**(0.5))/(2*a), (-b-(b**2 - 4*a*c)**(0.5))/(2*a)]
        if max(arr) == min(arr):
            print(1)
            print(float(Decimal(arr[0])))
        else:
            print(len(arr))
            print(float(Decimal(min(arr))))
            print(float(Decimal(max(arr))))

elif a == 0 and b != 0:
    print(1)
    print(float(Decimal(-c/b)))

elif a == b == c == 0:
    print(-1)
else:
    print(0)
