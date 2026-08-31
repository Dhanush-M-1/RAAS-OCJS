from sys import stdin,stdout
input=stdin.readline 
import math,bisect

def gcd(a,b):
	if a==0:
		return b
	if b==0:
		return a
	return gcd(b,a%b)


a,b=map(int,input().split())
g=gcd(a,b)
a1=a//g
b1=b//g
f=0
ans=0
while(a1):
	if a1%2==0:
		a1=a1//2
		ans+=1
	elif a1%3==0:
		a1=a1//3
		ans+=1
	elif a1%5==0:
		a1=a1//5
		ans+=1
	else:
		break

while(b1):
	if b1%2==0:
		b1=b1//2
		ans+=1
	elif b1%3==0:
		b1=b1//3
		ans+=1
	elif b1%5==0:
		b1=b1//5
		ans+=1
	else:
		break

if(a1!=1 or b1!=1):
	print(-1)
else:
	print(ans)




"""ans=0
f=0
while(a!=b):
	if(a>b):
		if a%2==0:
			a=a//2
			ans+=1
		elif a%3==0:
			a=a//3
			ans+=1
		elif a%5==0:
			a=a//5
			ans+=1
		else:
			f=1
			break
	elif b>a:
		if b%2==0:
			ans+=1
			b=b//2
		elif b%3==0:
			ans+=1
			b=b//3
		elif b%5==0:
			ans+=1
			b=b//5
		else:
			f=1
			break
	elif a==b:
		break
if(f==1):
	print(-1)
else:
	print(ans)"""

