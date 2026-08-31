from sys import stdin, stdout
cin = stdin.readline
cout = stdout.write

for _ in range(int(cin())):
	n = int(cin())
	lst = list(map(int, cin().split()))
	
	a, b = 0, 0
	l = []
	if lst[0] > -1 and lst[1] < 0: l.append(lst[0])
	if lst[n-1] > -1 and lst[n-2] < 0: l.append(lst[n-1])
	
	for i in range(1, n-1):
		if lst[i] > -1 and (lst[i-1] == -1 or lst[i+1] == -1):
			l.append(lst[i])
	
	if not l:
		l.append(0)
	k = (max(l) + min(l))//2
	'''
	for i in range(1,len(l)):
		if max(l[i], l[i-1]) - min(l[i], l[i-1]) > a - b:
			a = max(l[i], l[i-1])
			b = min(l[i], l[i-1])
		elif max(l[i], l[i-1]) - min(l[i], l[i-1]) == a - b:
			if a < max(l[i], l[i-1]):
				a = max(l[i], l[i-1])
				b = min(l[i], l[i-1])
	
	k = (a+b)//2
	'''
	dif = 0
	for i in range(n):
		if lst[i] == -1:
			lst[i] = k
		if i > 0:
			dif = max(dif, max(lst[i], lst[i-1]) - min(lst[i], lst[i-1]))
	cout(str(dif) + ' '+ str(k) + '\n')