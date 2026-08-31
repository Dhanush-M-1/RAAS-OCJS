"""
instagram : essipoortahmasb2018
telegram channel : essi_python

"""
import math
i = input
n = int(i())
f = False
for j in range(n):
     
     l,r,d = map(int,i().split())
     if d not in range(l, r+1):
          print(d)
     else:
          if r%d == 0:
               print((r//d+1)*d)
          else:
               print(math.ceil(r/d) * d)
          
           #print(r+(d-(r%d)))
       
"""
5
1 1000000000 1
1 1000000000 1000000000
2 1000000000 1
1 999999999 1000000000
5 6 5
"""
