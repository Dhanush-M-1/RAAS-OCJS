# Main maut ko takiya, aur kaafan ko chaadar banakar audhta hoon!

pas=input()

n=int(input())

flag1=0
flag2=0


for i in range(n):
	s=input()
	
	if(s==pas):
		flag1=1
		flag2=1
		break
	
	if(s[:1]==pas[1:]):
		flag1=1
	
	if(s[1:]==pas[:1]):
		flag2=1


if(flag1==1 and flag2==1):
	print("YES")
	
else:
	print("NO")