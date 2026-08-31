z=input
from math import ceil,log,gcd
"""

n=int(z())

for i in range(n):

x=int(z())

l=list(map(int,z().split()))

a,b=map(int,z().split())

x=z()

l=set(map(int,z().split()))


"""

n1=int(z())
 
             
for _ in range(n1):
    n=int(z())
    i=0
    c=0
    if n==1:
        print(0)
        continue
    while True:
        if n%6==0:
            i+=1
            n=n//6
            c=0
        elif n%6!=0:
            n=n*2
            c+=1
            i+=1
        if c==10 and n!=1:
            print(-1)
            break
        if n==1:
            print(i)
            break

        
        
            
        
    
    
        
    
    

   
                
        

                

        
        
        
