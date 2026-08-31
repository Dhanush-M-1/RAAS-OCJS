# @author --> ajaymodi
# Naive approach
import sys
# sys.stdin=open("input.in","r")
# sys.stdout=open("output.out","w")

input=lambda : sys.stdin.readline().strip()
char = [chr(i) for i in range(97,123)]
CHAR = [chr(i) for i in range(65,91)]
mp = lambda:list(map(int,input().split()))
INT = lambda:int(input())
rn = lambda:range(INT())

from math import ceil,sqrt,factorial,gcd

for _ in rn():
	n = INT()
	l = sorted(mp())
	if l[0] + l[1] <= l[-1]:
		print(1,2,n)
	else:
		print(-1)