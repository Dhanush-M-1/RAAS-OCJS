#t=int(input())
#l=[];sets=set()
t=1
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
    n,k=[int(x) for x in input().split()]
    #l=[int(x)%k for x in input().split()]
    tq={};sets=set()
    ar=[];ac=[];bb=[]
    for i in range(n):
        t,a,b=[int(x) for x in input().split()]
        if (a==1 and b==1):
            bb.append(t)
        elif a==1:
            ar.append(t)
        elif b==1:
            ac.append(t)
    ar=sorted(ar);ac=sorted(ac);bb=sorted(bb)
    #print(ar,ac,bb)
    i=0;j=0
    count=0;
    lp=0
    rq=True
    while lp<k:
        if (i<len(ar) and i<len(ac) and ((j<len(bb) and ac[i]+ar[i]<=bb[j]) or (j>=len(bb)))):
            
            count+=(ar[i]+ac[i]);i+=1;lp+=1
        elif j<len(bb):
            count+=bb[j];
            j+=1;lp+=1
            #print(count)
            #count+=1
        else:
            rq=False
            break
    if rq:
        print(count)
    else:
        print(-1)
            
            
            
        
    
            
        
    
        
    
            
            
    
    
    
    
        
        
            
        
    
            
    
        
        
            
        
        
    
    
