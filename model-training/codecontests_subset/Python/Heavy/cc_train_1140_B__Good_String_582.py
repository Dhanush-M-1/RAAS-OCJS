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


def solve ():
	t = nu()
	for it in range (t):
		n=nu()
		s=input()
		if(s[0]==">"):
			print(0)
			continue
		if(s[n-1]=="<"):
			print(0)
			continue
		cc=0
		cp=0
		for i in range(n):
			if(s[i]==">"):
				break
			cc+=1
		for i in range(n-1,-1,-1):
			if(s[i]=="<"):
				break
			cp+=1
		print(min(cc,cp))
		




if __name__ == "__main__":
	solve ()