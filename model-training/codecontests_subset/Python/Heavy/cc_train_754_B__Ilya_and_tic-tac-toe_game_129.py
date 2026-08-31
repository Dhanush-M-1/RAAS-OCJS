field = []
for i in range(4):
	field.append(list(input()))

def check_line(line):
	if len(line) < 3:
		return False

	for i in range(len(line) - 2):
		found = True
		for j in range(3):
			if line[i + j] != 'x':
				found = False
		if found:
			return True
	return False

def check_win(field):
	for i in range(4):
		if check_line(field[i]):
			return True
		if check_line([l[i] for l in field]):
			return True

	for i in range(4):
		if check_line([field[j][i + j] for j in range(4 - i)]):
			return True
		if check_line([field[j][i - j] for j in range(i + 1)]):
			return True


for i in range(4):
	for j in range(4):
		if field[i][j] == '.':
			field[i][j] = 'x'
			if check_win(field):
				print('YES')
				exit(0)
			if check_win(field[::-1]):
				print('YES')
				exit(0)
			field[i][j] = '.'

print("NO")