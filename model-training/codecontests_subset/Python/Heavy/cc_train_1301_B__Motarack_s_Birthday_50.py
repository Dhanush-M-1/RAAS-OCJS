#code
import sys
import math as mt
input=sys.stdin.buffer.readline
t=int(input())

for __ in range(t):
    n=int(input())      
    #n,k=(map(int,input().split()))  
    l=list(map(int,input().split()))
    ch=[]
    if l[0]!=-1 and l[1]==-1:
        ch.append(l[0])
    for i in range(1,n-1):
        if (l[i-1]==-1 and l[i]!=-1) or (l[i+1]==-1 and l[i]!=-1):
            ch.append(l[i])
    if l[-1]==-1 and l[n-2]!=-1:
        ch.append(l[n-2])
    if l[-1]!=-1 and l[n-2]==-1:
        ch.append(l[-1])
    ch=list(set(ch))
    ch.sort()
    k=2
    if len(ch)==1:
        k=ch[0]
    elif len(ch)>1:
        k=(ch[0]+ch[-1])//2
    #print(ch)
    maxi=0
    for i in range(n):
        if l[i]==-1:
            l[i]=k
    
    for i in range(1,n):
        maxi=max(maxi,abs(l[i-1]-l[i]))
    print(maxi,k)    
        
        
        
 				   			   	 			       	  	