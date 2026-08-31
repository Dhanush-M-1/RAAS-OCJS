t=int(input())
#t=1
from sys import *
from math import *
def f(arr,k,x):
    count=0
    for il in arr:
        count+=il//x
    if count>=k:
        return True
    else:
        return False
for ip in range(t):
    n,m=[int(x) for x in input().strip().split()]
    arr=set([int(x) for x in input().strip().split()])
    brr=[int(x) for x in input().strip().split()]
    lx=True
    for it in brr:
        if it in arr:
            print("YES")
            print(1,it);lx=False
            break
    if lx:
        print("NO")
            
    
    
    
        
        
        
            
            
            
        
            
        
        
        
        
            
                
        
    
    
