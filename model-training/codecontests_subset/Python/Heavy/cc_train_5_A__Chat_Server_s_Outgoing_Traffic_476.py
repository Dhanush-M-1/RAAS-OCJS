import re
from collections import Counter

class Task:
	commands = []
	answer = 0
	
	def getData(self):
		while True:
			try:
				str = input()
			except EOFError:
				break
			self.commands += [str]
	
	def solve(self):
		peopleCount = 0
		for current in self.commands:
			if current[0] == '+':
				peopleCount += 1
			elif current[0] == '-':
				peopleCount -= 1
			else:
				self.answer += peopleCount * len(current.split(":")[1])
				#print(len(current.split(":")[1]))
	
	def printAnswer(self):
		print(self.answer)

task = Task();
task.getData();
task.solve();
task.printAnswer();
