import sys
import bisect as b
import math
from collections import defaultdict as dd
input=sys.stdin.readline
#sys.setrecursionlimit(10**7)
def cin():
    return map(int,sin().split())
def ain():            
    return list(map(int,sin().split()))
def sin():
    return input()
def inin():
    return int(input())
for _ in range(1):
    n,k=cin()
    l=[]
    l1=[]
    l3=[]
    for i in range(n):
        t,a,b=cin()
        if(a==1 and b==1):
            l3+=[t]
        elif(a==1):
            l+=[t]
        elif(b==1):
            l1+=[t]
    l=sorted(l,reverse=True)
    l1=sorted(l1,reverse=True)
    l3=sorted(l3,reverse=True)
    ans=-1
    ma=10**5
    if(len(l)+len(l3)>=k and len(l1)+len(l3)>=k):
        ans=0
        k1=k2=k
        while(k1>0 and k2>0):
            if(len(l1)==0):l1+=[ma]
            if(len(l)==0):l+=[ma]
            if(len(l3)==0):l3+=[ma]
            
            
            if(l[-1]+l1[-1]>l3[-1]):
                ans+=l3.pop()
            else:
                ans+=l1.pop()
                ans+=l.pop()
            k1-=1
            k2-=1
    print(ans)
                
        
        
    
            
    
    
            
    
    
    
    
    
    
        
                
        
        
    
            
        
        
        
    
        
                
            
        
        
        
    
            
            
        
    
    
        
    

        
        
    
                
                
                
                

        
            
            
                
            
                
    
 
        
    
    
    
    




    


   
        
    
    
    
    




    


