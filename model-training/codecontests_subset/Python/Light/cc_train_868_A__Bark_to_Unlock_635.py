i=list(input())
n=int(input())
a=0
b=0
s=0
for k in range(n):
	li=list(input())
	if(li[0]==i[0]): 
		if(li[1]==i[1]):
			s=1
			break
	if(li[0]==i[1]):
		if(li[1]==i[0]):
			s=1
			break
	if(li[1]==i[0]):
		a=1
	if(li[0]==i[1]):
		b=1
		
if((b==1 and a==1) or s==1):
	print("YES")
else:
	print("NO")