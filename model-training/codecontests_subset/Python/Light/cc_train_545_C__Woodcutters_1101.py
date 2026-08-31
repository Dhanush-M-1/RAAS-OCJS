n = int(input())
x = []
for i in range(n):
	x.append([int(i) for i in input().split()])

if n == 1:
	count = 1
else:
	count = 2
	
right = 0
for i in range(1, n-1):
	if x[i][0] - x[i-1][0] - right*x[i-1][1] > x[i][1]:
		count += 1
		right = 0
	elif x[i+1][0] - x[i][0] > x[i][1]:
		count += 1
		right = 1
	else:
		right = 0

print(count) 