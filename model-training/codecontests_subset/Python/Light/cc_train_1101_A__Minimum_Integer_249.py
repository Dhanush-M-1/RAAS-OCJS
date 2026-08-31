test = int(input())
for i in range(test):
	ans = 0
	l,r,d = input().split()
	[l,r,d]=[int(l),int(r),int(d)]

	if l<=d:
		if(r%d==0):
			ans=r+d
		else:
			ans=r+d-(r%d)

	elif l>d:
		ans =d
				
		

	print(ans)