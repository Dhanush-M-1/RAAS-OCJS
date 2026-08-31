from collections import Counter,defaultdict,deque
import heapq as hq
#alph = 'abcdefghijklmnopqrstuvwxyz'
#from math import factorial as fact
import math
#nl = '\n'
import sys
input=sys.stdin.readline
#print=sys.stdout.write
#tt = int(input())
#total=0
#n = int(input())
#n,m,k = [int(x) for x in input().split()]
#n = int(input())
#l,r = [int(x) for x in input().split()]
n = int(input())
if n==1:
   print(1)
elif n ==2:
   print(2)
elif n==3:
   print(6)
else:
   if n%2==0:
      if math.gcd(n,n-3)==1:
         print(max(n*(n-1)*(n-2)//2,(n-1)*(n-2)*(n-3),n*(n-1)*(n-3)))
      else:
         print(max(n*(n-1)*(n-2)//2,(n-1)*(n-2)*(n-3)))
   else:
      print(n*(n-1)*(n-2))




   
   
 
