from sys import stdin
import math
t=int(stdin.readline())
while t:
    a,b,c=map(int,stdin.readline().split())
    a_,b_,c_=a,b,c
    if b==0 or (a==0 and c==0) or (b<2 and c<2):
        k=0
    else:
        p=c//2
        if b>=p:
            q=p//2
            k=3*p
            b-=p
            m=b//2
            if a>=m: 
                n=m//2
                k+=(3*m)
            else:
                k+=(3*a)
        else:
            k=3*b
        #
        m=b_//2
        if a_>=m:
            n=m//2
            k_=3*m
            b_-=(2*m)
            p=c_//2
            if b_>=p:
                q=p//2
                k_+=(3*p)
            else:
                k_+=(3*b_)
        else:
            k_=3*a
        
        k=max(k,k_)    
    print(k)    
    t-=1