import sys
import math
from collections import defaultdict
from collections import deque
from itertools import combinations
from itertools import permutations
input = lambda : sys.stdin.readline().rstrip()
read = lambda : list(map(int, input().split()))
def write(*args, sep="\n"):
  for i in args:
    sys.stdout.write("{}{}".format(i, sep))
INF = float('inf')
MOD = int(1e9 + 7)
YES = "YES"
NO = "0 0 0"

d = {"a" : "b", "b": "c", "c" : "a", '?' : 'a'}

for _ in range(int(input())):
  n = int(input())
  max_award = n // 2
  arr = read()

  low = arr[-1]

  while arr and arr[-1] == low:
    arr.pop()
  
  if len(arr) < 5:
    print(NO)
    continue 
  
  
  arr = arr[::-1]
  high = arr[-1]
  #print(arr, high, "???")

  m = len(arr)
  g = 0
  while arr and arr[-1] == high:
    g += 1
    arr.pop()
  
  if not len(arr) >= 2*(g+1) or g >= max_award - 1:
    print(NO)
    continue

  s = 0
  while s <= g:
    if len(arr) == 0:
      break 

    mid = arr[-1]
    while arr and arr[-1] == mid:
      s += 1
      arr.pop()
  

  
  if s <= g or g + s >= max_award or len(arr) == 0:
    print(NO)
    continue 

  award = max_award - g - s 
  b = 0

  temp = 0
  while 1:
    if not arr:
      break 

    back = arr[-1]
    while arr and arr[-1] == back:
      temp += 1
      arr.pop()
    
    if temp <= award:
      b = max(b, temp)
    else:
      break 
  
  if b == 0 or b <= g or g == 0 or s == 0:
    print(NO)
  else:
    print(g, s, b)