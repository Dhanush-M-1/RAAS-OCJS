for _ in range(int(input())):
	n = int(input())
	a = [input() for i in range(n)]
	a1 = []
	a2 = []
	if a[0][1]!='0':
		a1.append([0,1])
	if a[1][0]!='0':
		a1.append([1,0])
	if a[n-1][n-2]!='1':
		a1.append([n-1,n-2])
	if a[n-2][n-1]!='1':
		a1.append([n-2,n-1])
	if a[0][1]!='1':
		a2.append([0,1])
	if a[1][0]!='1':
		a2.append([1,0])
	if a[n-1][n-2]!='0':
		a2.append([n-1,n-2])
	if a[n-2][n-1]!='0':
		a2.append([n-2,n-1])
	if len(a1)<=2:
		print(len(a1))
		for i,j in a1:
			print(i+1,j+1)
	else:
		print(len(a2))
		for i,j in a2:
			print(i+1,j+1)
