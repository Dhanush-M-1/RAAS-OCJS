c,d=input().split()
n=int(input())
z=[]
print(c,d)
for i in range(n):
  a,b=input().split()
  x=""
  if c==a:
    x=b
    c=x
    print(x,d)
  elif d==a:
    x=b
    d=x
    print(c,x)
  