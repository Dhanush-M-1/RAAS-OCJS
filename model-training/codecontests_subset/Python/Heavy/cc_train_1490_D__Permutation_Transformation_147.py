import math
 
import sys
#def get_ints(): 
#  return map(int, sys.stdin.readline().strip().split())
def inpu():
  return sys.stdin.readline().strip()
 
T = int(input())
 
#lets = 'abcdefghijklmnopqrstuvwxyz'
#key = {lets[i]:i for i in range(26)}
n = 0

def use(ans,i):
  tb = -1
  #print(ans,i)
  for i in range(i+1,n):
    if ans[i]!=-1:
      tb = ans[i]
      break
  for i in range(i-1,-1,-1):
    if ans[i]!=-1:
      return max(tb,ans[i])+1
  return tb+1

for t in range(T):
  n = int(input())
  #n,m = map(int,input().split())
  a = list(map(int,input().split()))
  #b = inpu()
  #a = input()
  d = False
  ans = [-1]*n
  r = sorted(range(n),key = lambda i: a[i])

  for i in range(n-1,-1,-1):
    ans[r[i]] = use(ans,r[i])
    #print(ans)
  
  for i in ans:
    print(i,end = ' ')
  print()


