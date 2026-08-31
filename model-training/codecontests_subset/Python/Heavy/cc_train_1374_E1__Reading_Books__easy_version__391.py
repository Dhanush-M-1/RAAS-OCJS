 
# from math import factorial as fac
from collections import defaultdict
# from copy import deepcopy
import sys, math
f = None
try:
	f = open('q1.input', 'r')
except IOError:
	f = sys.stdin
if 'xrange' in dir(__builtins__):
	range = xrange
# print(f.readline())
sys.setrecursionlimit(10**2)

	
def print_case_iterable(case_num, iterable):
	print("Case #{}: {}".format(case_num," ".join(map(str,iterable))))

def print_case_number(case_num, iterable):
	print("Case #{}: {}".format(case_num,iterable))

def print_iterable(A):
	print (' '.join(A))

def read_int():
	return int(f.readline().strip())
def read_int_array():
	return [int(x) for x in f.readline().strip().split(" ")]
def rns():
	a =  [x for x in f.readline().split(" ")]
	return int(a[0]), a[1].strip()
def read_string():
	return list(f.readline().strip())
def ri():
	return int(f.readline().strip())
def ria():
	return [int(x) for x in f.readline().strip().split(" ")]
def rns():
	a =  [x for x in f.readline().split(" ")]
	return int(a[0]), a[1].strip()
def rs():
	return list(f.readline().strip())
def bi(x):
	return bin(x)[2:]





from collections import deque
import math
NUMBER = 10**9 + 7
# NUMBER = 998244353
def factorial(n) : 
	M = NUMBER
	f = 1
  
	for i in range(1, n + 1):  
		f = (f * i) % M # Now f never can  
						# exceed 10^9+7  
	return f
def mult(a,b):
	return (a * b) % NUMBER

def minus(a , b):
	return (a - b) % NUMBER

def plus(a , b):
	return (a + b) % NUMBER

def egcd(a, b):
	if a == 0:
		return (b, 0, 1)
	else:
		g, y, x = egcd(b % a, a)
		return (g, x - (b // a) * y, y)

def modinv(a):
	m = NUMBER
	g, x, y = egcd(a, m)
	if g != 1:
		raise Exception('modular inverse does not exist')
	else:
		return x % m
def choose(n,k):
	if n < k:
		assert false
	return  mult(factorial(n), modinv(mult(factorial(k),factorial(n-k)))) % NUMBER
from collections import deque, defaultdict 
import heapq


from types import GeneratorType
def bootstrap(f, stack=[]):
	def wrappedfunc(*args, **kwargs):
		if stack:
			return f(*args, **kwargs)
		else:
			to = f(*args, **kwargs)
			while True:
				if type(to) is GeneratorType:
					stack.append(to)
					to = next(to)
				else:
					stack.pop()
					if not stack:
						break
					to = stack[-1].send(to)
			return to

	return wrappedfunc


def dfs(g, timeIn, timeOut,depths,parents): 
	# assign In-time to node u 
	cnt = 0
	# node, neig_i, parent, depth
	stack = [[1,0,0,0]]
	while stack:
		v,neig_i,parent,depth = stack[-1]
		parents[v] = parent
		depths[v] = depth
		# print (v)
		if neig_i == 0:
			timeIn[v] = cnt    
			cnt+=1
		while neig_i < len(g[v]):
			u = g[v][neig_i]
			if u == parent:
				neig_i+=1
				continue
			stack[-1][1] = neig_i + 1
			stack.append([u,0,v,depth+1])
			break
		if neig_i == len(g[v]):
			stack.pop()
			timeOut[v] = cnt
			cnt += 1
  
# def isAncestor(u: int, v: int, timeIn: list, timeOut: list) -> str: 
# 	return timeIn[u] <= timeIn[v] and timeOut[v] <= timeOut[u] 

cnt = 0
@bootstrap
def dfs(v,adj,timeIn, timeOut,depths,parents,parent=0,depth=0):
	global cnt
	parents[v] = parent
	depths[v] = depth
	timeIn[v] = cnt
	cnt+=1
	for u in adj[v]:
		if u == parent:
			continue
		yield dfs(u,adj,timeIn,timeOut,depths,parents,v,depth+1)
	timeOut[v] = cnt
	cnt+=1
	yield 

def gcd(a,b): 
    if a == 0: 
        return b 
    return gcd(b % a, a) 
  
# Function to return LCM of two numbers 
def lcm(a,b): 
    return (a*b) / gcd(a,b) 
def get_num_2_5(n):
	twos = 0
	fives = 0
	while n>0 and n%2 == 0:
		n//=2
		twos+=1
	while n>0 and n%5 == 0:
		n//=5
		fives+=1
	return (twos,fives)

def solution(data,c,a,b,n,k):
	if b.count(1) < k or a.count(1) < k:
		return -1
	al = []
	bo = []
	both = []
	for i in range(n):
		if a[i] == 1 and b[i] == 1:
			both.append(c[i])
		elif a[i] == 1:
			al.append(c[i])
		elif b[i] == 1:
			bo.append(c[i])
	bo.sort(reverse=True)
	al.sort(reverse=True)
	both.sort(reverse=True)

	curr = 0
	res = 0
	inf = 10**10
	while curr < k:
		both_x = both[-1] if both else inf
		al_x = al[-1] if al else inf
		bo_x = bo[-1] if bo else inf
		if both_x > al_x + bo_x:
			res+=al.pop() + bo.pop()
		else:
			res+=both.pop()
		curr+=1
	return res

	
def main():
	T = 1
	# T = ri()
	for i in range(T):
		# n = ri()
		# s = rs()
		data = []
		n,k	= ria()
		# a = ria()
		c,a,b = [],[],[]
		for j in range(n):
			c_,a_,b_=ria()
			c.append(c_)
			a.append(a_)
			b.append(b_)
			# data.append(c_,a_,b_)

		x = solution(data,c,a,b,n,k)

		if 'xrange' not in dir(__builtins__):
			print(x)
		else:
			print >>output,str(x)# "Case #"+str(i+1)+':',
	if 'xrange' in dir(__builtins__):
		print(output.getvalue())
		output.close()

if 'xrange' in dir(__builtins__):
	import cStringIO
	output = cStringIO.StringIO()
#example usage:
#    for l in res:
#       print >>output, str(len(l)) + ' ' +  ' '.join(l)

if __name__ == '__main__':
	main()
