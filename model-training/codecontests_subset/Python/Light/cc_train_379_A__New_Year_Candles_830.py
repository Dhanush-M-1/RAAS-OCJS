a,b=map(int,input().split())
s=a
while 1:
	if a>=b:
		a-=b
		a+=1
		s+=1
	else:
		break
print(s)		