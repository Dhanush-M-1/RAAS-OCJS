for _ in range(int(input())):
	n=int(input())
	l=[]
	for i in range(n):
		l.append(input())
	a=l[1][0];b=l[0][1];c=l[n-2][n-1];d=l[n-1][n-2]
	if a==b and c==d:
		if a==c:
			print(2);print(1,2);print(2,1)
		else:
			print(0)
	elif a==b:
		if a==c:
			print(1);print(n-1,n)
		else:
			print(1);print(n,n-1)
	elif c==d:
		if a==c:
			print(1);print(2,1)
		else:
			print(1);print(1,2)
	else:
		if a==c:
			print(2);print(2,1);print(n,n-1)
		else:
			print(2);print(2,1);print(n-1,n)