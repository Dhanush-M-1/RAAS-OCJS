import math
def solver(a, b, c):
    d = b**2-4*a*c
    if a == 0 and b!=0:
        print('1')
        print('%.5f'%(-c/b))
    elif a == 0 and b == 0 and c == 0:
        print(-1)
    elif a == 0 and b == 0 and c!=0:
        print('0')
    elif d < 0:
        print(0)
    elif d == 0 and (a!= 0):
        x1 = (-b + math.sqrt(d))/(2*a)
        x2 = (-b - math.sqrt(d))/(2*a)
        print('1')
        print('%.5f'%x1)
    else:
        print('2')
        x1 = (-b + math.sqrt(d))/(2*a)
        x2 = (-b - math.sqrt(d))/(2*a)
        x1, x2 = min(x1, x2), max(x1, x2)
        print('%.5f'%x1)
        print('%.5f'%x2) 

a, b, c = map(int, input().split())
solver(a, b, c)
