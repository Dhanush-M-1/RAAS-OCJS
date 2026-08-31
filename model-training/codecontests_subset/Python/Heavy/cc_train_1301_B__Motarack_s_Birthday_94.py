t = int(input())


for ti in range(t):
	n = int(input())

	a = input().split()
	
	for i in range(n):
		a[i] = int(a[i])

	m = 0
	thenos = set()
	if a[0] == -1 and a[1] != -1:
		thenos.add(a[1])

	for i in range(1,n):
		if a[i] != -1 and a[i-1] != -1:
			k = abs(a[i]-a[i-1])
			if k > m:
				m = k
		if a[i] == -1:
			if a[i-1] != -1:		
				thenos.add(a[i-1])
			if i < n-1 and a[i+1] != -1:		
				thenos.add(a[i+1])

					
	thenos = list(thenos)
	if len(thenos) != 0:
		maxno = max(thenos)		
		minno = min(thenos)		

		k =int((maxno+minno)/2)

		maxhere = maxno - k
		if maxhere > m:
			print(maxhere,k)
		else:
			print(m,k)
	else:
		print("0 1")			


