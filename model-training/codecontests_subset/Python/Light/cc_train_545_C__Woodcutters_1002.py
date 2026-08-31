N = int(input())

XH = list()
for _ in range(N):
	XH.append([int(i) for i in input().split(' ')])

XH.insert(0, [XH[0][0] - XH[0][1] - 1, 0])
XH.append([XH[-1][0] + XH[-1][1] + 1, 0])

a, b = 0, 0
for i in range(1, N+1):
	if XH[i][0] - XH[i][1] > XH[i-1][0] + XH[i-1][1]:
		_a = max(a, b) + 1
	elif XH[i][0] - XH[i][1] > XH[i-1][0]:
		_a = max(a + 1, b)
	else:
		_a = max(a, b)


	if XH[i][0] + XH[i][1] < XH[i+1][0]:
		_b = max(a, b) + 1
	else:
		_b = 0

	a, b = _a, _b

print(max(a, b))