from math import log

def solver1(x, y, z):
    max_num = (y ** z) * log(x)
    ans = 'x^y^z'

    num = (z ** y) * log(x)
    if max_num < num:
        max_num = num
        ans = 'x^z^y'

    num = (y * z) * log(x)
    if max_num < num:
        max_num = num
        ans = '(x^y)^z'

    num = (x ** z) * log(y)
    if max_num < num:
        max_num = num
        ans = 'y^x^z'

    num = (z ** x) * log(y)
    if max_num < num:
        max_num = num
        ans = 'y^z^x'

    num = (x * z) * log(y)
    if max_num < num:
        max_num = num
        ans = '(y^x)^z'

    num = (x ** y) * log(z)
    if max_num < num:
        max_num = num
        ans = 'z^x^y'

    num = (y ** x) * log(z)
    if max_num < num:
        max_num = num
        ans = 'z^y^x'

    num = (x * y) * log(z)
    if max_num < num:
        max_num = num
        ans = '(z^x)^y'

    return ans

def solver2(x, y, z):
    max_num = z * log(y) + log(log(x))
    ans = 'x^y^z'

    num = y * log(z) + log(log(x))
    if max_num < num:
        max_num = num
        ans = 'x^z^y'

    num = log(y) + log(z) + log(log(x))
    if max_num < num:
        max_num = num
        ans = '(x^y)^z'

    num = z * log(x) + log(log(y))
    if max_num < num:
        max_num = num
        ans = 'y^x^z'

    num = x * log(z) + log(log(y))
    if max_num < num:
        max_num = num
        ans = 'y^z^x'

    num = log(x) + log(z) + log(log(y))
    if max_num < num:
        max_num = num
        ans = '(y^x)^z'

    num = y * log(x) + log(log(z))
    if max_num < num:
        max_num = num
        ans = 'z^x^y'

    num = x * log(y) + log(log(z))
    if max_num < num:
        max_num = num
        ans = 'z^y^x'

    num = log(x) + log(y) + log(log(z))
    if max_num < num:
        max_num = num
        ans = '(z^x)^y'

    return ans

def solverX(x, y, z):
    max_num = z * log(x) + log(log(y))
    ans = 'y^x^z'

    num = x * log(z) + log(log(y))
    if max_num < num:
        max_num = num
        ans = 'y^z^x'

    num = log(x) + log(z) + log(log(y))
    if max_num < num:
        max_num = num
        ans = '(y^x)^z'

    num = y * log(x) + log(log(z))
    if max_num < num:
        max_num = num
        ans = 'z^x^y'

    num = x * log(y) + log(log(z))
    if max_num < num:
        max_num = num
        ans = 'z^y^x'

    num = log(x) + log(y) + log(log(z))
    if max_num < num:
        max_num = num
        ans = '(z^x)^y'

    return ans

def solverY(x, y, z):
    max_num = z * log(y) + log(log(x))
    ans = 'x^y^z'

    num = y * log(z) + log(log(x))
    if max_num < num:
        max_num = num
        ans = 'x^z^y'

    num = log(y) + log(z) + log(log(x))
    if max_num < num:
        max_num = num
        ans = '(x^y)^z'

    num = y * log(x) + log(log(z))
    if max_num < num:
        max_num = num
        ans = 'z^x^y'

    num = x * log(y) + log(log(z))
    if max_num < num:
        max_num = num
        ans = 'z^y^x'

    num = log(x) + log(y) + log(log(z))
    if max_num < num:
        max_num = num
        ans = '(z^x)^y'

    return ans

def solverZ(x, y, z):
    max_num = z * log(y) + log(log(x))
    ans = 'x^y^z'

    num = y * log(z) + log(log(x))
    if max_num < num:
        max_num = num
        ans = 'x^z^y'

    num = log(y) + log(z) + log(log(x))
    if max_num < num:
        max_num = num
        ans = '(x^y)^z'

    num = z * log(x) + log(log(y))
    if max_num < num:
        max_num = num
        ans = 'y^x^z'

    num = x * log(z) + log(log(y))
    if max_num < num:
        max_num = num
        ans = 'y^z^x'

    num = log(x) + log(z) + log(log(y))
    if max_num < num:
        max_num = num
        ans = '(y^x)^z'

    return ans

x, y, z = map(float, input().split())
if x <= 1 and y <= 1 and z <= 1:
    ans = solver1(x, y, z)
elif x > 1 and y > 1 and z > 1:
    ans = solver2(x, y, z)
elif x > 1 and y <= 1 and z <= 1:
    ans = solver1(x, y, z)
elif x <= 1 and y > 1 and z <= 1:
    ans = solver1(x, y, z)
elif x <= 1 and y <= 1 and z > 1:
    ans = solver1(x, y, z)
elif x > 1 and y > 1 and z <= 1:
    ans = solverZ(x, y, z)
elif x > 1 and y <= 1 and z > 1:
    ans = solverY(x, y, z)
elif x <= 1 and y > 1 and z > 1:
    ans = solverX(x, y, z)

print (ans)