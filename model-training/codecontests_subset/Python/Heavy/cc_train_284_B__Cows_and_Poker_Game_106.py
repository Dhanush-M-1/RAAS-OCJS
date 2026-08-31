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
	n=ii()
	s=I().strip()
	d=defaultdict(int)
	for i in s:
		d[i]+=1
	if len(d)>2:
		if d["I"]==1:
			print(1)
		else:
			print(0)
	else:
		if d["I"]==0:
			print(d["A"])
		elif d["I"]==1:
			print(1)
		else:
			print(0)




	
	
	






		







		
		
	
		

	







		










		


		










		






if __name__ == '__main__':
	main()