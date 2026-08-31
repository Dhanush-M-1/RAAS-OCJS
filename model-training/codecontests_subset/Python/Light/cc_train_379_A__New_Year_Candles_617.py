a,b=input().split()
count=0
a=int(a)
b=int(b)
m=a
rem=0
while(a!=0):
	count+=a//b
	rem+=a%b
	a=a//b
	if(a==0 and rem>=b):
		a=rem
		rem=0
print(count+m)