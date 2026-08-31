from sys import stdout
printn = lambda x: stdout.write(x)
inn = lambda : int(input())
inl   = lambda: list(map(int, input().split()))
inm   = lambda:      map(int, input().split()) 
DBG = True # and False
BIG = 999999999
R = 10**9 + 7

def ddprint(x):
  if DBG:
    print(x)


tt = inn()
for t in range(tt):
  a,b,c = inm()
  mx = 0
  for x in range(a+1):
    if x*2>b:
      break
    for y in range(b-2*x+1):
      if y*2 > c:
        continue
      z = 3*(x+y)
      if z>mx:
        mx = z 
  print(mx)
