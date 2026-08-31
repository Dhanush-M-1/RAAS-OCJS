import sys
def rs(): return sys.stdin.readline().rstrip()
def ri(): return int(sys.stdin.readline())
def ria(): return list(map(int, sys.stdin.readline().split()))
def ws(s): sys.stdout.write(s + '\n')
def wi(n): sys.stdout.write(str(n) + '\n')
def wia(a): sys.stdout.write(' '.join([str(x) for x in a]) + '\n')
import math 
from collections import defaultdict

for _ in range(ri()):
      n=ri()
      l=ria()
      x=l[0]+l[1]
      for i in range(2,n):
            if l[i]>=x:
                  print(1,2,i+1)
                  break
      else:
            print(-1)
