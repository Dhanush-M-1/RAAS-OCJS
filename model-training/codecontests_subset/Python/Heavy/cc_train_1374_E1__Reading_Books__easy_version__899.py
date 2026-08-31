#------------------------------what is this I don't know....just makes my mess faster--------------------------------------
import os
import sys
from io import BytesIO, IOBase
 
BUFSIZE = 8192
 
class FastIO(IOBase):
	newlines = 0
 
	def __init__(self, file):
		self._fd = file.fileno()
		self.buffer = BytesIO()
		self.writable = "x" in file.mode or "r" not in file.mode
		self.write = self.buffer.write if self.writable else None
 
	def read(self):
		while True:
			b = os.read(self._fd, max(os.fstat(self._fd).st_size, BUFSIZE))
			if not b:
				break
			ptr = self.buffer.tell()
			self.buffer.seek(0, 2), self.buffer.write(b), self.buffer.seek(ptr)
		self.newlines = 0
		return self.buffer.read()
 
	def readline(self):
		while self.newlines == 0:
			b = os.read(self._fd, max(os.fstat(self._fd).st_size, BUFSIZE))
			self.newlines = b.count(b"\n") + (not b)
			ptr = self.buffer.tell()
			self.buffer.seek(0, 2), self.buffer.write(b), self.buffer.seek(ptr)
		self.newlines -= 1
		return self.buffer.readline()
 
	def flush(self):
		if self.writable:
			os.write(self._fd, self.buffer.getvalue())
			self.buffer.truncate(0), self.buffer.seek(0)
 
 
class IOWrapper(IOBase):
	def __init__(self, file):
		self.buffer = FastIO(file)
		self.flush = self.buffer.flush
		self.writable = self.buffer.writable
		self.write = lambda s: self.buffer.write(s.encode("ascii"))
		self.read = lambda: self.buffer.read().decode("ascii")
		self.readline = lambda: self.buffer.readline().decode("ascii")
 
 
sys.stdin, sys.stdout = IOWrapper(sys.stdin), IOWrapper(sys.stdout)
input = lambda: sys.stdin.readline().rstrip("\r\n")
 
#----------------------------------Real game starts here--------------------------------------

#_______________________________________________________________#
def fact(x):
	if x == 0:
		return 1
	else:
		return x * fact(x-1)
def lower_bound(li, num): #return 0 if all are greater or equal to
	answer = -1 
	start = 0
	end = len(li)-1

	while(start <= end):
		middle = (end+start)//2
		if li[middle] >= num:
			answer = middle
			end = middle - 1
		else:
			start = middle + 1
	return answer #index where x is not less than num
def upper_bound(li, num): #return n-1 if all are small or equal
	answer = -1
	start = 0
	end = len(li)-1

	while(start <= end):
		middle = (end+start)//2

		if li[middle] <= num:
			answer = middle
			start = middle + 1
		
		else:
			end = middle - 1
	return answer #index where x is not greater than num

def abs(x):
	return x if x >=0 else -x
def binary_search(li, val, lb, ub):
	ans = 0
	while(lb <= ub):
		mid = (lb+ub)//2
		#print(mid, li[mid])
		if li[mid] > val:
			ub = mid-1
		elif val > li[mid]:
			lb = mid + 1
		else:
			ans = 1
			break
	return ans

def sieve_of_eratosthenes(n):
	ans = []
	arr = [1]*(n+1)
	arr[0],arr[1], i = 0, 0, 2
	while(i*i <= n):
		if arr[i] == 1:
			j = i+i
			while(j <= n):
				arr[j] = 0
				j += i
		i += 1
	for k in range(n):
		if arr[k] == 1:
			ans.append(k)
	return ans
def nc2(x):
	if x == 1:
		return 0
	else:
		return x*(x-1)//2
def kadane(x):
	sum_so_far = 0
	current_sum = 0
	for i in x:
		current_sum += i
		if current_sum < 0:
			current_sum = 0
		else:
			sum_so_far = max(sum_so_far,current_sum)
	return sum_so_far

#_______________________________________________________________#
'''
      ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄
   ▄███████▀▀▀▀▀▀███████▄
░▐████▀▒▒Aestroix▒▒▀██████
░███▀▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▀████
░▐██▒▒▒▒▒KARMANYA▒▒▒▒▒▒████▌         ________________
░▐█▌▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████▌  ? ?   |▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒|
░░█▒▒▄▀▀▀▀▀▄▒▒▄▀▀▀▀▀▄▒▒▐███▌   ?    |___CM ONE DAY___|
░░░▐░░░▄▄░░▌▐░░░▄▄░░▌▒▐███▌     ? ? |▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒|
░▄▀▌░░░▀▀░░▌▐░░░▀▀░░▌▒▀▒█▌    ? ?    
░▌▒▀▄░░░░▄▀▒▒▀▄░░░▄▀▒▒▄▀▒▌      ? 
░▀▄▐▒▀▀▀▀▒▒▒▒▒▒▀▀▀▒▒▒▒▒▒█     ? ? 
░░░▀▌▒▄██▄▄▄▄████▄▒▒▒▒█▀       ? 
░░░░▄█████████ ████=========█▒▒▐▌
░░░▀███▀▀████▀█████▀▒▌
░░░░░▌▒▒▒▄▒▒▒▄▒▒▒▒▒▒▐
░░░░░▌▒▒▒▒▀▀▀▒▒▒▒▒▒▒▐
░░░░░████████████████
'''
from math import *
for _ in range(1):
	n, k = map(int, input().split())
	li = []
	both = []
	ff = []
	ss = []
	a,b = 0,0
	for i in range(n):
		f,s,t = map(int,input().split())
		if s == 1 and t == 1:
			both.append(f)
			a += 1
			b += 1
		elif s == 0 and t == 1:
			ss.append(f)
			b += 1
		elif s == 1 and t == 0:
			ff.append(f)
			a += 1
#	print(a,b,both,ff,ss)
	if a < k or b < k:
		print(-1)
	else:
		ss.sort()
		ff.sort()
		for i in range(min(len(ss),len(ff))):
			both.append(ss[i]+ff[i])
#		print(both)
		both.sort()	
		sumi = 0
		for i in range(k):
			sumi += both[i]
		print(sumi)


	









	





