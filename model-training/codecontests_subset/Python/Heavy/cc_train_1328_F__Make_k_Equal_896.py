

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
# NUMBER = 10**9 + 7
NUMBER = 998244353
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
	return  mult(factorial(n), modinv(mult(factorial(k),factorial(n-k))))
from collections import deque, defaultdict 
import heapq




def solution(a,n,k):
	d = defaultdict(int)
	for x in a:
		d[x]+=1
	so = [(x,d[x]) for x in d]
	so.sort()
	for x,y in so:
		if y >= k:
			return 0
	# forward
	m= len(so)
	total = so[0][1]
	fo = [0]
	for i in range(1,m):
		fo.append(fo[-1] + total * (so[i][0] - so[i-1][0]))
		total += so[i][1]
	# backward
	total = so[-1][1]
	ba = [0 for i in range(m)]
	ba[m-1] = 0
	for i in range(m-2,-1,-1):
		ba[i] = ba[i+1] + total*(so[i+1][0] - so[i][0])
		total+=so[i][1]
	total_fo = [0]
	for x in so:
		total_fo.append(total_fo[-1] + x[1])
	total_ba = [0 for i in range(m+1)]
	for i in range(m-2,-1,-1):
		total_ba[i] = total_ba[i+1] + so[i+1][1]
	# print(total_ba[2],so[2])
	mn = 10**15
	for i in range(m):
		if total_ba[i] + so[i][1] >= k:
			mn = min(mn,max(ba[i] - (total_ba[i] + so[i][1] - k),0))
		if total_fo[i] + so[i][1] >= k:
			mn = min(mn,max(fo[i] - (total_fo[i] + so[i][1] - k),0))	
		mn = min(mn,max(fo[i] + ba[i] - (total_fo[i] + total_ba[i] + so[i][1] - k),0))	
	# print(f'so={so}')
	# print(f'fo={fo}')
	# print(f'total_fo={total_fo}')
	# print(f'ba={ba}')
	# print(f'total_ba={total_ba}')
	return mn	









	
def main():
	T = 1
	for i in range(T):
		# n = ri()
		n,k = ria()
		a=ria()

		x = solution(a,n,k)
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

