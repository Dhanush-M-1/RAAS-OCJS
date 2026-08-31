t = int(input())
for i in range(t):
	n = int(input())
	A = []
	for i in range(n):
		b = list(map(str,input().split()))
		b=b[0]
		B=[]
		for i in range(n):
			B+=b[i]
		A += [B]	
	a = A[0][1]
	b = A[1][0]
	c = A[-2][-1]
	d = A[-1][-2]
	change = []
	count = 0
	if a == b:
		if a==c:
			change.append([n-1,n])
			count+=1
		if a==d:
			change.append([n,n-1])
			count+=1
	elif c == d:
		if a==c:
			change.append([1,2])
			count+=1
		if b==c:
			change.append([2,1])
			count+=1
	else :
		change.append([2,1])
		count+=1
		if a == c:
			change.append([n-1,n])
			count+=1
		else :
			change.append([n,n-1])
			count+=1
	print(count)
	for i in change:
		print(" ".join(map(str,i)))