import sys,math
from collections import deque,defaultdict
import operator as op
from functools import reduce
from itertools import permutations
import heapq

# sys.setrecursionlimit(10**6) 
# OneDrive\Documents\codeforces

I=sys.stdin.readline

alpha="abcdefghijklmnopqrstuvwxyz"

mod=10**9 + 7

"""
x_move=[-1,0,1,0,-1,1,1,-1]
y_move=[0,1,0,-1,1,1,-1,-1]
"""
def ii():
	return int(I().strip())
def li():
	return list(map(int,I().strip().split()))
def mi():
	return map(int,I().strip().split())


def ncr(n, r):
    r = min(r, n-r)
    numer = reduce(op.mul, range(n, n-r, -1), 1)
    denom = reduce(op.mul, range(1, r+1), 1)
    return numer // denom 



def isPrime(n):
	if n<=1:
		return False
	elif n<=2:
		return True
	else:
		
		for i in range(2,int(n**.5)+1):
			if n%i==0:
				return False
		return True



def main():
	# ans=""
	for _ in range(ii()):
		I()
		k,n,m=mi()
		arr=li()
		brr=li()

		f=1
		i=0
		j=0 
		ans=[]
		while i<n and j<m:
			if arr[i]<=k:
				ans.append(arr[i])
				if arr[i]==0:
					k+=1
				i+=1				
			elif brr[j]<=k:
				ans.append(brr[j])
				if brr[j]==0:
					k+=1
				j+=1
			else:
				f=0
				break
				
		while i<n:
			ans.append(arr[i])
			if arr[i]>k:
				f=0
				break
			elif arr[i]==0:
				k+=1
			i+=1
		while j<m:
			ans.append(brr[j])
			if brr[j]>k:
				f=0
				break
			elif brr[j]==0:
				k+=1
			j+=1

		if f==0:
			print(-1)
		else:
			print(*ans)



	








	












	





			

	

		

	













		

		


		





					

if __name__ == '__main__':
	main()