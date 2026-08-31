def gcd(a,b): 
	if a == 0: 
		return b 
	return gcd(b % a, a)  
def lcm(a,b): 
	return (a*b) / gcd(a,b) 
import math  

def printDivisors(n) : 
    factor=[]
    i = 1
    while i <= math.sqrt(n): 
        if (n % i == 0) :  
            if (n / i == i) : 
                factor.append(i) 
            else : 
                factor.append(i)
                factor.append(n//i)
        i = i + 1
    return factor    
n=int(input())
factor=printDivisors(n)
factor.sort()
lau=len(factor)
if lau%2==0:
    shh1=lau//2-1
    shh2=lau//2
else:
    shh1=lau//2-1
    shh2=lau//2+1
if n==1:
    print("1 1")
else:
    while(True):
        if lcm(factor[shh1],factor[shh2])==n:
            print(factor[shh1],factor[shh2])
            break
        else:
            shh1-=1
            shh2+=1