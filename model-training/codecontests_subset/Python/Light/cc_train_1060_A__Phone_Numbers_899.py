n = int(input())
if n < 11:
	print(0)
else:
	ss = input()
	count = 0
	for i in range(0, n):
		if int(ss[i]) == 8:
			count += 1
	temp = n // 11
	if temp < count:
		print(temp)
	else:
		print(count)