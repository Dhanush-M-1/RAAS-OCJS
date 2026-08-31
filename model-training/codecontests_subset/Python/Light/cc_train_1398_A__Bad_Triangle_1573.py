T = int(input())
for _ in range(T):
	n = int(input())
	a = list(map(int, input().split()))
	h = sorted(a)
	kel = max(a)
	if h[0]+h[1]<=kel:
		fir = h[0]
		sec = h[1]

		for i in range(n):
			if a[i]==fir:
				print(i+1,end=' ')
				yu = i
				break
		for i in range(n):
			if a[i]==sec and i!=yu:
				print(i+1,end=' ')
				fyu = i
				break
		for i in range(n):
			if a[i]==kel and i!=yu and i!=fyu:
				print(i+1,end=' ')
				break
		print()

	else:
		print(-1)
