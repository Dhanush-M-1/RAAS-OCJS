import math
a,b=map(int,input().split())
ans=a
rem=0
while(a>=b):
	tmp=a//b
	ans=ans+tmp
	rem=a%b
	a=tmp+rem
print(ans)
	

