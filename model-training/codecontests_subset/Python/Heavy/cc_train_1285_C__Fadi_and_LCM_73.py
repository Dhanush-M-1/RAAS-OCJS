from collections import Counter
import string
import math
import sys
def array_int():
    return [int(i) for i in sys.stdin.readline().split()]
def vary(number_of_variables):
    if number_of_variables==1:
        return int(sys.stdin.readline())
    if number_of_variables>=2:
        return map(int,sys.stdin.readline().split()) 
def makedict(var):
    return dict(Counter(var))
mod=100000007
# sys.stdin=open('input.txt','r')
# sys.stdout=open('output.txt','w')
def printDivisors(n) :
    divisors=[]
    # Note that this loop runs till square root
    i = 1
    while i <= math.sqrt(n):
         
        if (n % i == 0) :
             
            # If divisors are equal, print only one
            if (n//i == i) :
                divisors.append(i)
            else :
                # Otherwise print both
                divisors.extend((i,n//i))
        i = i + 1
    return divisors
n=vary(1)
z=printDivisors(n)
if len((z))==2 or len(z)==1:
    print(1,n)
else:
    ans=float('inf')
    for i in range(len(z)):
        if (z[i]*(n//z[i]))//math.gcd(z[i],(n//z[i]))==n:
            ans=min(ans,max(z[i],n//z[i]))
    print(ans,n//ans)
    
    
    
        
    

    

        


        



    


    


    



