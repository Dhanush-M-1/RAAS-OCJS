while True:
	n=int(input())
	if n==0:
		break
	a=list(map(str,input().split()))
	cnt=0
	l=r=0
	q=0
	for i in range(n):
		if a[i]=="lu":
			l=1
		elif a[i]=="ru":
			r=1
		elif a[i]=="ld":
			l=0
		else:
			r=0
		if l==r==1 and q==0:
			cnt+=1
			q=1
		elif l==r==0 and q==1:
			cnt+=1
			q=0
	print(cnt)


