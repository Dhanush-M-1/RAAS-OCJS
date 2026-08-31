a,b=map(int,input().split())
count=a
while a>0:
	if a>=b:
		a-=b
		count+=1
		a+=1
	else:
		break
print(count)