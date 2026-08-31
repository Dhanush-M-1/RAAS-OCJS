import itertools
class ListWithDefaultValue(list):
	def __init__(self, *args, **kwargs):
		self.def_value = kwargs.pop('def_value', '$')
		list.__init__(self, *args, **kwargs)
	def __getitem__(self, key):
		if (0 <= key < len(self)):
			return list.__getitem__(self, key)
		else:
			return self.def_value
			

field = ListWithDefaultValue(def_value=ListWithDefaultValue(def_value='$'))
for i in range(4):
	field.append(ListWithDefaultValue(input(), def_value='$'))

for pos in itertools.product(range(4), repeat=2):
	row, column = pos
	if field[row][column] == 'x':
		for d_row, d_column in itertools.product(range(-1, 2), repeat=2):
			if (d_row, d_column) == (0, 0):
				continue
			else:
				first_val = field[row + d_row][column + d_column]
				second_val = field[row + 2 * d_row][column + 2 * d_column]
				if (first_val, second_val) in (('x', '.'), ('.', 'x')):
					print('YES')
					exit()
print('NO')
exit()
		