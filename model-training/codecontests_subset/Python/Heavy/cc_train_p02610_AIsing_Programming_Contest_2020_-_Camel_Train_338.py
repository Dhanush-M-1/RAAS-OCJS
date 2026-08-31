def main():
  from collections import deque
  import sys
  input = sys.stdin.readline
  from heapq import heapify,heappop,heappush
  T = int(input())
  for _ in range(T):
    N = int(input())
    KLR = [list(map(int,input().split())) for _ in range(N)]
    left = deque([])
    right = deque([])
    ans = 0
    for K,L,R in KLR:
      x = L - R
      if x==0:
        ans += L
      elif x>0:
        left.append([K,L,R])
        ans += R
      else:
        right.append([K+1,L,R])
        ans += L

    left = sorted(left)
    right = sorted(right,reverse=True)
      
    S = []
    heapify(S)
    x = 1
    i = 0
    length = len(left)
    while x<=N:
      while i<length:
        klr = left[i]
        if klr[0]==x:
          heappush(S,klr[1]-klr[2])
          i += 1
          
        else:
          break
      
      y = len(S) - x
      if y<=0:
        x += 1
        continue
      else:
        for _ in range(y):
          heappop(S)
          
    ans += sum(S)
    
    S = []
    heapify(S)
    x = N+1
    i = 0
    length = len(right)
    while x>=0:
      while i<length:
        klr = right[i]
        if klr[0]==x:
          heappush(S,klr[2]-klr[1])
          i += 1
 
        else:
          break
      
      y = len(S) + x - N - 1
      if y<=0:
        x -= 1
        continue
      else:
        for _ in range(y):
          heappop(S)    
    ans += sum(S)
    print(ans)
    
main()