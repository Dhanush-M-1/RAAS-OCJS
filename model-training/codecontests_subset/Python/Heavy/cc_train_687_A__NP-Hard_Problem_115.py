# Author : nitish420 --------------------------------------------------------------------
import os
import sys
from io import BytesIO, IOBase


def main():
	n,m=map(int,input().split())	
	d=dict()
	arra=set()
	arrb=set()
	for _ in range(m):
		a,b=map(int,input().split())
		if a not in d:
			d[a]=[]
		if b not in d:
			d[b]=[]
		d[a].append(b)
		d[b].append(a)
	
	vis=[0]*(n+1)

	for i in range(1,n+1):
		if vis[i]:
			continue

		if i not in d:
			continue

		stack=[(i,0)]

		while stack:
			x,y=stack.pop()
			if vis[x]:
				continue
			vis[x]=1
			if y:
				arra.add(x)
			else:
				arrb.add(x)
			
			for item in d[x]:
				if vis[item]==0:
					stack.append((item,1-y))
				else:
					if item in arra:
						if y==1:
							print(-1)
							exit()
					else:
						if y==0:
							print(-1)
							exit()
	
	print(len(arra))
	print(*arra)
	print(len(arrb))
	print(*arrb)




# region fastio

BUFSIZE = 8192


class FastIO(IOBase):
	newlines = 0

	def __init__(self, file):
		self._fd = file.fileno()
		self.buffer = BytesIO()
		self.writable = 'x' in file.mode or 'r' not in file.mode
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
			self.newlines = b.count(b'\n') + (not b)
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
		self.write = lambda s: self.buffer.write(s.encode('ascii'))
		self.read = lambda: self.buffer.read().decode('ascii')
		self.readline = lambda: self.buffer.readline().decode('ascii')


sys.stdin, sys.stdout = IOWrapper(sys.stdin), IOWrapper(sys.stdout)
input = lambda: sys.stdin.readline().rstrip('\r\n')


# endregion

if __name__ == '__main__':
	main()