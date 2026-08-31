import sys
import bisect as bi
import math
from collections import defaultdict as dd
import heapq
import itertools
import io
import os
##import operator
input=sys.stdin.readline
##input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
import random
sys.setrecursionlimit(10**7)
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

for _ in range(inin()):
     n=inin()
     mat=[]
     for i in range(n):
          l=sin().strip()
          mat+=[l]
     ans=[]
     tem=0
##     print(mat)
     a,b,c,d=mat[0][1],mat[1][0],mat[-2][-1],mat[-1][-2]
     p=[[1,2],[2,1],[n-1,n],[n,n-1]]
     if(a=='1' and b=='1'):
          if(c=='1'):
               ans+=[p[2]]
               tem+=1
          if(d=='1'):
               ans+=[p[3]]
               tem+=1
     elif(a=='0' and b=='0'):
          if(c=='0'):
               ans+=[p[2]]
               tem+=1
          if(d=='0'):
               ans+=[p[3]]
               tem+=1
     else:
          if(c=='0' and d=='0'):
               if(a=='0'):
                       ans+=[p[0]]
                       tem+=1
               else:
                       ans+=[p[1]]
                       tem+=1

          else:
               if(a=='1'):
                    ans+=[p[0]]
                    tem+=1
               if(b=='1'):
                    ans+=[p[1]]
                    tem+=1
               if(c=='0'):
                    ans+=[p[2]]
                    tem+=1
               if(d=='0'):
                    ans+=[p[3]]
                    tem+=1
     print(tem)
     for i in ans:
          print(*i)
     

               
                    
     
     









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
