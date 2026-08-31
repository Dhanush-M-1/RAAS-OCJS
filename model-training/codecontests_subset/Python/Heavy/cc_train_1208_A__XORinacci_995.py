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


mm = 1000000007

def solve ():
	t = nu()
	for tt in range (t):
		a,b,n=num()
		n=n%3
		if(n==0):
			print(a)
		if(n==1):
			print(b)
		if(n==2):
			print(a^b)


if __name__ == "__main__":
	solve ()