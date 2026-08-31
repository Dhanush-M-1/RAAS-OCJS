# -*- coding: utf-8 -*-
"""
t=int(input())
for _ in range(t):
    n=int(input())
    x=list(map(int,input().split()))
    k,m=map(int,input().split())
    s=input()
 
@author: krishna
"""
# Python3 program to find 
# (a^b)%m for b very large. 

# Function to find power 
def power(x, y, p): 
	res = 1; # Initialize result 

	# Update x if it is 
	# more than or equal to p 
	x = x % p; 

	while (y > 0): 
		
		# If y is odd, multiply 
		# x with the result 
		if (y & 1): 
			res = (res * x) % p; 

		# y must be even now 
		y = y >> 1; # y = y/2 
		x = (x * x) % p; 
		
	return res; 

 

n=int(input())
p=1000000007
ans=1
for i in range(1,n+1):
    ans=ans*i
    ans=ans%p
b=power(2,n-1,p)
print((ans-b)%p)


        
    
