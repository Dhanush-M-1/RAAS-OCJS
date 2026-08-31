t=int(input())
for i in range(t):
  s=list(map(int,input().split(" ")))
  l=s[0]
  r=s[1]
  d=s[2]
  if(d<l):
    print(d)
  else:
    k=(r+1)//d
    rm=(r+1)%d
    #print(k)
    if(rm==0):
      print(r+1)
    else:
      print((k+1)*d)