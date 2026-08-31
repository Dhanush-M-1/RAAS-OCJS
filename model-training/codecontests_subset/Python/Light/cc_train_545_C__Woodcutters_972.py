n = int(input())
xh = []
for i in range(n):
	x, h = [int(x) for x in input().split()]
	xh.append((x, h))
count = 2
pre = xh[0][0]
if n == 1:
	print(1)
elif n == 2:
	print(2)
else:
	for i in range(1, n - 1):
		if xh[i][0] - xh[i][1] > pre:
			count += 1
			pre = xh[i][0]
			continue
		if sum(xh[i]) < xh[i + 1][0]:
			count += 1
			pre = sum(xh[i])
			continue
		pre = xh[i][0]
	print(count)
