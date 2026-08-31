a,b=[int(x) for x in input().split()]
c=0
stubs=0
while a>0:
  c+=a
  stubs+=a
  a=stubs//b
  stubs=stubs%b
print(c)