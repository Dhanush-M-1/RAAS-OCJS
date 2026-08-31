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
'''
 
 
___________________THIS IS AESTROIX CODE________________________
                       KARMANYA GUPTA
 
'''
import math
def fact(x):
	if x == 0:
		return 1
	else:
		return x * fact(x-1)

def abs(x):
	return (x if x>=0 else -x)

def sumelem(x, start, end):
	#print("the sequenced passed is: ", x[start:end+1])
	sum = 0
	for i in range(start,end+1):
		sum += x[i]
	return sum

for t in range(1):
	end = list(map(int, input().split()))
	if(all(elem == end[0] for elem in end)):
		if end[0] == 0:
			print(-1)
		else:
			print(end[0])
	else:
		sum = 0
		for i in end:
			sum += i
		each = sum//5
		initial = [each-i for i in end]
		#print(initial)
		sum = 0
		for i in initial:
			sum += i
		if sum == 0:
			print(each)
		else:
			print(-1)






