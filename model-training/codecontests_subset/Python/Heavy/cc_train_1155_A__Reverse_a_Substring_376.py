import sys     
import math as mt
import bisect
#input=sys.stdin.readline
#t=int(input())
t=1  
    
for _ in range(t):
    n=int(input())
    #n,q=map(int,input().split())
    #x,y,k=map(int,input().split())
    #n,h=(map(int,input().split()))
    #l=list(map(int,input().split()))
    s=input()
    d={}
    for i in range(n):
        if d.get(s[i],-1)==-1:
            d[s[i]]=[]
        d[s[i]].append(i)
    for i in range(n):
        ind=-1
        for j in d:
            if j<s[i] and d[j][-1]>i:
                ind=d[j][-1]+1
                break
        if ind!=-1:
            x,y=i+1,ind
            break
    if ind==-1:
        print("NO")
    else:
        print("YES")
        print(x,y)