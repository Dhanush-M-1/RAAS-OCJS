from math import *
def kv():
  q,w,e=map(int,input().split())
  if (q==0) & (w==0) & (e==0):
      print(-1)
  elif (q==0) & (w==0):
      print(0)
  elif q==0:
      print(1)
      print("%.6f" % ((-e)/w))
  else:
      d=w*w-4*q*e
      if d<0:
          print('0')
      elif d==0:
          print('1')
          print("%.6f" % ((-w)/(2*q)))
      else:
          print('2')
          a=[((-w-sqrt(d))/(2*q)),((-w+sqrt(d))/(2*q))]
          a.sort()
          print("%.6f" % a[0])
          print("%.6f" % a[1])
kv()
