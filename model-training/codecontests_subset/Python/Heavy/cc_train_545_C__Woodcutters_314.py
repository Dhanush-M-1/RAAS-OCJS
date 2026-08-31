import sys
import collections
import math
import functools
import itertools
import bisect
import operator
import heapq
import random
true=True
false=False
null=None
SLOW=True
memoi=functools.lru_cache(None)
tcid=0
tcmax=99999999
def fast(): SLOW=False
def compute(val, func): return func(val)
def seq(lo,hi,step=1): 
 return range(lo,hi+1,step)
def sround(val,nd):
 return f'{val:.{nd}f}'
def ceil(a,b):
 ans=a//b
 if a%b!=0: ans+=1
 return ans
def perr(*args,**kwargs): 
 if SLOW:
  print(*args,file=sys.stderr,**kwargs)
def line():
 ln=sys.stdin.readline().strip()
 #perr(ln)
 if ln=='': sys.exit()
 return ln
def lines(n): return [line() for i in range(n)]
def split(ln=None): return (ln or line()).split()
def num(str=None):
 str=str or line()
 return float(str) if '.' in str else int(str)
def nums(o=None):
 if o is not None:
  if isinstance(o, int): o=lines(o)
  elif isinstance(o, str): o=split(o)
 return list(map(num, o or split()))
"""
ceil(a,b) sround(val,nd) true false null @memoi
num(?) nums(?) split(?) lines(n) line()
perr(print) tcmax seq() compute(v,f) tcid fast()
"""
#{#

#}#
def mainloop(tcid=1):
# {{{
 def solve():
  n=num()
  lft=[]
  rgt=[]
  hei=[]
  for ln in lines(n):
   x,h=nums(ln)
   lft.append(x)
   rgt.append(x)
   hei.append(h)
  if n<3:
   return n
  up=[true]*n
  up[0]=up[-1]=false
  for ii in range(1,n-1):
   if up[ii]:
    if lft[ii]-hei[ii]>rgt[ii-1]:
     up[ii]=false
     lft[ii]-=hei[ii]
    elif rgt[ii]+hei[ii]<lft[ii+1]:
     up[ii]=false
     rgt[ii]+=hei[ii]
  return up.count(false)
 ans=solve()
 print(ans)
# }}}
while tcid<tcmax:
 tcid+=1
 mainloop(tcid)
"""

"""