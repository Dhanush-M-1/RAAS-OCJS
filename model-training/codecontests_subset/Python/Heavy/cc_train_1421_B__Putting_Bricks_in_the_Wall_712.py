t = int(input())
while t > 0:
	t -= 1
	dim = int(input())
	a1 = None
	a2 = None
	a3 = None
	a4 = None
	if dim >= 4:
		a1 = int(input()[1]) 
		a2 = int(input()[0])
		for i in range(dim - 4):
			inp = input()
		a3 = int(input()[dim - 1])
		a4 = int(input()[dim - 2])
	elif dim == 3:
		a1 = int(input()[1])
		midInp = input()
		a2 = int(midInp[0])
		a3 = int(midInp[2])
		a4 = int(input()[1])
	L = []
	if a1 == a2:
		changeTo = 1 - a1
		if a3 != changeTo:
			L.append(3)
		if a4 != changeTo:
			L.append(4)
	else:
		if a3 == a4:
			changeTo = 1 - a3
			if a1 != changeTo:
				L.append(1)
			else :
				L.append(2)
		else:
			L.append(1)
			if a3 != a1:
				L.append(3)
			else:
				L.append(4)
	print(len(L))
	for i in L:
		if i == 1:
			print("1 2")
		if i == 2:
			print("2 1")
		if i == 3:
			print(str(dim - 1) + " " +str(dim))
		if i == 4:
			print(str(dim) + " " + str(dim-1))

