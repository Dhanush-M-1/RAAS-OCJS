import os,sys
from io import BytesIO, IOBase

def ii(): return int(input())
def si(): return input()
def mi(): return map(int,input().split())
def li(): return list(mi())

import math

# Python program to print prime factors 

import math 

def lcm(a,b):
    return a*b//(math.gcd(a,b))

# A function to print all prime factors of 
# a given number n 
def primeFactors(n): 
    l=[]
	
	# Print the number of two's that divide n 
    while n % 2 == 0: 
        l.append(2)
        n = n //2
		
	# n must be odd at this point 
	# so a skip of 2 ( i = i + 2) can be used 
    for i in range(3,int(math.sqrt(n))+1,2): 
    
        # while i divides n , print i ad divide n 
        while n % i== 0: 
            l.append(i)
            n = n //i 
			
	# Condition if n is a prime 
	# number greater than 2 
    if n > 2: 
        l.append(n)
		
    return l 
    
# This code is contributed by Harshit Agrawal 


for i in range(1):
    n=ii()
    i=1 
    m=1e14
    while(i*i<=n):
        if n%i==0 and lcm(i,n//i)==n:
            a=n//i 
            b=i 
            if max(a,b)<m:
                m=max(a,b)
                ans=i 
        i+=1
    print(ans,n//ans)