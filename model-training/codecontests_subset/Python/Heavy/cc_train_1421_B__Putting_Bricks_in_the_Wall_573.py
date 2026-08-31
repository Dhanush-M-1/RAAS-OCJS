import sys, os.path
from collections import*
from copy import*
import math
import heapq
mod=10**9+7
if(os.path.exists('input.txt')):
    sys.stdin = open("input.txt","r")
    sys.stdout = open("output.txt","w")  

for t in range(int(input())):
    n=int(input())
    s=[]
    for i in range(n):
        k=input()
        s.append(k)

    a=s[0][1]
    b=s[1][0]
    c=s[n-2][n-1]
    d=s[n-1][n-2]
    if(a==b=='1' and c==d=='0'):
        print(0)
    elif(a==b=='0' and c==d=='1'):
        print(0)
    elif(a=='0' and b=='0' and c=='0' and d=='0'):
        print(2)
        print(1,2)
        print(2,1)
    elif(a=='0' and b=='0' and c=='0' and d=='1'):
        print(1)
        print(n-1,n)
    elif(a=='0' and b=='0' and c=='1' and d=='0'):
        print(1)
        print(n,n-1)
    elif(a=='0' and b=='1' and c=='0' and d=='0'):
        print(1)
        print(1,2)
    elif(a=='0' and b=='1' and c=='0' and d=='1'):
        print(2)
        print(1,2)
        print(n,n-1)
    elif(a=='0' and b=='1' and c=='1' and d=='0'):
        print(2)
        print(1,2)
        print(n-1,n) 
    elif(a=='0' and b=='1' and c=='1' and d=='1'):
        print(1)
        print(2,1)
    elif(a=='1' and b=='0' and c=='0' and d=='0'):
        print(1)
        print(2,1) 
    elif(a=='1' and b=='0' and c=='0' and d=='1'):
        print(2)
        print(2,1) 
        print(n,n-1)
    elif(a=='1' and b=='0' and c=='1' and d=='0'):
        print(2)
        print(2,1) 
        print(n-1,n)
    elif(a=='1' and b=='0' and c=='1' and d=='1'):
        print(1)
        print(1,2)
    elif(a=='1' and b=='1' and c=='0' and d=='1'):
        print(1)
        print(n,n-1)
    elif(a=='1' and b=='1' and c=='1' and d=='0'):
        print(1)
        print(n-1,n)
    elif(a=='1' and b=='1' and c=='1' and d=='1'):
        print(2)
        print(1,2)
        print(2,1) 


    
