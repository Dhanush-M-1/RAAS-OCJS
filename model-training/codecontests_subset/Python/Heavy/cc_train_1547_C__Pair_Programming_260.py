def solve(k, n, m, arr1, arr2):
	res = []
	i = j = 0
	while i != n or j != m:
		if i != n and arr1[i] <= k:
			res.append(arr1[i])
			if arr1[i] == 0:
				k += 1
			i += 1
		elif j != m and arr2[j] <= k:
			res.append(arr2[j])
			if arr2[j] == 0:
				k += 1
			j += 1
		else:
			res = [-1]
			break
	return ' '.join(map(str, res))


if __name__ == '__main__':
	t = int(input())
	for _ in range(t):
		input()
		k, n, m = map(int,input().split())
		arr1 = list(map(int,input().split()))
		arr2 = list(map(int,input().split()))
		print(solve(k, n, m, arr1, arr2))