from sys import stdin
input=lambda : stdin.readline().strip()

char = [chr(i) for i in range(97,123)]
CHAR = [chr(i) for i in range(65,91)]
mp = lambda:list(map(int,input().split()))
INT = lambda:int(input())
rn = lambda:range(INT())

from math import ceil,sqrt,factorial,gcd

for _ in rn():
	n = INT()
	if n==1:
		print(0)
	elif n%3!=0:
		print(-1)
	else:
		ans = 0
		while n>1:
			if n%6==0:
				ans+=1
				n = n//6
			elif n%3==0:
				ans+=2
				n = n//3
			else:
				break

		if n==1:
			print(ans)
		else:
			print(-1)
