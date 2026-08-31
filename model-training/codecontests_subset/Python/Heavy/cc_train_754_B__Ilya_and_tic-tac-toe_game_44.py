map = [input() for k in range(4)]

def checkVictory(map):
	# HORIZONTAL WIN
	for x in range(4):
		for y in range(2):
			if map[x][y:y+3] == "xxx":
				return True
	# VERTICAL WIN
	for x in range(2):
		for y in range(4):
			if map[x][y] == "x" and map[x+1][y] == "x" and map[x+2][y] == "x":
				return True
	# LINUX WIN
	for x in range(2, 4):
		for y in range(2):
			if map[x][y] == "x" and map[x-1][y+1] == "x" and map[x-2][y+2] == "x":
				return True
	# WINDOWS WIN
	for x in range(2):
		for y in range(2):
			if map[x][y] == "x" and map[x+1][y+1] == "x" and map[x+2][y+2] == "x":
				return True
	#GJ ILYA NOOB
	return False

import sys

for x in range(4):
	for y in range(4):
		if map[x][y] == ".":
			change = map.copy()
			change[x] = change[x][:y] + "x" + change[x][y+1:]
			if checkVictory(change) == True:
				print("YES")
				sys.exit()
print("NO")
