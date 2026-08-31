t = int(input())
for i in range(t):
	n = int(input())
	a = list(map(int,input().split()))
	l = []
	for j in range(len(a)):
		if j == 0:
			if a[j+1] == -1 and a[j]!=-1:
				l.append(a[j])
		elif j == len(a)-1:
			if a[j-1] == -1 and a[j]!=-1:
				l.append(a[j])
		elif (a[j-1] == -1 or a[j+1] == -1) and a[j]!=-1:
			l.append(a[j])
	if len(l) == 0:
		k = 0
	else:
		k = (max(l)+min(l))//2
	for j in range(len(a)):
		if a[j] == -1:
			a[j] = k
	m = 0
	for j in range(len(a)-1):
		if abs(a[j]-a[j+1])>m:
			m = abs(a[j]-a[j+1])
	print(m,k)