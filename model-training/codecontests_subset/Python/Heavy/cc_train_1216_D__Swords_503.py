n = int(input())
a = [ int(i) for i in input().split() ]
b = sum(a)
mx = max(a)
from math import sqrt
# ( z y ) >= n * mx  - b

y = 10**18
x = 10**18

def check(y,x):
    for i in a:
        if (mx - i) % x != 0:
            return False
    return True

fc = n * mx - b
for yy in range(1,int(sqrt(fc))+1):
    if (fc % yy) == 0:
        if( check(yy, fc//yy) ):
            if yy < y:
                y = yy
                x = fc//yy
        if( check(fc//yy, yy)):
            if fc//yy < y:
                y = fc//yy
                x = yy
print(y,x)
