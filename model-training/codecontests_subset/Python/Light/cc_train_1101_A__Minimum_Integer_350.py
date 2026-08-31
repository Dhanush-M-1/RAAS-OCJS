import math as ma
import sys
from sys import exit
from decimal import Decimal as dec
from itertools import permutations


def li ():
	return list (map (int, input ().split ()))


def num ():
	return map (int, input ().split ())


def nu ():
	return int (input ())




mm = 1000000007
t = nu()
for it in range (t):
	l,r,d=num()
	a=(l-1)%d
	b=(r)%d
	z=l-1-a
	v=(d-b)+r
	if(d<l):
		print(d)
	else:
		print(v)