import sys
import bisect as bi
import math
from collections import defaultdict as dd
import heapq
import itertools
##import operator
input=sys.stdin.readline
import random
##sys.setrecursionlimit(10**7)
##fo=open("output.txt","w")
##fi=open("input2.txt","w")
mo=10**9+7
def cin():
    return map(int,sin().split())
def ain():            
    return list(map(int,sin().split()))
def sin():
    return input()
def inin():
    return int(input())
def pref(a,n,f):             
    pre=[0]*n
    if(f==0):         ##from beginning
        pre[0]=a[0]
        for i in range(1,n):
            pre[i]=a[i]+pre[i-1]
    else:              ##from end
        pre[-1]=a[-1]
        for i in range(n-2,-1,-1):
            pre[i]=pre[i+1]+a[i]
    return pre
def deccheck(l,n):
##    print(l,n)
    k=[ i for i in range(n)]
    k=k[::-1]
    for i in range(0,n):
        if(l[i]<k[i]):
            return False
    return True
##def inccheck(l,n):
####    print(l,n)
##    start=l[0]
##    k=[ i for i in range(start,start+n)]
##    for i in range(0,n):
##        if(l[i]<k[i]):
##            return False
##    return True
for _ in range(inin()):
    n=inin()
    l=ain()
    k=0
    if(n==1 or (n==2 and l!=[0,0])):print("YES")
    elif(n==2):print("NO")
    else:
        for i in range(1,n):
            if(l[i]>=i):
                continue
            else:
                k=i
                break
        if(k==0):
            print("YES")
        elif(deccheck(l[k-1:],n-k+1)):
            print("YES")
        else:
            print("NO")
            
        
        
        
    
    
            
        
##    n,k=cin()
##    d=dd(int)
##    x=ain()
##    y=ain()
##    for i in x:
##        d[i]+=1
##    d=sorted(d.items(),key = lambda x:x[1],reverse=True)
##    print(d)
##for n in range(1,1001):

                
            
            
    
        
        
    

##def msb(n):n|=n>>1;n|=n>>2;n|=n>>4;n|=n>>8;n|=n>>16;n|=n>>32;n|=n>>64;return n-(n>>1) #2 ki power
##def pref(a,n,f):             
##    pre=[0]*n
##    if(f==0):         ##from beginning
##        pre[0]=a[0]
##        for i in range(1,n):
##            pre[i]=a[i]+pre[i-1]
##    else:              ##from end
##        pre[-1]=a[-1]
##        for i in range(n-2,-1,-1):
##            pre[i]=pre[i+1]+a[i]
##    return pre
##maxint=10**24 
##def kadane(a,size): 
##    max_so_far = -maxint - 1
##    max_ending_here = 0
##       
##    for i in range(0, size): 
##        max_ending_here = max_ending_here + a[i] 
##        if (max_so_far < max_ending_here): 
##            max_so_far = max_ending_here 
##  
##        if max_ending_here < 0: 
##            max_ending_here = 0   
##    return max_so_far
##def power(x, y):
##    if(y == 0):return 1
##    temp = power(x, int(y / 2))%mo
##    if (y % 2 == 0):return (temp * temp)%mo 
##    else:
##        if(y > 0):return (x * temp * temp)%mo 
##        else:return ((temp * temp)//x )%mo
