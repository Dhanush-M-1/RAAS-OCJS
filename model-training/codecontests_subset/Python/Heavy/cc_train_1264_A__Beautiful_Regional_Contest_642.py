from math import *

for _ in range(int(input())):
    
    n = int(input())
    a = list(map(int,input().split()))
    
    f = ceil(n/2)
    ind = 0
    x = 0
    
    for i in range(f):
        m = a.pop()
        if(i == f-1):
            x = m
    
    f = len(a)
    for i in range(f-1,-1,-1):
        if(a[i] == x):
            a.pop()
            
    g = list()
    s = list()
    b = list()
    n = len(a)
    
    if(n>0):
        g.append(a[0])
        for i in range(1,n-1):
            if(a[i] == a[i-1]):
                g.append(a[i])
            else:
                ind = i
                break
        else:
            ind = -1
      
    if(ind >0):  
        while(len(s)<=len(g)):
            try:
                s.append(a[ind])
                ind += 1
            except:
                ind = -1
        for i in range(ind,n-1):
            if(a[i]==a[i-1]):
                s.append(a[i])
            else:
                ind = i
                break
        else:
            ind = -1
    
    if(ind>0):        
        b.append(a[ind])
        for i in range(ind+1,n):
            b.append(a[i])
    
      
    if(len(g)<len(s) and len(g)<len(b) and len(g)>0 and len(s)>0 and len(b)>0):
        print(len(g),len(s),len(b))
    else:
        print(0,0,0)
        
        