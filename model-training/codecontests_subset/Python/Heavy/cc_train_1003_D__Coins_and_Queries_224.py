import sys

from collections import defaultdict


def solve(io):
	N = io.readInt()
	Q = io.readInt()
	A = io.readIntArray(N)
	B = io.readIntArray(Q)

	freq = defaultdict(lambda: 0)
	for a in A:
		freq[a] += 1
	
	for b in B:
		cnt = 0
		p = 1 << 30
		while b > 0 and p > 0:
			want = b // p
			have = min(want, freq[p])
			b -= have * p
			cnt += have
			p = p >> 1
		if b == 0:
			io.println(cnt)
		else:
			io.println(-1)


# +---------------------+
# | TEMPLATE CODE BELOW |
# |    DO NOT MODIFY    |
# +---------------------+


# TODO: maybe reading byte-by-byte is faster than reading and parsing tokens.
class IO:
	input = None
	output = None
	raw = ""
	buf = []
	pos = 0

	def __init__(self, inputStream, outputStream):
		self.input = inputStream
		self.output = outputStream

	def readToBuffer(self):
		self.raw = self.input.readline().rstrip('\n')
		self.buf = self.raw.split()
		self.pos = 0

	def readString(self):
		while self.pos == len(self.buf):
			self.readToBuffer()
		ans = self.buf[self.pos]
		self.pos += 1
		return ans

	def readInt(self):
		return int(self.readString())

	def readFloat(self):
		return float(self.readString())

	def readStringArray(self, N, offset=0):
		arr = [None] * offset
		for _ in range(0, N):
			arr.append(self.readString())
		return arr

	def readIntArray(self, N, offset=0):
		arr = [None] * offset
		for _ in range(0, N):
			arr.append(self.readInt())
		return arr

	def readFloatArray(self, N, offset=0):
		arr = [None] * offset
		for _ in range(0, N):
			arr.append(self.readFloat())
		return arr

	def readLine(self):
		while self.pos == len(self.buf):
			self.readToBuffer()
		if self.pos > 0:
			raise ValueError("Cannot call readline in the middle of a line.")
		return self.raw

	def print(self, s):
		self.output.write(str(s))

	def println(self, s):
		self.print(s)
		self.print('\n')
	
	def printlnArray(self, arr, sep = ' '):
		self.println(sep.join(str(x) for x in arr))

	def flushOutput(self):
		self.output.flush()


pythonIO = IO(sys.stdin, sys.stdout)
solve(pythonIO)
pythonIO.flushOutput()
