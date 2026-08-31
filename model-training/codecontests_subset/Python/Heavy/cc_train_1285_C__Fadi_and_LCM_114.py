import sys
import math as mt 
input=sys.stdin.buffer.readline
#t=int(input())
t=1
for ___ in range(t):
    x=int(input())
    x1=x
    i=2
    pf=[]
    #pf.append(1)
    while i*i<=x:
        if x%i==0:
            curr=1
            while x%i==0:
                curr*=i    
                x//=i
            pf.append(curr)
        i+=1
    if x1>1:
        pf.append(x)
    #print(pf)    
    n=len(pf)
    a,b=10**18+1,10**18+1
    
    for i in range(1<<n):
        a1,b1=1,1
        for j in range(n):
            if ((i>>j) & 1):
                a1*=pf[j]
            else:
                b1*=pf[j]
        if max(a,b)>max(a1,b1):
            a=a1
            b=b1
            
    print(a,b)    
            
            
    