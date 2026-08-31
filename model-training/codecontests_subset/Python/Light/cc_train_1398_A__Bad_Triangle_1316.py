import sys
input = sys.stdin.readline

for _ in range(int(input())):
	n = int(input())
	lst = list(map(int, input().split()))

	a, b, c = [1, 2, -1]
	end = False
	for i in range(2, n):
		if lst[a-1] + lst[b-1] <= lst[i] or lst[a-1] + lst[i] <= lst[b-1] or lst[b-1] + lst[i] <= lst[a-1]:
			end = True
			print(a, b, i+1)
			break
	if not end: print(-1)


		

	

