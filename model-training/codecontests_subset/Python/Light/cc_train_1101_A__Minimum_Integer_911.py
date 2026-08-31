n=int(input())
for i in range(n):
	l,r,d=map(int,input().split())
	t=0
	for i in range(1,l//d+1):
		q=d*i
		if (q<l or q>r) and q!=0:
			t+=1
			print(q)
			break
	if t==0:
		for i in range(r//d,(r//d)+5):
			q=d*i
			if (q<l or q>r) and q!=0:
				print(q)
				break