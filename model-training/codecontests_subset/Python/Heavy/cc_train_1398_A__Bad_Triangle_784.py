import sys,math
from collections import deque,defaultdict
import operator as op
from functools import reduce
sys.setrecursionlimit(10**6) 

I=sys.stdin.readline

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

def gcd(x, y):
    while y:
        x, y = y, x % y
    return x





	

def main():
	for _ in range(ii()):
		n=ii()
		arr=li()
		if arr[0]+arr[1]<=arr[-1]:
			print(1,2,n)
		else:
			print(-1)












	
	
	






		







		
		
	
		

	







		









if __name__ == '__main__':
	main()