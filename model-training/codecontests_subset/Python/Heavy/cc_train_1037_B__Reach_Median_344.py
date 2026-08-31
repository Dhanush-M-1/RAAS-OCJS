a = input().split()
a = [int(i) for i in a]
b = input().split()
b = [int(i) for i in b]

mid = a[0] // 2
b = sorted(b)


if a[0] == 1:
	print (abs(a[1] - b[0]))
elif a[1] in b:
	ind = b.index(a[1])
	if ind == mid:
		print (0)
	elif ind < mid:
		print (sum([t - a[1] for t in b[ind:mid + 1]]))
	elif ind > mid:
		print (sum([a[1] - t for t in b[mid:ind+1]]))
elif a[1] not in b:
	if (b[mid] > a[1]) and a[1] >= b[0]:
		ind = a[0] - 1 - b[::-1].index(max([i for i in b if a[1]>i]))
		print (sum([t - a[1] for t in b[ind + 1:mid + 1]]))
	elif  (b[mid] > a[1]) and a[1] < b[0]:
		print (sum([t - a[1] for t in b[0:mid+1]]))
	if (b[mid] < a[1]) and a[1] <= b[-1]:
		ind = b.index(min([i for i in b if a[1]<i]))
		print (sum([a[1] - t for t in b[mid:ind]]))
	elif (b[mid] < a[1]) and a[1] > b[-1]:
		print (sum([a[1]-t for t in b[mid:]]))