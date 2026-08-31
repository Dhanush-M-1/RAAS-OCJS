a,b=tuple(input().split(' '))
a=int(a)
b=int(b)
used=0
hours=0
while(a!=0):
	a-=1
	hours+=1
	used+=1
	if used%b==0:
		used=0
		a+=1
print(hours)

