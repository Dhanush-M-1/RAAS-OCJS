def solve():
	n = int(input())

	start_numbers = set()
	finish_numbers = set()

	matrix = list()
	inversion = list()

	for _ in range(n):
		inp = list(input())
		matrix.append(inp)

	start_numbers.add(matrix[0][1])
	start_numbers.add(matrix[1][0])

	finish_numbers.add(matrix[-1][-2])
	finish_numbers.add(matrix[-2][-1])

	if len(start_numbers) > 1:
		if len(finish_numbers) > 1:
			inversion_number = matrix[1][0]
			inversion.append((1, 2))

			if matrix[-1][-2] == inversion_number:
				inversion.append((n, n - 1))

			else:
				inversion.append((n - 1, n))

		else:
			if matrix[0][1] == matrix[-1][-2]:
				inversion.append((1, 2))

			else:
				inversion.append((2, 1))

	else:
		inversion_number = matrix[0][1]

		if matrix[-1][-2] == inversion_number:
			inversion.append((n, n - 1))

		if matrix[-2][-1] == inversion_number:
			inversion.append((n - 1, n))

	print(len(inversion))

	for coords in inversion:
		print(*coords)

def main():
	for _ in range(int(input())):
		solve()

if __name__ == '__main__':
	main()
