a,b = input().split()
a = int(a)
b = int(b)
ans=a;
r=0
while a>0:
	r+=a
	a=r//b
	r = r%b
	ans+=(a)
	
	
print(ans)