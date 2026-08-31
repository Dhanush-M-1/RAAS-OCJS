def all_factors(n):
	from functools import reduce
	return set(reduce(list.__add__,([i, n // i] for i in range(1, int(n ** 0.5) + 1) if n % i == 0)))

def gcd(a,b):
	div=int(min(a,b))
	divid=int(max(a,b))
	while(div>0):
		temp=divid%div
		divid=div
		div=temp
	return divid

def lcm(a,b):
	return(a*b)//gcd(a,b)

x=int(input())
ls=list(all_factors(x))
ls.sort()

mini=ls[-1]
for z in range(0,len(ls)-1):
	if(lcm(ls[z],x//ls[z])==x):
		if(mini>max(ls[z],x//ls[z])):
			mini=max(ls[z],x//ls[z])


print(x//mini,end=" ")
print(mini)



	