import re
import sys
exit=sys.exit
from bisect import bisect_left as bsl,bisect_right as bsr
from collections import Counter,defaultdict as ddict,deque
from functools import lru_cache
cache=lru_cache(None)
from heapq import *
from itertools import *
from math import inf
from pprint import pprint as pp
enum=enumerate
ri=lambda:int(rln())
ris=lambda:list(map(int,rfs()))
rln=sys.stdin.readline
rl=lambda:rln().rstrip('\n')
rfs=lambda:rln().split()
cat=''.join
catn='\n'.join
mod=1000000007
d4=[(0,-1),(1,0),(0,1),(-1,0)]
d8=[(-1,-1),(0,-1),(1,-1),(-1,0),(1,0),(-1,1),(0,1),(1,1)]
########################################################################

t,m=ris()

mem=[0]*m
id=0

def alloc(n):
  global id
  i=0
  while i<m:
    if mem[i]!=0:
      i+=1
      continue
    j=i+1
    while j<m and j<i+n and mem[j]==0:
      j+=1
    if j<i+n:
      i=j
      continue
    id+=1
    j=i
    while j<i+n:
      mem[j]=id
      j+=1
    return id
  return 0

def erase(x):
  if x<=0:
    return 0
  i=0
  while i<m:
    if mem[i]!=x:
      i+=1
      continue
    while i<m and mem[i]==x:
       mem[i]=0
       i+=1
    return 1
  return 0

def defrag():
  i=0
  for j in range(m):
    if mem[j]!=0:
      mem[i]=mem[j]
      i+=1
  for j in range(i,m):
    mem[j]=0

for _ in range(t):
  op,*args=rfs()
  if op=='alloc':
    n=int(args[0])
    r=alloc(n)
    print(r or 'NULL')
  elif op=='erase':
    x=int(args[0])
    if not erase(x):
      print('ILLEGAL_ERASE_ARGUMENT')
  else:
    defrag()
