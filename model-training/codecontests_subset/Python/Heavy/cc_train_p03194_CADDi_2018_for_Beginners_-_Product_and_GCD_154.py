n,P=map(int,input().split())
if n==1:
	print(P)
	exit()
if n>39:
  print(1)
  exit()
ans=1
if n==2:
	for i in range(2,10**6+1):
		while P%(i**2)==0:
			ans*=i
			P/=(i**n)
	
if n==3:
	for i in range(2,10**4+1):
		while P%(i**3)==0:
			ans*=i
			P/=(i**n)
	
if n==4:
	for i in range(2,10**3+1):
		while P%(i**4)==0:
			ans*=i
			P/=(i**n)
	  
if n==5:
	for i in range(2,int(10**2.4)+1):
		while P%(i**5)==0:
			ans*=i
			P/=(i**n)
else:
	for i in range(2,101):
		while P%(i**n)==0:
			ans*=i
			P/=(i**n)
print(ans)