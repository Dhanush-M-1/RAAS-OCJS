Field = []
for i in range(4):
	Field.append([x for x in input()])

def main(Field):
	for i in range(len(Field)):
		for j in range(len(Field[i])):
			if Field[i][j] == '.':
				Field[i][j] = 'x'
				if winner(Field):
					return 'YES'
				else:
					Field[i][j] = '.'
	return 'NO'

def winner(field):
	# Horizontal row
	for row in field:
		if row[1] == 'x' and row[2] == 'x':
			if row[0] == 'x' or row[3] == 'x':
				return True
	# Verical row
	for i in range(len(field)):
		if field[1][i] == field[2][i] == 'x':
			if field[0][i] == 'x' or field[3][i] == 'x':
				return True
	# Right diag
	if field[0][1] == field[1][2] == field[2][3] == 'x':
		return True
	elif field[1][1] == field[2][2] == 'x':
		if field[0][0] == 'x' or field[3][3] == 'x':
			return True
	elif field[1][0] == field[2][1] == field[3][2] == 'x':
		return True

	# Left diag
	if field[0][2] == field[1][1] == field[2][0] == 'x':
		return True
	elif field[1][2] == field[2][1] == 'x':
		if field[0][3] == 'x' or field[3][0] == 'x':
			return True
	elif field[1][3] == field[2][2] == field[3][1] == 'x':
		return True

	return False

print(main(Field))