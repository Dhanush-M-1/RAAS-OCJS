import io, sys, atexit, os

import math as ma
from sys import exit
from decimal import Decimal as dec
from itertools import permutations


def li ():
	return list (map (int, input ().split ()))


def num ():
	return map (int, input ().split ())


def nu ():
	return int (input ())


def find_gcd ( x, y ):
	while (y):
		x, y = y, x % y
	return x


mm = 1000000007
yp = 0
def solve ():
	t = 1
	for tt in range (t):
		n = nu ()
		s=input()
		xp=[0]*26
		for i in range(26):
			xp[i]=[]
		fl=False
		for i in range(n-1,-1,-1):
			hh=ord(s[i])-97
			for j in range(hh):
				if(len(xp[j])!=0):
					fl=True
					print("YES")
					print(i+1,xp[j][0]+1)
					return
			xp[hh].append(i)
		if(fl==False):
			print("NO")


if __name__ == "__main__":
	solve ()