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
for _ in range(inin()):
    n=inin()
    p2=0
    p3=0
    while(n%2==0):
        p2+=1
        n=n//2
    while(n%3==0):
        p3+=1
        n//=3
    if(n==1):
        if(p3>=p2):
            if(p3==p2):
                print(p3)
            elif(p2==0):
                print(p3*2)
            else:
                print(p3+p3-p2)
        else:
            print(-1)

    else:
        print(-1)
    
    
    
    
        
                
        
        
    
            
        
        
        
    
        
                
            
        
        
        
    
            
            
        
    
    
        
    

        
        
    
                
                
                
                

        
            
            
                
            
                
    
 
        
    
    
    
    




    


   
        
    
    
    
    




    


