"""def power(x, y): 
    res = 1
    x=x
    while (y > 0): 
        if ((y & 1) == 1) : 
            res = (res * x) 
        y = y >> 1
        x = (x * x)
    return res""" 
"""def fact(n):
    if(n==0):
        return 1
    if(n==1):
        return 1
    return fact(n-1)+fact(n-2)"""

import math
#import combinations


t=int(input())
for _ in range(t):
    n=int(input())
    play=[]
    clear=[]
    flag=1
    for _ in range(n):
        n,m=map(int,input().split())
        play.append(n)
        clear.append(m)
    if(play[0]<clear[0]):
        print("NO")
    else:
        
        for i in range(1,len(play)):
            if(play[i]<play[i-1] or clear[i]<clear[i-1]):
                flag=0
                break
            elif(clear[i]>play[i]):
                flag=0
                break
            elif(play[i]-play[i-1]<clear[i]-clear[i-1]):
                flag=0
                break
        
        if(flag==1):
            print("YES")
        else:
            print("NO")
    #s=input()
    #arr=list(map(int,input().split()))
    #b=list(map(int,input().split()))
    #d={}
    #flag=1
    #n,m=map(int,input().split())
    #count=0
    
            
    
    
