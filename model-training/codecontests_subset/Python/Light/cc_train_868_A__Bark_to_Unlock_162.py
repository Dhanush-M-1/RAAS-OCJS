a,b=list(input())
ca=cb=c=0
for i in range(int(input())):
	x,y=list(input())
	if y==a:
		ca+=1
	if x==b:
		cb+=1
	if x==a and y==b:
		c+=1
if c>0 or (ca>0 and cb>0):
	print("YES")
else:	
	print("NO")