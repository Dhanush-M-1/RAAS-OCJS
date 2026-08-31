t = int(input())
for i in range(t):
	n = int(input())
	a = list(map(int , input().split(' ')))
	l = []
	for j in range(n):
		if(j - 1 >= 0 and j + 1 < n):
			if(a[j] != -1 and (a[j - 1] == -1 or a[j + 1] == -1)):
				l.append(a[j])
		elif(j - 1 >= 0):
			if(a[j] != -1 and (a[j - 1] == -1)):
				l.append(a[j])
		elif(j + 1 < n):
			if(a[j] != -1 and (a[j + 1] == -1)):
				l.append(a[j])
	ans = 0
	if(len(l) == 0):
		print(0 , 1)
	else:
		m = max(l)
		mi = min(l)
		for j in range(n):
			if(a[j] == -1):
				a[j] = (m + mi)//2
		for j in range(n - 1):
			ans = max(abs(a[j] - a[j + 1]) , ans)
		print(ans , (m + mi)//2)