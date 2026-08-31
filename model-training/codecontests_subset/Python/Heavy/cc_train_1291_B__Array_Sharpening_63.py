import sys
import math
from collections import defaultdict
from collections import deque
from itertools import combinations
from itertools import permutations
input = lambda : sys.stdin.readline().rstrip()
read = lambda : list(map(int, input().split()))
go = lambda : 1/0
def write(*args, sep="\n"):
  for i in args:
    sys.stdout.write("{}{}".format(i, sep))
INF = float('inf')
MOD = int(1e9 + 7)
YES = "Yes"
NO = "No"

for _ in range(int(input())):
  try:
    n = int(input())
    arr = read()

    if n == 1:
      print(YES)
      go()
    
    if n == 2:
      if sum(arr) == 0:
        print(NO)
        go() 
      else:
        print(YES)
        go()
    
    for i in range(n):
      if arr[i] == 0 and i != 0 and i != n-1:
        print(NO)
        go()
    
    idx = -1 
    for i in range(n):
      if arr[i] >= i:
        idx = i 
      else:
        break 

    cur_min = arr[idx]
    for i in range(idx + 1, n):
      if arr[i] >= cur_min:
        if cur_min == 0:
          print(NO)
          go() 
        cur_min = cur_min - 1
      else:
        cur_min = arr[i]
    print(YES)
    
  except:
    continue