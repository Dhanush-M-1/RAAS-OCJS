from math import *

def isPrime(n):
	if n == 0 or n == 1:
		return False
	if n == 2 or n == 3:
		return True
	if n%2 == 0 or n%3 == 0:
		return False
	for i in range(5,int(sqrt(n))+1,6):
		if n%i == 0 or n%(i+2) == 0:
			return False
	return True

def primefactors(n):
	cnt2,cnt3 = 0,0
	while n%2 == 0:
		n = n // 2
		cnt2+=1
	while n%3 == 0:
		n = n // 3
		cnt3+=1
	return cnt2,cnt3,n

	

t = int(input())
for i in range(t):
	n = int(input())
	cnt2,cnt3,n = primefactors(n)
	if n == 1 and cnt2 <= cnt3:
		print(2*cnt3-cnt2)
	else:
		print(-1)
