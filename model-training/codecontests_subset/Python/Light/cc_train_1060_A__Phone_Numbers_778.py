n=int(input())
s=str(input())
if(n<11):
	print(0)
else:
	count=0
	for i in range(0,n):
		if(s[i]=='8'):
			count+=1
	print(min(count,n//11))
	