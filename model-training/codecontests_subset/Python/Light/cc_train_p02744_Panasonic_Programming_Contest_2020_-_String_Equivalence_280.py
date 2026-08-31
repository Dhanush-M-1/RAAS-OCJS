n=int(input());s=['a']
while len(s)>0:
  t=s.pop(-1)
  if len(t)==n:print(t)
  else:
    a=max(ord(i)for i in t)
    for a in range(a+1,96,-1):s.append(t+chr(a))