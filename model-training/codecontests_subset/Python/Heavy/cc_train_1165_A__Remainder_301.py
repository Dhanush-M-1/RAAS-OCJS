from collections import deque
import os
import sys

class InputReader:
	def __init__(self):
		self.IN = open('cf.in') if os.path.exists('cf.in') else sys.stdin
		self.TOKENS = deque()

	def check(self):
		if len(self.TOKENS) == 0:
			self.TOKENS = deque(self.IN.readline().strip('\n').split())

	def s(self):
		self.check()

		return self.TOKENS.popleft()

	def i(self):
		return int(self.s())

	def f(self):
		return float(self.s())

f = InputReader()

n, x, y = f.i(), f.i(), f.i()
z = f.s()

print(z[-x:].count('1') + (1 if z[-y - 1] == '0' else -1))

