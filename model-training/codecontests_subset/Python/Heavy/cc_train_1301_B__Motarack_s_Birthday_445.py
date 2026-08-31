# def fun()
for t in range(int(input())):
	n = int(input())
	l = [int(j) for j in input().split()]
	ls = []
	for i in range(n):
		if l[i]==-1:
			nb = [max(i-1, 0), min(i+1, n-1)]
			for j in nb:
				if l[j]!=-1:
					ls.append(l[j])
	lf = 1
	# rt = max(l)
	# ls.sort()
	k=0
	try:
		# print(ls)
		mx = max(ls)

		mn = min(ls)
		k = (mx+mn)//2
	except:
		pass
	ans = 0
	if l[0]==-1:
		l[0]=k
	for i in range(1,n):
		if l[i]==-1:
			l[i] = k
		ans = max(ans, abs(l[i]-l[i-1]))
	print(ans, k)


	# print(k)
	# while(lf<rt):
		# m=lf+(rt-lf)/2
		# if fun(m, ls)


