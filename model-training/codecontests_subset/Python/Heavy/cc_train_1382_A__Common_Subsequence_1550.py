#_________________ Mukul Mohan Varshney _______________#

#Template
import sys
import os
import math
import copy
from math import gcd
from bisect import bisect
from io import BytesIO, IOBase
from math import sqrt,floor,factorial,gcd,log,ceil
from collections import deque,Counter,defaultdict
from itertools import permutations, combinations

#define function 
def Int(): return int(sys.stdin.readline())
def Mint(): return map(int,sys.stdin.readline().split())
def Lstr(): return list(sys.stdin.readline().strip())
def Str(): return sys.stdin.readline().strip()
def Mstr(): return map(str,sys.stdin.readline().strip().split())
def List(): return list(map(int,sys.stdin.readline().split()))
def Hash(): return dict()
def Mod(): return 1000000007
def Ncr(n,r,p): return ((fact[n])*((ifact[r]*ifact[n-r])%p))%p
def Most_frequent(list): return max(set(list), key = list.count)
def Mat2x2(n): return [List() for _ in range(n)]

# Driver Code 	
def solution():
     for i in range(Int()):
          n,m=Mint()
          a=List()
          b=List()
          p=0
          for i in range(m):
               if b[i] in a:
                    ans=b[i]
                    p=1
                    break
          if(p==1):
               print("YES")
               print(1,ans)
          else:
               print("NO")
 
#Call the solve function          
if __name__ == "__main__":
     solution()  