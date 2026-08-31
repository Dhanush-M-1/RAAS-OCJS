import io, sys, atexit, os
import math as ma
from sys import exit
from decimal import Decimal as dec
from itertools import permutations
from itertools import combinations


def li ():
	return list (map (int, sys.stdin.readline ().split ()))


def num ():
	return map (int, sys.stdin.readline ().split ())


def nu ():
	return int (input ())


def find_gcd ( x, y ):
	while (y):
		x, y = y, x % y
	return x


def lcm ( x, y ):
	gg = find_gcd (x, y)
	return (x * y // gg)
def fox(a,b):
	xp=b//2
	ox=min(xp,a)
	oz=a-ox
	oi=b-ox*2
	return (oz,oi,ox*3)


def solve ():
	t = nu()
	for tt in range (t):
		a,b,c=num()
		kl=fox(a,b)
		oi=fox(kl[1],c)
		oz=fox(b,c)
		op=fox(a,oz[0])
		print(max(op[2]+oz[2],kl[2]+oi[2]))







if __name__ == "__main__":
	solve ()