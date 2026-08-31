#-- Parity Alternated Deletions
# https://codeforces.com/problemset/problem/1144/B

import sys
from functools import reduce
from collections import defaultdict

def padOpt(ints):
  sInts = sorted(ints)[::-1]
  odd = []
  even = []

  # Lets start with the highest number
  for i in sInts:
    if i % 2 == 0:
      even.append(i)
    else:
      odd.append(i)

  # i am here.
  total = sum(sInts)
  k = min(len(odd), len(even))
  total -= sum(odd[0: k])
  total -= sum(even[0: k])
  
  # Now subtract the element that has less value.
  n = 0
  if len(odd) > k:
    n = odd[k]

  if len(even) > k:
    if n < even[k]:
      n = even[k]

  total -= n
  print (total) 


def io():
  ''' This function read input from standard input. '''
  totalIns = int(sys.stdin.readline(), 10)
  ints = [] * totalIns

  for i in sys.stdin.readline().strip().split():
    ints.append(int(i, 10))
    
  padOpt(ints)

if __name__ == "__main__":
  io()
