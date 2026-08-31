#code
import sys
import math as mt
#input=sys.stdin.buffer.readline
t=int(input())
#tot=0
for __ in range(t):
    #n=int(input())      
    #l=list(map(int,input().split()))  
    n,l,r=map(int,input().split())            
    j=1
    k=2*n-2
    mul=1
    k=2*n-2
    r1=k
    l1=1
    for i in range(n-2):
        if l>=l1 and l<=r1:
            #print(111,l1,r1,mul)
            break
        k-=2
        l1=r1+1
        r1=l1+k-1
        mul+=1
        
    #print(111,l1,r1,mul,k)
    nex=mul
    ch=0
    #print(999,ch)
    for i in range(l1,min(r1+1,r+1)):
        if i>=l:
            if ch%2!=0:
                nex+=1
                print(nex,end=" ")
            else:
                print(mul,end=" ")
        else:
            if ch%2!=0:
                nex+=1
        ch+=1
        if i>r1:
            break
    i=r1+1
    mul+=1
    ch=0
    nex=mul
    k-=1
    while i<=min(r,n*(n-1)):
        if ch%2==0:
            print(mul,end=" ")
        else:
            nex+=1
            print(nex,end=" ")
        i+=1
        ch+=1
        if ch==2*(n-mul):
            mul+=1
            ch=0
            nex=mul
            
    if r==n*(n-1)+1:
        print(1,end=" ")
    print()    
    
       
            