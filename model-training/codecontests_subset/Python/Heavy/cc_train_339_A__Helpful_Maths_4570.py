#code
import sys
import math as mt
#input=sys.stdin.buffer.readline
#t=int(input())
#tot=0
t=1
for __ in range(t):
    #n=int(input())      
    #l=list(map(int,input().split()))  
    #k,n,w=map(int,input().split())            
    #l=list(map(int,input().split()))
    s=input()
    l=[]
    for i in range(len(s)):
        if s[i]!='+':
            l.append(int(s[i]))
    l.sort()
    for i in range(len(l)):
        print(l[i],end="")
        if i!=len(l)-1:
            print('+',end="")
            