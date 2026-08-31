from sys import stdin,stdout
input=stdin.readline
#print=stdout.write
from random import sample
t=int(input())
#t=1
from collections import Counter
from math import sqrt,ceil
#dist=[0]*(n+1)
def f(arr,i,j,d,dist):
    if i==j:
        return 
    nn=max(arr[i:j])
    for tl in range(i,j):
        if arr[tl]==nn:
            dist[tl]=d
            #print(tl,dist[tl])
            f(arr,i,tl,d+1,dist)
            f(arr,tl+1,j,d+1,dist)
    #return dist
            
        
def ps(n):
    cp=0
    while n%2==0:
        n=n//2
        cp+=1
    for ps in range(3,ceil(sqrt(n))+1,2):
        while n%ps==0:
            n=n//ps
            cp+=1
            
    if n!=1:
        return False
    return True


#count=0
#dp=[[0 for i in range(m)] for j in range(n)]
#[int(x) for x in input().strip().split()]
def find_gcd(x, y): 
      
    while(y): 
        x, y = y, x % y 
      
    return x 
          
# Driver Code         
def factorials(n,r):
    #This calculates ncr mod 10**9+7
    slr=n;dpr=r
    qrr=1;qs=1
    mod=10**9+7
    
    for ip in range(slr-dpr+1,slr+1):
        qlr=(qlr*ip)%mod
    for ij in range(1,dpr+1):
        qs=(qs*ip)%mod
    ans=(qlr*modInverse(qs))%mod
    return ans

        
        
def modInverse(b):
    qr=10**9+7
    return pow(b, qr - 2,qr)

tt=[xa**3 for xa in range(0,10**4+1)]
qq=set(tt)


for jj in range(t):
    ll=int(input());n=ll
    arr=[int(x) for x in input().strip().split()]
    dist=[0]*n
    f(arr,0,n,0,dist)
    dist=[str(xa) for xa in dist];print(' '.join(dist))
    
    
    
        
        
    
    
            
            
            
        
        
            
        
        
        
    
        
            
            
            
            
    
    
    
            
    
    
        
    
    
    
        
    
    
                   
    
        
                
        
    
        
        
        
        
        
                
    
    
    
    
        
    
    
    
    
        
        
        
        
            
        
    

