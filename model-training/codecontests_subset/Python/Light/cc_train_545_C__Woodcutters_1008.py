n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
count = 1
for i in range(1, n-1):
	x = arr[i][0] - arr[i][1]
	y = arr[i][0] + arr[i][1]
	if x > arr[i-1][0]:
		count += 1
	elif y < arr[i+1][0]:
		count += 1
		arr[i][0] += arr[i][1]

print(count + 1 if n > 1 else 1)