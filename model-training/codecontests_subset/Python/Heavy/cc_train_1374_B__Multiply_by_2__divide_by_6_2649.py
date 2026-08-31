import sys
import math
def II():
	return int(sys.stdin.readline())

def LI():
	return list(map(int, sys.stdin.readline().split()))

def MI():
	return map(int, sys.stdin.readline().split())

def SI():
	return sys.stdin.readline().strip()
t = II()
for q in range(t):
	n = II()
	if n == 1:
		print(0)
	else:
		boo = True
		x = 0
		y = 0
		while(n!=1):
			if n%6 == 0:
				x+=1
				n//=6
			elif n%3 == 0:
				y+=1
				n//=3
			else:
				boo = False
				break
		if boo == False:
			print(-1)
		else:
			print(x+y*2)
