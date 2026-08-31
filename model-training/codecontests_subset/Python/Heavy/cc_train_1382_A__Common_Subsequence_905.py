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
	n,m = mp()
	a = mp()
	b = set(mp())
	k = 1
	for i in a:
		if i in b:
			print("YES")
			print(1,i)
			k = 0
			break
	if k==1:
		print("NO")
