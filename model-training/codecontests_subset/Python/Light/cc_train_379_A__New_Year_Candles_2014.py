a,b=map(int,input().split())
h,r=0,0
while a>0:
  h=h+a
  i=a+r
  a=i//b
  r=i%b
print(h)