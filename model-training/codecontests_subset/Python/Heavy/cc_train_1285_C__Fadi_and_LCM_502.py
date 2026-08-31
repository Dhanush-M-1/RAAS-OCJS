# Python program to find LCM of two numbers 

# Recursive function to return gcd of a and b 
def gcd(a,b): 
	if a == 0: 
		return b 
	return gcd(b % a, a) 

# Function to return LCM of two numbers 
def lcm(a,b): 
	return (a*b) / gcd(a,b) 



import math  
  
# method to print the divisors
f=[] 
def printDivisors(n) : 
      
    # Note that this loop runs till square root 
    i = 1
    while i <= math.sqrt(n): 
          
        if (n % i == 0) : 
              
            # If divisors are equal, print only one 
            if (n / i == i) : 
                f.append(i) 
            else : 
                # Otherwise print both 
                f.append(i)
                f.append(n//i)
        i = i + 1

n=int(input())
printDivisors(n)
f.sort()
l=len(f)

if l%2==0:
    s1=l//2-1
    s2=l//2
else:
    s1=l//2-1
    s2=l//2+1
if n==1:
    print("1 1")
else:
    while(True):
        if lcm(f[s1],f[s2])==n:
            print(f[s1],f[s2])
            break
        else:
            s1-=1
            s2+=1


