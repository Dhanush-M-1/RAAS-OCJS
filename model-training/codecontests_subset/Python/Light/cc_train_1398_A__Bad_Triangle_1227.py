def find(li, n):
	for i in range(n - 2):
		if li[i] + li[i + 1] <= li[n - 1]:
			return i + 1, i + 2, n
	return None


for j in range(int(input())):
	n = int(input())
	li = [int(x) for x in input().split()]
	print(*find(li, n)) if find(li, n) != None else print(-1)
	

	

