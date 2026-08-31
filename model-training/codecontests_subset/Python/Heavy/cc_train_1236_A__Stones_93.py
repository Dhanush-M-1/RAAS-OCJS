"""def power(x, y): 
    res = 1  
    while (y > 0): 
        if ((y & 1) == 1) : 
            res = res * x 
        y = y >> 1
        x = x * x 
    return res """
"""def fact(n):
    if(n==0):
        return 1
    if(n==1):
        return 1
    return fact(n-1)+fact(n-2)"""
import math
t=int(input())
for _ in range(t):
    #n=int(input())
    a,b,c=map(int,input().split())
    #arr=list(map(int,input().split()))
    #s=input()
    count=0
    #cur_sum=0
    if(b==0):
        print("0")
    elif(a==0):
        while(b>=1 and c>1):
            b=b-1
            count=count+1
            c=c-2
            count=count+2
        print(count)
    elif(c==0):
        while(a>=1 and b>1):
            a=a-1
            count=count+1
            b=b-2
            count=count+2
        print(count)
    else:
        while(b>=1 and c>1):
            b=b-1
            count=count+1
            c=c-2
            count=count+2
        while(a>=1 and b>1):
            a=a-1
            count=count+1
            b=b-2
            count=count+2
        print(count)
