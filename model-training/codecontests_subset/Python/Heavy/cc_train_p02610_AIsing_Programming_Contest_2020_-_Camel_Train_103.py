from bisect import *
from collections import defaultdict
def solve():
  T = int(input())
  ans = [0]*T
  for t in range(T):
    N = int(input())
    left = defaultdict(lambda: [])
    right = defaultdict(lambda: [])
    for i in range(N):
      k,l,r = map(int, input().split())
      if k==N:
        ans[t] += l
      else:
        if l>r:
          insort_right(left[k],l-r)
        elif l<r:
          insort_right(right[k+1],r-l)
        ans[t] += min(l,r)
    lis = []
    for i in range(N,0,-1):
      for l in left[i]:
        insort_right(lis,l)
      if len(lis):
        ans[t] += lis.pop(-1)
    lis = []
    for i in range(2,N+1):
      for r in right[i]:
        insort_right(lis,r)
      if len(lis):
        ans[t] += lis.pop(-1)
  return ans
print(*solve(),sep='\n')
