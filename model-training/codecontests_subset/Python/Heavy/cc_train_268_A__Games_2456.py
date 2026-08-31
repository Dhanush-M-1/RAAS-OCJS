# Design_by_JOKER

import math
import cmath
from decimal import *  # su dung voi so thuc
from fractions import *  # su dung voi phan so


# getcontext().prec = x # lay x-1 chu so sau giay phay ( thuoc decimal)
# Decimal('12.3') la 12.3 nhung Decimal(12.3) la 12.30000000012
# Fraction(a) # tra ra phan so bang a (Fraction('1.23') la 123/100 Fraction(1.23) la so khac (thuoc Fraction)
# a = complex(c, d) a = c + d(i) (c = a.real, d = a.imag)
# a.capitalize() bien ki tu dau cua a(string) thanh chu hoa, a.lower() bien a thanh chu thuong, tuong tu voi a.upper()
# a.swapcase() doi nguoc hoa thuong, a.title() bien chu hoa sau dau cach, a.replace('a', 'b', slg)
# a.join['a', 'b', 'c'] = 'a'a'b'a'c, a.strip('a') bo dau va cuoi ki tu 'a'(rstrip, lstrip)
# a.split('a', slg = -1) cat theo ki tu 'a' slg lan(rsplit(), lsplit()), a.count('aa', dau = 0, cuoi= len(a)) dem slg
# a.startswith('a', dau = 0, cuoi = len(a)) co bat dau bang 'a' ko(tuong tu endswith())
# a.find("aa") vi tri dau tien xuat hien (rfind())
# input = open(".inp", mode='r')  a = input.readline()
# out = open(".out", mode='w')# a.index(val)

n = int(input())
a, b = [], []
res = 0

for _ in range(n):
    x = list(map(int, input().split()))
    a.append(x[0])
    b.append(x[1])

for x in a:
    res += b.count(x)

print(res)