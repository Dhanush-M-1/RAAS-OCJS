import itertools
field = []
for i in range(4):
	field.append(input())
for pos in itertools.product(range(4), repeat=2):
	row, column = pos
	if field[row][column] == 'x':
		for d_row, d_column in itertools.product(range(-1, 2), repeat=2):
			if (d_row, d_column) == (0, 0):
				continue
			elif not 0 <= row + 2 * d_row < 4:
				continue
			elif not 0 <= column + 2 * d_column < 4:
				continue
			else:
				first_val = field[row + d_row][column + d_column]
				second_val = field[row + 2 * d_row][column + 2 * d_column]
				if (first_val, second_val) in (('x', '.'), ('.', 'x')):
					print('YES')
					exit()
print('NO')
exit()
		