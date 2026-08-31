dbg = False
tc = 581
rc = 0
k = int(input())
for __ in range(k):		
	n = int(input())
	xm=-1
	xM=-1
	e = True
	predif = -1
	a = [int(x) if x != "-1" else None for x in input().split()]


	if dbg and k == 10000:
		rc += 1
		if rc == tc:
			print(a)
			break
		else:
			continue


	for i in range(n):
		if a[i] != None:
			e = False
			if i != 0:
				if a[i-1] != None:
					predif = max(predif,abs(a[i-1]-a[i]))
			if i != n-1:
				if a[i+1] != None:
					predif = max(predif,abs(a[i+1]-a[i]))
	if e:
		print(0,0)
		continue
	for i in range(n):
		if a[i] == None:
			if i != 0:
				if a[i-1] != None:
					xm = a[i-1] if xm == -1 else min(xm,a[i-1])
					xM = a[i-1] if xM == -1 else max(xM,a[i-1]) 
			if i != n-1:
				if a[i+1] != None:
					xm = a[i+1] if xm == -1 else min(xm,a[i+1])
					xM = a[i+1] if xM == -1 else max(xM,a[i+1])
	val = (xM+xm)//2
	ans = max(xm-val,xM-val)

	if dbg:print(xm,xM)
	print(ans,val)  if ans >= predif else print(predif,val) 
		
			