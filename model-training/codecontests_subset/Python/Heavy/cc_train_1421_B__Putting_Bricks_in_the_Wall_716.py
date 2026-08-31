
from sys import stdout,stdin
from collections import defaultdict,deque
import math
t=int(stdin.readline())
for _ in range(t):
    n=int(stdin.readline())
    #n,m=map(int,stdin.readline().split())
    #l=list(map(int,stdin.readline().split()))
    l=[]
    for i in range(n):
        l.append(list(input()))
    
    if l[0][1]=='0' and l[1][0]=='0':
        if l[n-1][n-2]=='1' and l[n-2][n-1]=='1':
            print(0)
        elif l[n-1][n-2]=='1' and l[n-2][n-1]=='0':
            print(1)
            print(n-1,n)
        elif l[n-1][n-2]=='0' and l[n-2][n-1]=='1':
            print(1)
            print(n,n-1)
        else:
            print(2)
            print(n,n-1)
            print(n-1,n)
    elif l[0][1]=='1' and l[1][0]=='1':
        if l[n-1][n-2]=='0' and l[n-2][n-1]=='0':
            print(0)
        elif l[n-1][n-2]=='0' and l[n-2][n-1]=='1':
            print(1)
            print(n-1,n)
        elif l[n-1][n-2]=='1' and l[n-2][n-1]=='0':
            print(1)
            print(n,n-1)
        else:
            print(2)
            print(n,n-1)
            print(n-1,n)
    elif l[0][1]=='1' and l[1][0]=='0':
        if l[n-1][n-2]=='0' and l[n-2][n-1]=='0':
            print(1)
            print(2,1)
        elif l[n-1][n-2]=='0' and l[n-2][n-1]=='1':
            print(2)
            print(2,1)
            print(n-1,n)
        elif l[n-1][n-2]=='1' and l[n-2][n-1]=='0':
            print(2)
            print(2,1)
            print(n,n-1)
        else:
            print(1)
            print(1,2)
    elif l[0][1]=='0' and l[1][0]=='1':
        if l[n-1][n-2]=='0' and l[n-2][n-1]=='0':
            print(1)
            print(1,2)
        elif l[n-1][n-2]=='0' and l[n-2][n-1]=='1':
            print(2)
            print(1,2)
            print(n-1,n)
        elif l[n-1][n-2]=='1' and l[n-2][n-1]=='0':
            print(2)
            print(2,1)
            print(n-1,n)
        else:
            print(1)
            print(2,1)
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    
    


    