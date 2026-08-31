t=int(input())
#l=[];sets=set()
#t=1
def primes(n):
    count=0;rl=0
    while n%2==0:
        n=n//2
        count+=1
    while n%3==0:
        n=n//3
        rl+=1
    if (n!=1 or count>rl):
        return -1
    else:
        return [rl,count]
        
            
        
    
from math import *
for xy in range(t):
    n=int(input())
    #x,y,n=list(map(int,input().split()))
    #l=list(map(int,input().split()))
    #tx=max(l)
    rq=primes(n)
    if (rq==-1):
        print(-1)
    else:
        print(rq[0]-rq[1]+rq[0])
        
    
        
    
            
            
    
    
    
    
        
        
            
        
    
            
    
        
        
            
        
        
    
    
