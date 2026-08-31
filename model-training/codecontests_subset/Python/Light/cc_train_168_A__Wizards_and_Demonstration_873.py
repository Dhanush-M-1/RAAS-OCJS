n,w,p=map(int,input().split())
x=(n*p)/100
if x%1==0:
	if int(x-w)>0:
		print(int(x-w))
	else:
		print(0)
else:
	if int(x)+1-w>0:
		print(int(x)+1-w)
	else:
		print(0)