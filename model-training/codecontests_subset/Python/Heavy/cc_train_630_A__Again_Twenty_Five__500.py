from math import ceil, log, floor, sqrt
import math	
	
	
k = 1	
def mod_expo(n, p, m):
	"""find (n^p)%m"""
	result = 1
	while p != 0:
		if p%2 == 1:
			result = (result * n)%m
		p //= 2
		n = (n * n)%m
	return result
	
def is_prime(n):
	m = 2
	while m*m <= n:
		if n%m == 0:
			return False
		m += 1
	return True
	
def find_sum(n, a):
	a.insert(0, 0)
	for i in range(1, n+1):
		prev = a[i] & a[i-1]
		cur = a[i] | a[i-1]
		a[i-1] = prev
		a[i] = cur
	return sum(m*m for m in a)

def prin_abc(x, y, z):
	l = [x, y, z]
	l.sort()
	if l[1] < l[2]:
		print("NO")
		return 
	a = b = l[0]
	c = l[2]
	print("YES")
	print(a, b, c)
	
def get_rank(n, stones):
	x = 0
	turn = 0
	winner = False
	for i in range(n-2, -1, -1):
		if winner:
			winner = not winner
		elif stones[i] == 1 and not winner:
			winner = True
		#print(winner)
		
	if (not winner) or (stones[0] > 1):
		print("First")
	else:
		print("Second")
		
def count_lamps(n, m):
	return (n*m + 1)//2
		
t = 1
#t = int(input())
while t:
	t = t - 1
	points = []
	n = int(input()) 
	#n, m = map(int, input().split()) 
	#print(discover())
	# = map(int, input().split())
	#a = list(map(int, input().strip().split()))[:n]
	#w = list(map(int, input().strip().split()))[:k]
	#for i in range(3):
	#	x, y = map(int, input().split()) 
	#	points.append((x, y))
	#s = input()
	#if happy_guests(a, b, n, m):
#		print("Yes")
#	else:
#		print("No")
	
	#prin_abc(x, y, z)
	print(mod_expo(5, n, 100))
	#get_rank(n, a)
