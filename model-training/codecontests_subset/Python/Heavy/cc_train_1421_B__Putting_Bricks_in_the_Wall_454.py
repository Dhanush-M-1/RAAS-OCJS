t = int(input())
while t:
	t-=1
	n = int(input())
	a = []
	for i in range(n):
		a.append(input())
	ans = []
	if a[0][1] == "0" and a[1][0] == "0":
		if a[n-1][n-2] == "1" and a[n-2][n-1] == "1":
			pass
		elif a[n-1][n-2] == "0" and a[n-2][n-1] == "0":
			ans.append([0,1])
			ans.append([1,0])
		elif (a[n-1][n-2] == "0" and a[n-2][n-1] == "1"):
			ans.append([n-1, n-2])
		else:
			ans.append([n-2, n-1])

	elif a[0][1] == "1" and a[1][0] == "1":
		if a[n-1][n-2] == "1" and a[n-2][n-1] == "1":
			ans.append([0,1])
			ans.append([1,0])
		elif a[n-1][n-2] == "0" and a[n-2][n-1] == "0":
			pass
		elif (a[n-1][n-2] == "0" and a[n-2][n-1] == "1"):
			ans.append([n-2, n-1])
		else:
			ans.append([n-1, n-2])
	elif a[0][1] == "1" and a[1][0] == "0":
		if a[n-1][n-2] == "1" and a[n-2][n-1] == "1":
			ans.append([0, 1])
		elif a[n-1][n-2] == "0" and a[n-2][n-1] == "0":
			ans.append([1,0])
		elif (a[n-1][n-2] == "0" and a[n-2][n-1] == "1"):
			ans.append([n-2, n-1])
			ans.append([1, 0])
		else:
			ans.append([n-1, n-2])
			ans.append([1,0])
	else:
		if a[n-1][n-2] == "1" and a[n-2][n-1] == "1":
			ans.append([1, 0])
		elif a[n-1][n-2] == "0" and a[n-2][n-1] == "0":
			ans.append([0,1])
		elif (a[n-1][n-2] == "0" and a[n-2][n-1] == "1"):
			ans.append([n-1, n-2])
			ans.append([1, 0])
		else:
			ans.append([n-2, n-1])
			ans.append([1,0])

	print(len(ans))
	for i in ans:
		print(i[0]+1, i[1]+1)