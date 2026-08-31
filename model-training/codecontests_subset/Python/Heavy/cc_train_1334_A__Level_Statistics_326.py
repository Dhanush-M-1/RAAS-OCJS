from collections import Counter as C,defaultdict as D,deque as Q
from operator import itemgetter as I
from itertools import product as P
from bisect import bisect_left as BL,bisect_right as BR
from heapq import heappush as HPUSH,heappop as HPOP
from math import floor as MF,ceil as MC, gcd as MG,factorial as F,sqrt as SQRT, inf as INFINITY,log as LOG
from sys import stdin, stdout
INPUT=stdin.readline
PRINT=stdout.write

def player1():
	print("")

def player2():
	print("")

def isPrime(n):

	for i in range(2,MC(SQRT(n))+1):
		if n%i==0:
			return False
	return True

def factors(x):

	ans=[]

	for i in range(1,MC(SQRT(x))+1):
		if x%i==0:
			ans.append(i)
			if x%(x//i)==0:
				ans.append(x//i)
	return ans


def main():

	for _ in range(int(INPUT())):
		n=int(INPUT())
		ans="YES";empty=1
		for i in range(n):
			if empty:
				pp,cc=map(int,INPUT().split( ))
				empty=0
				if cc>pp:
					ans="NO"
			else:
				x,y=map(int,INPUT().split( ))
				if x<pp or y<cc or y>x:
					ans="NO"
				elif y-cc>x-pp:
					ans="NO"
				pp=x;cc=y
		PRINT(ans+"\n")

main()