t=int(input())
while(t):
  n=int(input())
  s=[list(input()) for x in range(n)]
  c=0
  x1=y1=x2=y2=-1
  if(s[0][1]==s[1][0]):
    if s[n-1][n-2]==s[0][1]:
      x1,y1=n,n-1
      c+=1
    if s[n-2][n-1]==s[0][1]:
      x2,y2=n-1,n
      c+=1
    print(c)
    if x1!=-1:
      print(x1,y1)
    if x2!=-1:
      print(x2,y2)
  elif(s[n-1][n-2]==s[n-2][n-1]):
    if s[n-1][n-2]==s[0][1]:
      c+=1
      x1,y1=1,2
    if s[n-1][n-2]==s[1][0]:
      c+=1
      x2,y2=2,1
    print(c)
    if x1!=-1:
      print(x1,y1)
    if x2!=-1:
      print(x2,y2)
  else:
    c=2
    if s[n-1][n-2]==s[0][1]:
      x1,y1,x2,y2=n,n-1,2,1
    elif s[n-1][n-2]==s[1][0]:
      x1,y1,x2,y2=n,n-1,1,2
    print(c)
    print(x1,y1)
    print(x2,y2)
  t-=1