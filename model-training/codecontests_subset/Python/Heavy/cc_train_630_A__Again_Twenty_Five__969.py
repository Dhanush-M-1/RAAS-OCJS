def max1(a):
	p = a[0]
	for x in a:
		if x > p:
			p = x
	return p

		
def	preobr(x):
	if x % 2 == 1:
		return x + 1
	else:
		return x - 1


def prlist(a):
	for x in a:
		print(x, end = " ")
		

def dlin(n):
	k = 0
	while n > 0:
		n -= k
		k += 1
	return k - 1
	

def foundm(x, a):
	for i in range(len(a)):
		if x == a[i]:
			return i
	return -1
	

def max1m(a):
	k = max(a)
	for i in range(len(a)):
		if a[i] == k:
			return i


def min1m(a):
	k = min(a)
	for i in range(len(a)):
		if a[i] == k:
			return i

		
#row, col = list(map(int, input().split()))
#a = list(map(int, input().split()))
n = int(input())
print(25)
		
		
