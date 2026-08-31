from math import *
from collections import Counter,defaultdict,deque
from sys import stdin, stdout
input = stdin.readline
I =lambda:int(input())
M =lambda:map(int,input().split())
LI=lambda:list(map(int,input().split()))
for _ in range(I()):
  n=I()
  a=LI()
  a.sort()
  d=Counter(a)
  b=n;c=[]
  for i in d.keys():
    if b>n//2:
      b-=d[i]
    elif i==a[-1]:continue
    else:c+=[i]*d[i]
  a=d[a[-1]]
  d=Counter(c)
  b=0;c=0
  for i in d.keys():
    if c<=a:c+=d[i]
    else:b+=d[i]
  if a>=b or a>=c:
    print(0,0,0)
  else:
    print(a,b,c)
  





















        
        
            


        



    









    

            







        
