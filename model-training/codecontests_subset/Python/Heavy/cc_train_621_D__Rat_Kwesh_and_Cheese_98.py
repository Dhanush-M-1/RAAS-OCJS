from decimal import *

x, y, z = input().split()
x = Decimal(x)
y = Decimal(y)
z = Decimal(z)

cal1 = lambda x, y, z : y ** z * Decimal.log10(x)
cal2 = lambda x, y, z : y * z * Decimal.log10(x)

ans, v = "x^y^z", cal1(x, y, z)
if cal1(x, z, y) > v:
    ans, v = "x^z^y", cal1(x, z, y)
if cal2(x, y, z) > v:
    ans, v = "(x^y)^z", cal2(x, y, z)
if cal2(x, z, y) > v:
    ans, v = "(x^z)^y", cal2(x, z, y)
if cal1(y, x, z) > v:
    ans, v = "y^x^z", cal1(y, x, z)
if cal1(y, z, x) > v:
    ans, v = "y^z^x", cal1(y, z, x)
if cal2(y, x, z) > v:
    ans, v = "(y^x)^z", cal2(y, x, z)
if cal2(y, z, x) > v:
    ans, v = "(y^z)^x", cal2(y, z, x)
if cal1(z, x, y) > v:
    ans, v = "z^x^y", cal1(z, x, y)
if cal1(z, y, x) > v:
    ans, v = "z^y^x", cal1(z, y, x)
if cal2(z, x, y) > v:
    ans, v = "(z^x)^y", cal2(z, x, y)
if cal2(z, y, x) > v:
    ans, v = "(z^y)^x", cal2(z, y, x)
print(ans)
