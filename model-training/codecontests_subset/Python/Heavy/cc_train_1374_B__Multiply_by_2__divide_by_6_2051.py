import sys,math
from collections import deque,defaultdict
import operator as op
from functools import reduce
from itertools import permutations

#sys.setrecursionlimit(10**4) 

I=sys.stdin.readline

#alpha="abcdefghijklmnopqrstuvwxyz"

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

"""def ncr(n, r):
    r = min(r, n-r)
    numer = (reduce(op.mul, range(n, n-r, -1), 1))%(10**9+7)
    denom = (reduce(op.mul, range(1, r+1), 1))%(10**9+7)
    return (numer // denom)%(10**9+7)"""
def ncr(n, r):
    r = min(r, n-r)
    numer = reduce(op.mul, range(n, n-r, -1), 1)
    denom = reduce(op.mul, range(1, r+1), 1)
    return numer // denom 
 

def gcd(x, y):
    while y:
        x, y = y, x % y
    return x

def valid(row,col,rows,cols,rcross,lcross):
 	return rows[row]==0 and cols[col]==0 and rcross[col+row]==0 and lcross[col-row]==0


def div(n):
	tmp=[]
	for i in range(2,int(n**.5)+1):
		if n%i==0:			
			tmp.append(i)
			if i!=n//i:
				tmp.append(n//i)
	return tmp

	

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
	ans=""
	for _ in range(ii()):
		n=ii()
		tmp=n
		cnt2=0
		while tmp%2==0:
			cnt2+=1
			tmp//=2
		cnt3=0

		while tmp%3==0:
			cnt3+=1
			tmp//=3

		if (3**cnt3)*(2**cnt2)==n:
			if cnt3>=cnt2:
				x=cnt3-cnt2+cnt3
				ans+=str(x)+"\n"
			else:
				ans+="-1\n"
		else:
			ans+="-1\n"
	print(ans) 

















		
			
		

		



		

	

		
	



		


		







	

			













	

	








		


		


			
		
	









					
		
		





		








	

	


 
	
	








	



	
		




	










	


	

	

		



		

		
		


	
	

		
	

		




		




			












			
		
			



		


	
			
						
			








	





			
		



	
			





	

























	
	
	





if __name__ == '__main__':
	main()