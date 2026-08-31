import sys,math,collections
from collections import defaultdict

#from itertools import permutations,combinations
	
def file():
	sys.stdin = open('input.py', 'r')
	sys.stdout = open('output.py', 'w') 
def get_array():
	l=list(map(int, input().split()))
	return l
def get_2_ints():	
	a,b=map(int, input().split())
	return a,b
def get_3_ints():	
	a,b,c=map(int, input().split())
	return a,b,c	
def sod(n):
	n,c=str(n),0
	for i in n:	
		c+=int(i)
	return c	

def getFloor(A, x):

	(left, right) = (0, len(A) - 1)

	floor = -1
	while left <= right:
		mid = (left + right) // 2
		if A[mid] == x:
			return A[mid]
		elif x < A[mid]:
			right = mid - 1
		else:
			floor = A[mid]
			left = mid + 1
			
	return floor
#file()	
def main():
	for tt in range(int(input())):
		a,b=get_2_ints()
		l1=get_array()
		flag=0
		d=defaultdict(int)
		for i in range(a):
			d[l1[i]]=1
		l2=get_array()	
		for i in range(b):	
			if(d[l2[i]]):
				print('YES')
				print(1,l2[i])
				flag=1
				break
		if(not(flag)):
			print('NO')
























				

			







            
			
































		








if __name__ == '__main__':
    main()