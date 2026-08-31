import os
import sys

class InputReader:
	def __init__(self):
		self.IN = open('cf.in') if os.path.exists('cf.in') else sys.stdin

		self.TOKENS = []
		self.TOKIDX = 0

	def check(self):
		if self.TOKIDX >= len(self.TOKENS):
			self.TOKENS = self.IN.readline().strip('\n').split()
			self.TOKIDX = 0

	def s(self):
		self.check()

		self.TOKIDX += 1
		return self.TOKENS[self.TOKIDX - 1]

	def i(self):
		return int(self.s())

	def f(self):
		return float(self.s())

f = InputReader()

n, x, y = f.i(), f.i(), f.i()
z = f.s()

print(z[-x:].count('1') + (1 if z[-y - 1] == '0' else -1))
