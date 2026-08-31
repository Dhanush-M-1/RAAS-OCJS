t=int(input())
s=[]
for ijj in range(0,t):
  x=input().split( )
  if int(x[2])<2:
    if int(x[2])==0:
      s.append(x[0])
    else:
      s.append(x[1])
  else:    
    a=list(bin(int(x[0])))
    b=list(bin(int(x[1])))
    n=int(x[2])
    del(a[0]);del(a[0]);del(b[0]);del(b[0])
    if len(b)>len(a):
      h=len(b)-len(a)
      a.reverse()
      for i in range(0,h):
        a.append('0')
      a.reverse()
    if len(a)>len(b):
      h=len(a)-len(b)
      b.reverse()
      for i in range(0,h):
        b.append('0')
      b.reverse()
    n-=1
    m=n%3
    y=[]
    for i in range(0,len(b)):
      if a[i]==b[i]=='1':
        if m==0:
          y.append(1)
        elif m==2:
          y.append(1)
        else:
          y.append(0)
      elif a[i]==b[i]=='0':
        y.append(0)
      elif a[i]=='1' and b[i]=='0':
        if m==0:
          y.append(0)
        elif m==2:
          y.append(1)
        else:
          y.append(1)
      else:
        if m==0:
          y.append(1)
        elif m==2:
          y.append(0)
        else:
          y.append(1)
    g=0
    for i in y:
      g=g*2+i
    s.append(g)
for i in s:
  print(i)
    
  
