from collections import defaultdict as m
from collections import deque
from math import gcd,floor,log 

t=int(input())
while t:
    t-=1
    # n=int(input())
    s=input()
    # l=list(map(int,input().split()))
    s+="@@"
    q=len(s)
    w=[0 for i in range(q)]
    u=0
    for i in range(q-2):
        if(w[i]==1):
            continue
        x,y,z=s[i],s[i+1],s[i+2]
        if(x==y and y==z):
            w[i+1]=1
            w[i+2]=1
            u+=2
        elif(x==y):
            w[i+1]=1
            u+=1
        elif(x==z):
            w[i+2]=1
            u+=1
    print(u)
    
