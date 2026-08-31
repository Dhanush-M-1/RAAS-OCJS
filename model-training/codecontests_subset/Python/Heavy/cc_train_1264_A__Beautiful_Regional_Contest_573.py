import sys
import math
from collections import defaultdict,Counter,deque
import bisect
# input=sys.stdin.readline
# def print(x):
#     sys.stdout.write(str(x)+"\n")

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

# sys.stdout=open("CP1/output.txt",'w')
# sys.stdin=open("CP1/input.txt",'r')

# mod=pow(10,9)+7
t=int(input())
for i in range(t):
	n=int(input())
	a=list(map(int,input().split()))
	g=s=b=0
	ele=a[n//2]
	c=Counter(a)
	l=sorted(c.items(),reverse=True)
	flag=1
	# print(l)
	for j in range(len(l)):
		if l[j][0]<=ele:
			flag=0
			break
		g=l[j][1]
		ind=j+1
		break

	if flag:
		for j in range(ind,len(l)):
			if l[j][0]<=ele:
				flag=0
				break
			s+=l[j][1]
			if s>g:
				ind=j+1
				break
	if flag:
		for j in range(ind,len(l)):
			if l[j][0]<=ele:
				break
			b+=l[j][1]

	if g>0 and s>0 and b>0 and g<s and g<b:
		print(g,s,b)
	else:
		print(0,0,0)