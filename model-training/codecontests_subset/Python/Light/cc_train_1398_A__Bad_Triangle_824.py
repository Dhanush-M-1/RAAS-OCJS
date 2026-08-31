def checkTriangle(arr):
	if len(arr) < 3:
		return -1
	a, b, c = arr[0], arr[1], arr[-1]
	if a + b <= c:
		return 1, 2, len(arr)
	else:
		return -1

if __name__ == "__main__":
	n_list = []
	array_list = []
	cases = int(input())
	for i in range(cases):
		n_list.append(input())
		array = list(map(int, input().split()))
		array_list.append(array)

	for array in array_list:
		x = checkTriangle(array)
		if x == -1:
			print(x)
		else:
			print(' '.join([str(i) for i in checkTriangle(array)]))


